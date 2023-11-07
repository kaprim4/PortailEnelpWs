package com.winxo.PortailEnelpWs.repository.depense;

import com.winxo.PortailEnelpWs.entities.depense.Export;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExportRepository extends JpaRepository<Export, Integer> {
    Optional<Export> findExportById(Integer id);
    void deleteExportById(Integer id);
}
