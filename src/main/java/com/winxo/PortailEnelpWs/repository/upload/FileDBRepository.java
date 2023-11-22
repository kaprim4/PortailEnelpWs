package com.winxo.PortailEnelpWs.repository.upload;


import com.winxo.PortailEnelpWs.entities.upload.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
