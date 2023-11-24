package com.winxo.PortailEnelpWs.repository.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VoucherHeaderRepository extends JpaRepository<VoucherHeader, Integer> {
    Optional<VoucherHeader> findVoucherHeaderById(Integer id);

    @Query(value = "select max(v.slipNumber) from VoucherHeader v WHERE v.gasStation.id = :gas_station_id")
    Optional<Long> findNextVoucherHeader(Integer gas_station_id);

    @Query(value = "select v from VoucherHeader v WHERE v.slipNumber = :slipNumber")
    Optional<VoucherHeader> findVoucherHeaderBySlipNumber(Long slipNumber);
}
