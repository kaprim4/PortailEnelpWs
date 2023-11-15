package com.winxo.PortailEnelpWs.repository.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VoucherTypeRepository extends JpaRepository<VoucherType, Integer> {

    @Query(value = "select g from VoucherType g where g.id = :id")
    Optional<VoucherType> findVoucherTypeById(Integer id);
}
