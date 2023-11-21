package com.winxo.PortailEnelpWs.service.bons.impl;

import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.bons.VoucherTempRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherTempService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class VoucherTempServiceImpl implements VoucherTempService
{

    private final VoucherTempRepository voucherTempRepository;

    @Autowired
    public VoucherTempServiceImpl(VoucherTempRepository voucherTempRepository) {
        this.voucherTempRepository = voucherTempRepository;
    }

    public VoucherTemp addVoucherTemp(VoucherTemp VoucherTemp) {
        return voucherTempRepository.save(VoucherTemp);
    }

    public List<VoucherTemp> findAllVoucherTemps() {
        return voucherTempRepository.findAll();
    }

    public VoucherTemp updateVoucherTemp(VoucherTemp VoucherTemp) {
        return voucherTempRepository.save(VoucherTemp);
    }

    public VoucherTemp findVoucherTempById(Integer id) {
        return voucherTempRepository
                .findVoucherTempById(id)
                .orElseThrow(() -> new NotFoundException("VoucherTemp by id " + id + " was not found"));
    }

    public VoucherTemp findVoucherTempByVoucherNumber(String voucherNumber) {
        return voucherTempRepository
                .findVoucherTempByVoucherNumber(voucherNumber)
                .orElseThrow(() -> new NotFoundException("VoucherTemp by voucherNumber " + voucherNumber + " was not found"));
    }

    public List<?> findVoucherTempStatistic() {
        return voucherTempRepository.findVoucherTempStatistic();
    }

    public void deleteVoucherTemp(Integer id) {
        voucherTempRepository.deleteById(id);
    }
}
