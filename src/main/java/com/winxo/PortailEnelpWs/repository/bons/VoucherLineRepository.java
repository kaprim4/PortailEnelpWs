package com.winxo.PortailEnelpWs.repository.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherLine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VoucherLineRepository extends JpaRepository<VoucherLine, Integer> {
    Optional<VoucherLine> findVoucherLineById(Integer id);
}
