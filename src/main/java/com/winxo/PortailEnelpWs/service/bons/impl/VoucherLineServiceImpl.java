package com.winxo.PortailEnelpWs.service.bons.impl;

import com.winxo.PortailEnelpWs.entities.bons.VoucherLine;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.bons.VoucherLineRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherLineService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VoucherLineServiceImpl implements VoucherLineService
{

    private final VoucherLineRepository voucherTypeRepository;

    @Autowired
    public VoucherLineServiceImpl(VoucherLineRepository voucherTypeRepository) {
        this.voucherTypeRepository = voucherTypeRepository;
    }

    public VoucherLine addVoucherLine(VoucherLine voucherLine) {
        return voucherTypeRepository.save(voucherLine);
    }

    public List<VoucherLine> findAllVoucherLines() {
        return voucherTypeRepository.findAll();
    }

    public VoucherLine updateVoucherLine(VoucherLine voucherLine) {
        return voucherTypeRepository.save(voucherLine);
    }

    public VoucherLine findVoucherLineById(Integer id) {
        return voucherTypeRepository
                .findVoucherLineById(id)
                .orElseThrow(() -> new NotFoundException("VoucherLine by id " + id + " was not found"));
    }

    public void deleteVoucherLine(Integer id) {
        voucherTypeRepository.deleteById(id);
    }
}
