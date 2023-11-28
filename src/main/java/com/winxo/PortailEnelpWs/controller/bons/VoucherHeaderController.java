package com.winxo.PortailEnelpWs.controller.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;
import com.winxo.PortailEnelpWs.entities.bons.VoucherHeaderResponse;
import com.winxo.PortailEnelpWs.entities.upload.ResponseHeader;
import com.winxo.PortailEnelpWs.repository.bons.VoucherHeaderRepository;
import com.winxo.PortailEnelpWs.repository.bons.VoucherTempRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherHeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/vouchers-header")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoucherHeaderController {

    private final VoucherHeaderService voucherHeaderService;
    private final VoucherTempRepository voucherTempRepository;

    @Autowired
    private VoucherHeaderRepository voucherHeaderRepository;

    @GetMapping("/all")
    public ResponseEntity<List<VoucherHeaderResponse>> getAllVoucherHeaders () {
        List<VoucherHeader> voucherHeaders = voucherHeaderService.findAllVoucherHeaders();
        List<VoucherHeaderResponse> result = new ArrayList<>();
        for (VoucherHeader voucherHeader: voucherHeaders) {
            Integer count = voucherTempRepository.getVoucherCountByHeader(voucherHeader.getId());
            Long sum = voucherTempRepository.getVoucherSumByHeader(voucherHeader.getId());
            VoucherHeaderResponse voucherHeaderResponse = new VoucherHeaderResponse();
            voucherHeaderResponse.setId(voucherHeader.getId());
            voucherHeaderResponse.setVoucherHeader(voucherHeader);
            voucherHeaderResponse.setVoucherCount(count != null ? count : 0);
            voucherHeaderResponse.setVoucherSum(sum != null ? sum : 0);
            result.add(voucherHeaderResponse);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
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

    @GetMapping("/find/opened")
    public ResponseEntity<?> getLastVoucherHeaderOpened () {
        Optional<VoucherHeader> voucherHeaderOptional = voucherHeaderRepository.findLastVoucherHeaderOpened();
        if (voucherHeaderOptional.isEmpty())
            return new ResponseEntity<>(voucherHeaderOptional, HttpStatus.OK);
        VoucherHeader voucherHeader = voucherHeaderService.findLastVoucherHeaderOpened();
        return new ResponseEntity<>(voucherHeader, HttpStatus.OK);
    }

    @GetMapping("/find/slip_number/{slipNumber}")
    public ResponseEntity<VoucherHeader> getVoucherHeaderBySlipNumber (@PathVariable("slipNumber") Long slipNumber) {
        Optional<VoucherHeader> voucherHeaderOptional = voucherHeaderRepository.findVoucherHeaderBySlipNumber(slipNumber);
        if (voucherHeaderOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        VoucherHeader voucherHeader = voucherHeaderService.findVoucherHeaderBySlipNumber(slipNumber);
        return new ResponseEntity<>(voucherHeader, HttpStatus.OK);
    }

    @GetMapping("/find/next/{gas_station_id}")
    public ResponseEntity<ResponseHeader> getNextVoucherHeader (@PathVariable("gas_station_id") Integer gas_station_id) {
        Optional<Long> nextVoucherHeader = voucherHeaderRepository.findNextVoucherHeader(gas_station_id);
        Long maxSlipNumber = 0L;
        Long nextSlipNumber = 1L;
        ResponseHeader responseHeader = new ResponseHeader(
                gas_station_id,
                maxSlipNumber,
                nextSlipNumber
        );
        if (nextVoucherHeader.isEmpty()){
            return new ResponseEntity<>(responseHeader, HttpStatus.OK);
        }
        maxSlipNumber = voucherHeaderService.findNextVoucherHeader(gas_station_id);
        responseHeader.setMaxSlipNumber(maxSlipNumber);
        responseHeader.setNextSlipNumber(maxSlipNumber+1);
        return new ResponseEntity<>(responseHeader, HttpStatus.OK);
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
