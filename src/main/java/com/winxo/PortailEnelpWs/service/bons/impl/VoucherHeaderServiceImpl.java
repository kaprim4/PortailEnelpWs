package com.winxo.PortailEnelpWs.service.bons.impl;

import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.bons.VoucherHeaderRepository;
import com.winxo.PortailEnelpWs.repository.bons.VoucherTempRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherHeaderService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VoucherHeaderServiceImpl implements VoucherHeaderService
{

    private final VoucherHeaderRepository voucherHeaderRepository;
    private final VoucherTempRepository voucherTempRepository;

    @Autowired
    public VoucherHeaderServiceImpl(VoucherHeaderRepository voucherTypeRepository, VoucherTempRepository voucherTempRepository) {
        this.voucherHeaderRepository = voucherTypeRepository;
        this.voucherTempRepository = voucherTempRepository;
    }

    public VoucherHeader addVoucherHeader(VoucherHeader voucherHeader) {
        return voucherHeaderRepository.save(voucherHeader);
    }

    public List<VoucherHeader> findAllVoucherHeaders() {
        return voucherHeaderRepository.findAll();
    }

    public VoucherHeader updateVoucherHeader(VoucherHeader voucherHeader) {
        return voucherHeaderRepository.save(voucherHeader);
    }

    public VoucherHeader findVoucherHeaderById(Integer id) {
        return voucherHeaderRepository
                .findVoucherHeaderById(id)
                .orElseThrow(() -> new NotFoundException("VoucherHeader by id " + id + " was not found"));
    }

    public VoucherHeader findVoucherHeaderBySlipNumber(Long slipNumber) {
        return voucherHeaderRepository
                .findVoucherHeaderBySlipNumber(slipNumber)
                .orElseThrow(() -> new NotFoundException("VoucherHeader by slipNumber " + slipNumber + " was not found"));
    }

    public VoucherHeader findLastVoucherHeaderOpened() {
        return voucherHeaderRepository
                .findLastVoucherHeaderOpened()
                .orElseThrow(() -> new NotFoundException("VoucherHeader was not found"));
    }

    public Long findNextVoucherHeader(Integer gas_station_id) {
        return voucherHeaderRepository
                .findNextVoucherHeader(gas_station_id)
                .orElseThrow(() -> new NotFoundException("Next VoucherHeader Number was not found"));
    }

    public void deleteVoucherHeader(Integer id) {
        voucherHeaderRepository.deleteById(id);
    }
}
