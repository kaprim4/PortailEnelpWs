package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherLine;
import com.winxo.PortailEnelpWs.repository.bons.VoucherLineRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-line")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherLineController {

    private final VoucherLineService voucherLineService;

    @Autowired
    private VoucherLineRepository voucherLineRepository;

    @GetMapping("/all")
    public ResponseEntity<List<VoucherLine>> getAllVoucherLines () {
        List<VoucherLine> voucherLines = voucherLineService.findAllVoucherLines();
        return new ResponseEntity<>(voucherLines, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VoucherLine> addVoucherLine(@RequestBody VoucherLine voucherLine) {
        voucherLine.setIsDeleted(false);
        VoucherLine voucherLine1 = voucherLineService.addVoucherLine(voucherLine);
        return new ResponseEntity<>(voucherLine1, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VoucherLine> getVoucherLineById (@PathVariable("id") Integer id) {
        Optional<VoucherLine> voucherLineOptional = voucherLineRepository.findById(id);
        if (voucherLineOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherLine voucherLine = voucherLineService.findVoucherLineById(id);
        return new ResponseEntity<>(voucherLine, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<VoucherLine> updateVoucherLine(@RequestBody VoucherLine voucherLine) {
        Optional<VoucherLine> userOptional = voucherLineRepository.findVoucherLineById(voucherLine.getId());
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        voucherLine.setIsDeleted(false);
        voucherLineRepository.save(voucherLine);
        System.out.println(voucherLine);
        return new ResponseEntity<>(voucherLine, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VoucherLine> deleteVoucherLine(@PathVariable("id") Integer id) {
        Optional<VoucherLine> voucherLineOptional = voucherLineRepository.findVoucherLineById(id);
        if (voucherLineOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherLine voucherLine = voucherLineService.findVoucherLineById(id);
        voucherLineService.deleteVoucherLine(voucherLine.getId());
        return new ResponseEntity<>(voucherLine, HttpStatus.OK);
    }
}
