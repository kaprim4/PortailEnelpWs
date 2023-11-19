package com.winxo.PortailEnelpWs.repository.bons;


import com.winxo.PortailEnelpWs.entities.bons.VoucherCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherCustomerRepository extends JpaRepository<VoucherCustomer, Integer> {

    Optional<VoucherCustomer> findVoucherCustomerById(Integer id);
}
