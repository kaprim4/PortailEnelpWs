package com.winxo.PortailEnelpWs.service.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;

import java.util.List;
import java.util.Optional;

public interface VoucherHeaderService {

    List<VoucherHeader> findAllVoucherHeaders();

    VoucherHeader findVoucherHeaderById(Integer id);

    VoucherHeader findVoucherHeaderBySlipNumber(Long slipNumber);

    Long findNextVoucherHeader(Integer gas_station_id);

    VoucherHeader addVoucherHeader(VoucherHeader voucherType);

    VoucherHeader updateVoucherHeader(VoucherHeader voucherType);

    void deleteVoucherHeader(Integer id);
}
