package com.winxo.PortailEnelpWs.repository.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VoucherHeaderRepository extends JpaRepository<VoucherHeader, Integer> {
    Optional<VoucherHeader> findVoucherHeaderById(Integer id);
}
