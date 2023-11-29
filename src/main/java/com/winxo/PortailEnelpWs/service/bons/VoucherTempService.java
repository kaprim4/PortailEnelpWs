package com.winxo.PortailEnelpWs.service.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import java.util.List;

public interface VoucherTempService {

    List<VoucherTemp> findAllVoucherTemps();

    VoucherTemp findVoucherTempById(Integer id);

    VoucherTemp findVoucherTempByVoucherNumber(String voucherNumber);

    List<VoucherTemp> findVoucherTempByHeader(Integer id);

    List<?> findVoucherTempStatistic();

    VoucherTemp addVoucherTemp(VoucherTemp voucherTemp);

    VoucherTemp updateVoucherTemp(VoucherTemp voucherTemp);

    void deleteVoucherTemp(Integer id);
}
