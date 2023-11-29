package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.Company;
import com.winxo.PortailEnelpWs.entities.Supervisor;
import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;
import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import com.winxo.PortailEnelpWs.entities.bons.VoucherType;
import com.winxo.PortailEnelpWs.repository.bons.VoucherTempRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherHeaderService;
import com.winxo.PortailEnelpWs.service.bons.VoucherTempService;
import com.winxo.PortailEnelpWs.service.bons.VoucherTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-temp")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherTempController {

    private final VoucherTempService voucherTempService;
    private final VoucherHeaderService voucherHeaderService;
    private final VoucherTypeService voucherTypeService;

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

    @GetMapping("/find/header/{header_id}")
    public ResponseEntity<?> getVoucherTempByHeader (@PathVariable("header_id") Integer header_id) {
        List<VoucherTemp> voucherTempOptional = voucherTempRepository.findVoucherTempByHeader(header_id);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(voucherTempOptional, HttpStatus.OK);
        List<VoucherTemp> voucherTemp = voucherTempService.findVoucherTempByHeader(header_id);
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
        if (voucherTempRepository.findVoucherTempById(voucherTemp.getId()).isPresent()) {
            VoucherTemp voucherTemp1 = voucherTempRepository.findVoucherTempById(voucherTemp.getId()).get();
            VoucherHeader voucherHeader = voucherHeaderService.findVoucherHeaderById(voucherTemp.getVoucherHeader().getId());
            VoucherType voucherType = voucherTypeService.findVoucherTypeById(voucherTemp.getVoucherType().getId());
            voucherTemp1.setVoucherHeader(voucherHeader);
            voucherTemp1.setVoucherType(voucherType);
            voucherTemp1.setGasStationOrigin(voucherTemp.getGasStationOrigin());
            voucherTemp1.setVoucherNumber(voucherTemp.getVoucherNumber());
            voucherTemp1.setVoucherAmount(voucherTemp.getVoucherAmount());
            voucherTemp1.setVehiculeNumber(voucherTemp.getVehiculeNumber());
            voucherTemp1.setBarcode(voucherTemp.getBarcode());
            voucherTemp1.setPoste_produit(voucherTemp.getPoste_produit());
            voucherTemp1.setUpdatedAt(LocalDateTime.now());
            voucherTemp1.setIsDeleted(false);
            voucherTemp1.setIsActivated(voucherTemp.getIsActivated());
            voucherTempRepository.save(voucherTemp1);
            System.out.println(voucherTemp1);
            return new ResponseEntity<>(voucherTemp1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
