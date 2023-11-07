package com.winxo.PortailEnelpWs.repository.depense;

import com.winxo.PortailEnelpWs.entities.depense.Entete;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EnteteRepository extends JpaRepository<Entete, Integer> {
    Optional<Entete> findEnteteById(Integer id);
    void deleteEnteteById(Integer id);
}
