package com.winxo.PortailEnelpWs.repository.upload;


import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.upload.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

    Optional<FileDB> findFileDBById(String id);
}
