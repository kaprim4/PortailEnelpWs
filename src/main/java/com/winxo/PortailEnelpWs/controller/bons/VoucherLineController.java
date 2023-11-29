package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.bons.VoucherLine;
import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import com.winxo.PortailEnelpWs.repository.bons.VoucherLineRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherLineService;
import com.winxo.PortailEnelpWs.service.bons.VoucherTempService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-line")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherLineController {

    private final VoucherLineService voucherLineService;
    private final VoucherTempService voucherTempService;

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
        if (voucherLineRepository.findVoucherLineById(voucherLine.getId()).isPresent()) {
            VoucherLine voucherLine1 = voucherLineRepository.findVoucherLineById(voucherLine.getId()).get();
            VoucherTemp voucherTemp = voucherTempService.findVoucherTempById(voucherLine.getVoucherTemp().getId());
            voucherLine1.setVoucherTemp(voucherTemp);
            voucherLine1.setUpdatedAt(LocalDateTime.now());
            voucherLine1.setIsDeleted(false);
            voucherLine1.setIsActivated(voucherLine.getIsActivated());
            voucherLineRepository.save(voucherLine1);
            System.out.println(voucherLine1);
            return new ResponseEntity<>(voucherLine1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
