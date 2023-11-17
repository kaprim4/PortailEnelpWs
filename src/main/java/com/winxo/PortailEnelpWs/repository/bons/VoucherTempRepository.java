package com.winxo.PortailEnelpWs.repository.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherTempRepository extends JpaRepository<VoucherTemp, Integer> {

    Optional<VoucherTemp> findVoucherTempById(Integer id);
    Optional<VoucherTemp> findVoucherTempByVoucherNumber(String voucherNumber);
}
