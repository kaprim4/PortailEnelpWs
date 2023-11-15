package com.winxo.PortailEnelpWs.service.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherType;

import java.util.List;

public interface VoucherTypeService {

    List<VoucherType> findAllVoucherTypes();

    VoucherType findVoucherTypeById(Integer id);

    VoucherType addVoucherType(VoucherType voucherType);

    VoucherType updateVoucherType(VoucherType voucherType);

    void deleteVoucherType(Integer id);
}
