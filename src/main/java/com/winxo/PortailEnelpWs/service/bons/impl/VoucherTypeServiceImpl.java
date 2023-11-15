package com.winxo.PortailEnelpWs.service.bons.impl;

import com.winxo.PortailEnelpWs.entities.bons.VoucherType;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.bons.VoucherTypeRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherTypeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VoucherTypeServiceImpl implements VoucherTypeService
{

    private final VoucherTypeRepository voucherTypeRepository;

    @Autowired
    public VoucherTypeServiceImpl(VoucherTypeRepository voucherTypeRepository) {
        this.voucherTypeRepository = voucherTypeRepository;
    }

    public VoucherType addVoucherType(VoucherType VoucherType) {
        return voucherTypeRepository.save(VoucherType);
    }

    public List<VoucherType> findAllVoucherTypes() {
        return voucherTypeRepository.findAll();
    }

    public VoucherType updateVoucherType(VoucherType VoucherType) {
        return voucherTypeRepository.save(VoucherType);
    }

    public VoucherType findVoucherTypeById(Integer id) {
        return voucherTypeRepository
                .findVoucherTypeById(id)
                .orElseThrow(() -> new NotFoundException("VoucherType by id " + id + " was not found"));
    }

    public void deleteVoucherType(Integer id) {
        voucherTypeRepository.deleteById(id);
    }
}
