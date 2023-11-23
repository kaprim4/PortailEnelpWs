package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherType;
import com.winxo.PortailEnelpWs.repository.bons.VoucherTypeRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-type")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherTypeController {

    private final VoucherTypeService voucherTypeService;

    @Autowired
    private VoucherTypeRepository gasStationRepository;

    @GetMapping("/all")
    public ResponseEntity<List<VoucherType>> getAllVoucherTypes () {
        List<VoucherType> voucherType = voucherTypeService.findAllVoucherTypes();
        return new ResponseEntity<>(voucherType, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VoucherType> addVoucherType(@RequestBody VoucherType voucherType) {
        voucherType.setIsDeleted(false);
        VoucherType user_added = voucherTypeService.addVoucherType(voucherType);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VoucherType> getVoucherTypeById (@PathVariable("id") Integer id) {
        Optional<VoucherType> voucherTypeOptional = gasStationRepository.findById(id);
        if (voucherTypeOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherType voucherType_found = voucherTypeService.findVoucherTypeById(id);
        return new ResponseEntity<>(voucherType_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<VoucherType> updateVoucherType(@RequestBody VoucherType voucherType) {
        Optional<VoucherType> voucherTypeOptional = gasStationRepository.findVoucherTypeById(voucherType.getId());
        if (voucherTypeOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        voucherType.setIsDeleted(false);
        gasStationRepository.save(voucherType);
        System.out.println(voucherType);
        return new ResponseEntity<>(voucherType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVoucherType(@PathVariable("id") Integer id) {
        Optional<VoucherType> voucherTypeOptional = gasStationRepository.findVoucherTypeById(id);
        if (voucherTypeOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        voucherTypeService.deleteVoucherType(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
