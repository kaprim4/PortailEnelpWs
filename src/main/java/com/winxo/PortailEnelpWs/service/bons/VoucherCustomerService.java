package com.winxo.PortailEnelpWs.service.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherCustomer;

import java.util.List;

public interface VoucherCustomerService {

    List<VoucherCustomer> findAllVoucherCustomers();

    VoucherCustomer findVoucherCustomerById(Integer id);

    VoucherCustomer addVoucherCustomer(VoucherCustomer voucherTemp);

    VoucherCustomer updateVoucherCustomer(VoucherCustomer voucherTemp);

    void deleteVoucherCustomer(Integer id);
}
