package com.winxo.PortailEnelpWs.service.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherControl;

import java.util.List;

public interface VoucherControlService {

    List<VoucherControl> findAllVoucherControls();

    VoucherControl findVoucherControlById(Integer id);

    VoucherControl findVoucherControlByVoucherNumber(String voucherNumber);

    VoucherControl addVoucherControl(VoucherControl voucherTemp);

    VoucherControl updateVoucherControl(VoucherControl voucherTemp);

    void deleteVoucherControl(Integer id);
}
