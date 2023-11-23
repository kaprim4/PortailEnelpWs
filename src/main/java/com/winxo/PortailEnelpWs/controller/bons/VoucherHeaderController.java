package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;
import com.winxo.PortailEnelpWs.repository.bons.VoucherHeaderRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherHeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-header")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherHeaderController {

    private final VoucherHeaderService voucherHeaderService;

    @Autowired
    private VoucherHeaderRepository voucherHeaderRepository;

    @GetMapping("/all")
    public ResponseEntity<List<VoucherHeader>> getAllVoucherHeaders () {
        List<VoucherHeader> voucherHeaders = voucherHeaderService.findAllVoucherHeaders();
        return new ResponseEntity<>(voucherHeaders, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VoucherHeader> addVoucherHeader(@RequestBody VoucherHeader voucherHeader) {
        voucherHeader.setIsDeleted(false);
        VoucherHeader voucherHeader1 = voucherHeaderService.addVoucherHeader(voucherHeader);
        return new ResponseEntity<>(voucherHeader1, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VoucherHeader> getVoucherHeaderById (@PathVariable("id") Integer id) {
        Optional<VoucherHeader> voucherHeaderOptional = voucherHeaderRepository.findById(id);
        if (voucherHeaderOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherHeader voucherHeader = voucherHeaderService.findVoucherHeaderById(id);
        return new ResponseEntity<>(voucherHeader, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<VoucherHeader> updateVoucherHeader(@RequestBody VoucherHeader voucherHeader) {
        Optional<VoucherHeader> userOptional = voucherHeaderRepository.findVoucherHeaderById(voucherHeader.getId());
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        voucherHeader.setIsDeleted(false);
        voucherHeaderRepository.save(voucherHeader);
        System.out.println(voucherHeader);
        return new ResponseEntity<>(voucherHeader, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VoucherHeader> deleteVoucherHeader(@PathVariable("id") Integer id) {
        Optional<VoucherHeader> voucherHeaderOptional = voucherHeaderRepository.findVoucherHeaderById(id);
        if (voucherHeaderOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherHeader voucherHeader = voucherHeaderService.findVoucherHeaderById(id);
        voucherHeaderService.deleteVoucherHeader(voucherHeader.getId());
        return new ResponseEntity<>(voucherHeader, HttpStatus.OK);
    }
}
