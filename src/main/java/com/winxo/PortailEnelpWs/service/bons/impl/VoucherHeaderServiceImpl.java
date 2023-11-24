package com.winxo.PortailEnelpWs.service.bons.impl;

import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.bons.VoucherHeaderRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherHeaderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VoucherHeaderServiceImpl implements VoucherHeaderService
{

    private final VoucherHeaderRepository voucherTypeRepository;

    @Autowired
    public VoucherHeaderServiceImpl(VoucherHeaderRepository voucherTypeRepository) {
        this.voucherTypeRepository = voucherTypeRepository;
    }

    public VoucherHeader addVoucherHeader(VoucherHeader voucherHeader) {
        return voucherTypeRepository.save(voucherHeader);
    }

    public List<VoucherHeader> findAllVoucherHeaders() {
        return voucherTypeRepository.findAll();
    }

    public VoucherHeader updateVoucherHeader(VoucherHeader voucherHeader) {
        return voucherTypeRepository.save(voucherHeader);
    }

    public VoucherHeader findVoucherHeaderById(Integer id) {
        return voucherTypeRepository
                .findVoucherHeaderById(id)
                .orElseThrow(() -> new NotFoundException("VoucherHeader by id " + id + " was not found"));
    }

    public VoucherHeader findVoucherHeaderBySlipNumber(Long slipNumber) {
        return voucherTypeRepository
                .findVoucherHeaderBySlipNumber(slipNumber)
                .orElseThrow(() -> new NotFoundException("VoucherHeader by slipNumber " + slipNumber + " was not found"));
    }

    public Long findNextVoucherHeader(Integer gas_station_id) {
        return voucherTypeRepository
                .findNextVoucherHeader(gas_station_id)
                .orElseThrow(() -> new NotFoundException("Next VoucherHeader Number was not found"));
    }

    public void deleteVoucherHeader(Integer id) {
        voucherTypeRepository.deleteById(id);
    }
}
