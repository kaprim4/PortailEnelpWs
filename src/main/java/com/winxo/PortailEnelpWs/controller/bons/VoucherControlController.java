package com.winxo.PortailEnelpWs.controller.bons;

import com.fasterxml.jackson.annotation.JsonView;
import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.bons.VoucherControl;
import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import com.winxo.PortailEnelpWs.entities.views.View;
import com.winxo.PortailEnelpWs.repository.bons.VoucherControlRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-control")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherControlController {

    private final VoucherControlService voucherControlService;

    @Autowired
    private VoucherControlRepository voucherControlRepository;

    @GetMapping("/all")
    @JsonView(View.Summary.class)
    public ResponseEntity<List<VoucherControl>> getAllVoucherControls () {
        List<VoucherControl> voucherTemps = voucherControlService.findAllVoucherControls();
        return new ResponseEntity<>(voucherTemps, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VoucherControl> addVoucherControl(@RequestBody VoucherControl voucherTemp) {
        voucherTemp.setIsDeleted(false);
        VoucherControl voucherTemp1 = voucherControlService.addVoucherControl(voucherTemp);
        System.out.println(voucherTemp1);
        return new ResponseEntity<>(voucherTemp1, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VoucherControl> getVoucherControlById (@PathVariable("id") Integer id) {
        Optional<VoucherControl> voucherTempOptional = voucherControlRepository.findById(id);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherControl voucherTemp = voucherControlService.findVoucherControlById(id);
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

    @GetMapping("/find/number/{voucherNumber}")
    public ResponseEntity<VoucherControl> getVoucherTempByVoucherNumber (@PathVariable("voucherNumber") String voucherNumber) {
        Optional<VoucherControl> voucherControlOptional = voucherControlRepository.findVoucherControlByVoucherNumber(voucherNumber);
        if (voucherControlOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.OK);
        VoucherControl voucherControl = voucherControlService.findVoucherControlByVoucherNumber(voucherNumber);
        return new ResponseEntity<>(voucherControl, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<VoucherControl> updateVoucherControl(@RequestBody VoucherControl voucherControl) {
        if (voucherControlRepository.findVoucherControlById(voucherControl.getId()).isPresent()) {
            VoucherControl voucherControl1 = voucherControlRepository.findVoucherControlById(voucherControl.getId()).get();
            voucherControl1.setVoucherAmount(voucherControl.getVoucherAmount());
            voucherControl1.setVoucherCustomer(voucherControl.getVoucherCustomer());
            voucherControl1.setVoucherNumber(voucherControl.getVoucherNumber());
            voucherControl1.setNewlyAdded(voucherControl.getNewlyAdded());
            voucherControl1.setUpdatedAt(LocalDateTime.now());
            voucherControl1.setIsDeleted(false);
            voucherControl1.setIsActivated(voucherControl.getIsActivated());
            voucherControlRepository.save(voucherControl1);
            System.out.println(voucherControl1);
            return new ResponseEntity<>(voucherControl1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VoucherControl> deleteVoucherControl(@PathVariable("id") Integer id) {
        Optional<VoucherControl> voucherTempOptional = voucherControlRepository.findVoucherControlById(id);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherControl voucherTemp = voucherControlService.findVoucherControlById(id);
        voucherControlService.deleteVoucherControl(voucherTemp.getId());
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

}
