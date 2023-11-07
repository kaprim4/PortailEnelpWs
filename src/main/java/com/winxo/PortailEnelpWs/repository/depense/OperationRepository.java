package com.winxo.PortailEnelpWs.repository.depense;

import com.winxo.PortailEnelpWs.entities.depense.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
    Optional<Operation> findOperationById(Integer id);
    void deleteOperationById(Integer id);
}
