package com.winxo.PortailEnelpWs.service.bons.impl;

import com.winxo.PortailEnelpWs.entities.bons.VoucherControl;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.bons.VoucherControlRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherControlService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class VoucherControlServiceImpl implements VoucherControlService
{

    private final VoucherControlRepository voucherControlRepository;

    @Autowired
    public VoucherControlServiceImpl(VoucherControlRepository voucherTempRepository) {
        this.voucherControlRepository = voucherTempRepository;
    }

    public VoucherControl addVoucherControl(VoucherControl VoucherControl) {
        return voucherControlRepository.save(VoucherControl);
    }

    public List<VoucherControl> findAllVoucherControls() {
        return voucherControlRepository.findAll();
    }

    public VoucherControl updateVoucherControl(VoucherControl VoucherControl) {
        return voucherControlRepository.save(VoucherControl);
    }

    public VoucherControl findVoucherControlByVoucherNumber(String voucherNumber) {
        return voucherControlRepository
                .findVoucherControlByVoucherNumber(voucherNumber)
                .orElseThrow(() -> new NotFoundException("VoucherTemp by voucherNumber " + voucherNumber + " was not found"));
    }

    public VoucherControl findVoucherControlById(Integer id) {
        return voucherControlRepository
                .findVoucherControlById(id)
                .orElseThrow(() -> new NotFoundException("VoucherControl by id " + id + " was not found"));
    }

    public void deleteVoucherControl(Integer id) {
        voucherControlRepository.deleteById(id);
    }
}
