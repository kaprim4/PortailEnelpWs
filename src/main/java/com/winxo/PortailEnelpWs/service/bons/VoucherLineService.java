package com.winxo.PortailEnelpWs.service.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherLine;

import java.util.List;

public interface VoucherLineService {

    List<VoucherLine> findAllVoucherLines();

    VoucherLine findVoucherLineById(Integer id);

    VoucherLine addVoucherLine(VoucherLine voucherType);

    VoucherLine updateVoucherLine(VoucherLine voucherType);

    void deleteVoucherLine(Integer id);
}
