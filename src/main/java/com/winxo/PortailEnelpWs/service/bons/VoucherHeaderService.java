package com.winxo.PortailEnelpWs.service.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;

import java.util.List;

public interface VoucherHeaderService {

    List<VoucherHeader> findAllVoucherHeaders();

    VoucherHeader findVoucherHeaderById(Integer id);

    VoucherHeader addVoucherHeader(VoucherHeader voucherType);

    VoucherHeader updateVoucherHeader(VoucherHeader voucherType);

    void deleteVoucherHeader(Integer id);
}
