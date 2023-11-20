package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherControl;
import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import com.winxo.PortailEnelpWs.repository.bons.VoucherControlRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherControlService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Optional<VoucherControl> voucherTempOptional = voucherControlRepository.findVoucherControlByVoucherNumber(voucherNumber);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherControl voucherTemp = voucherControlService.findVoucherControlByVoucherNumber(voucherNumber);
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<VoucherControl> updateVoucherControl(@RequestBody VoucherControl voucherTemp) {
        Optional<VoucherControl> userOptional = voucherControlRepository.findVoucherControlById(voucherTemp.getId());
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        voucherTemp.setIsDeleted(false);
        voucherControlRepository.save(voucherTemp);
        System.out.println(voucherTemp);
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
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
