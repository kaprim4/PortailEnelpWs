package com.winxo.PortailEnelpWs.service.upload;

import java.io.IOException;
import java.util.stream.Stream;
import com.winxo.PortailEnelpWs.entities.upload.FileDB;
import org.springframework.web.multipart.MultipartFile;


public interface FileStorageService {

    FileDB store(MultipartFile file) throws IOException;

    FileDB findFileDBById(String id);

    Stream<FileDB> getAllFiles();
}
