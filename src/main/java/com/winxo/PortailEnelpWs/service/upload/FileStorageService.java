package com.winxo.PortailEnelpWs.service.upload;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

import com.winxo.PortailEnelpWs.entities.upload.FileDB;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.upload.FileDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


public interface FileStorageService {

    FileDB store(MultipartFile file) throws IOException;

    FileDB findFileDBById(String id);

    Stream<FileDB> getAllFiles();
}
