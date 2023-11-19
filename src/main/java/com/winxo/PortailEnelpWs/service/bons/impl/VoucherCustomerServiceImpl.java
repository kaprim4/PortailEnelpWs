package com.winxo.PortailEnelpWs.service.bons.impl;

import com.winxo.PortailEnelpWs.entities.bons.VoucherCustomer;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.bons.VoucherCustomerRepository;
import com.winxo.PortailEnelpWs.service.bons.VoucherCustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class VoucherCustomerServiceImpl implements VoucherCustomerService
{

    private final VoucherCustomerRepository voucherTempRepository;

    @Autowired
    public VoucherCustomerServiceImpl(VoucherCustomerRepository voucherTempRepository) {
        this.voucherTempRepository = voucherTempRepository;
    }

    public VoucherCustomer addVoucherCustomer(VoucherCustomer VoucherCustomer) {
        return voucherTempRepository.save(VoucherCustomer);
    }

    public List<VoucherCustomer> findAllVoucherCustomers() {
        return voucherTempRepository.findAll();
    }

    public VoucherCustomer updateVoucherCustomer(VoucherCustomer VoucherCustomer) {
        return voucherTempRepository.save(VoucherCustomer);
    }

    public VoucherCustomer findVoucherCustomerById(Integer id) {
        return voucherTempRepository
                .findVoucherCustomerById(id)
                .orElseThrow(() -> new NotFoundException("VoucherCustomer by id " + id + " was not found"));
    }

    public void deleteVoucherCustomer(Integer id) {
        voucherTempRepository.deleteById(id);
    }
}
