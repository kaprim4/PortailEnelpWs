package com.winxo.PortailEnelpWs.repository.bons;

import com.winxo.PortailEnelpWs.entities.bons.VoucherHeader;
import com.winxo.PortailEnelpWs.entities.bons.VoucherTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface VoucherTempRepository extends JpaRepository<VoucherTemp, Integer> {

    Optional<VoucherTemp> findVoucherTempById(Integer id);
    Optional<VoucherTemp> findVoucherTempByVoucherNumber(String voucherNumber);

    @Query("SELECT v.voucherType, SUM(v.voucherAmount) AS voucherAmount, COUNT(v.id) AS voucherCount  FROM VoucherTemp v GROUP BY v.voucherType")
    List<?> findVoucherTempStatistic();

    @Query("SELECT COUNT(v.id) FROM VoucherTemp v WHERE v.voucherHeader.id = :id")
    Integer getVoucherCountByHeader(Integer id);

    @Query("SELECT SUM(v.voucherAmount)  FROM VoucherTemp v WHERE v.voucherHeader.id = :id")
    Long getVoucherSumByHeader(Integer id);
}
