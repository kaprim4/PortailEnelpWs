package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import com.winxo.PortailEnelpWs.repository.bons.VoucherTempRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherTempService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-temp")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherTempController {

    private final VoucherTempService voucherTempService;

    @Autowired
    private VoucherTempRepository voucherTempRepository;

    @GetMapping("/all")
    public ResponseEntity<List<VoucherTemp>> getAllVoucherTemps () {
        List<VoucherTemp> voucherTemps = voucherTempService.findAllVoucherTemps();
        return new ResponseEntity<>(voucherTemps, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VoucherTemp> addVoucherTemp(@RequestBody VoucherTemp voucherTemp) {
        voucherTemp.setIsDeleted(false);
        VoucherTemp voucherTemp1 = voucherTempService.addVoucherTemp(voucherTemp);
        System.out.println(voucherTemp1);
        return new ResponseEntity<>(voucherTemp1, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VoucherTemp> getVoucherTempById (@PathVariable("id") Integer id) {
        Optional<VoucherTemp> voucherTempOptional = voucherTempRepository.findById(id);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherTemp voucherTemp = voucherTempService.findVoucherTempById(id);
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

    @GetMapping("/find/number/{voucherNumber}")
    public ResponseEntity<VoucherTemp> getVoucherTempByVoucherNumber (@PathVariable("voucherNumber") String voucherNumber) {
        Optional<VoucherTemp> voucherTempOptional = voucherTempRepository.findVoucherTempByVoucherNumber(voucherNumber);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.OK);
        VoucherTemp voucherTemp = voucherTempService.findVoucherTempByVoucherNumber(voucherNumber);
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

    @GetMapping("/find/sum")
    public ResponseEntity<List<?>> findVoucherTempStatistic () {
        List<?> voucherNumber = voucherTempRepository.findVoucherTempStatistic();
        if (voucherNumber.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        List<?> voucherTempStatistic = voucherTempService.findVoucherTempStatistic();
        return new ResponseEntity<>(voucherTempStatistic, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<VoucherTemp> updateVoucherTemp(@RequestBody VoucherTemp voucherTemp) {
        Optional<VoucherTemp> userOptional = voucherTempRepository.findVoucherTempById(voucherTemp.getId());
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        voucherTemp.setIsDeleted(false);
        voucherTempRepository.save(voucherTemp);
        System.out.println(voucherTemp);
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VoucherTemp> deleteVoucherTemp(@PathVariable("id") Integer id) {
        Optional<VoucherTemp> voucherTempOptional = voucherTempRepository.findVoucherTempById(id);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherTemp voucherTemp = voucherTempService.findVoucherTempById(id);
        voucherTempService.deleteVoucherTemp(voucherTemp.getId());
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

}
