package com.winxo.PortailEnelpWs.repository.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherControl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherControlRepository extends JpaRepository<VoucherControl, Integer> {

    Optional<VoucherControl> findVoucherControlById(Integer id);
}
