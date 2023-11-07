package com.winxo.PortailEnelpWs.repository.depense;

import com.winxo.PortailEnelpWs.entities.depense.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {
    Optional<Fournisseur> findFournisseurById(Integer id);
    void deleteFournisseurById(Integer id);
}
