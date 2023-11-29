package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.bons.VoucherCustomer;
import com.winxo.PortailEnelpWs.repository.bons.VoucherCustomerRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherCustomerController {

    private final VoucherCustomerService voucherCustomerService;

    @Autowired
    private VoucherCustomerRepository voucherCustomerRepository;

    @GetMapping("/all")
    public ResponseEntity<List<VoucherCustomer>> getAllVoucherCustomers () {
        List<VoucherCustomer> voucherTemps = voucherCustomerService.findAllVoucherCustomers();
        return new ResponseEntity<>(voucherTemps, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VoucherCustomer> addVoucherCustomer(@RequestBody VoucherCustomer voucherTemp) {
        voucherTemp.setIsDeleted(false);
        VoucherCustomer voucherTemp1 = voucherCustomerService.addVoucherCustomer(voucherTemp);
        System.out.println(voucherTemp1);
        return new ResponseEntity<>(voucherTemp1, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VoucherCustomer> getVoucherCustomerById (@PathVariable("id") Integer id) {
        Optional<VoucherCustomer> voucherTempOptional = voucherCustomerRepository.findById(id);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherCustomer voucherTemp = voucherCustomerService.findVoucherCustomerById(id);
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<VoucherCustomer> updateVoucherCustomer(@RequestBody VoucherCustomer voucherCustomer) {
        if (voucherCustomerRepository.findVoucherCustomerById(voucherCustomer.getId()).isPresent()) {
            VoucherCustomer voucherCustomer1 = voucherCustomerRepository.findVoucherCustomerById(voucherCustomer.getId()).get();
            voucherCustomer1.setLibelle(voucherCustomer.getLibelle());
            voucherCustomer1.setCodeSap(voucherCustomer.getCodeSap());
            voucherCustomer1.setUpdatedAt(LocalDateTime.now());
            voucherCustomer1.setIsDeleted(false);
            voucherCustomer1.setIsActivated(voucherCustomer.getIsActivated());
            voucherCustomerRepository.save(voucherCustomer1);
            System.out.println(voucherCustomer1);
            return new ResponseEntity<>(voucherCustomer1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VoucherCustomer> deleteVoucherCustomer(@PathVariable("id") Integer id) {
        Optional<VoucherCustomer> voucherTempOptional = voucherCustomerRepository.findVoucherCustomerById(id);
        if (voucherTempOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherCustomer voucherTemp = voucherCustomerService.findVoucherCustomerById(id);
        voucherCustomerService.deleteVoucherCustomer(voucherTemp.getId());
        return new ResponseEntity<>(voucherTemp, HttpStatus.OK);
    }

}
