package com.winxo.PortailEnelpWs.service.upload;

import com.winxo.PortailEnelpWs.entities.upload.FileDB;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.upload.FileDBRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final FileDBRepository fileDBRepository;

    public FileStorageServiceImpl(FileDBRepository fileDBRepository) {
        this.fileDBRepository = fileDBRepository;
    }

    public FileDB store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileDB FileDB = new FileDB(
                fileName,
                file.getContentType(),
                file.getBytes(),
                true,
                false,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        return fileDBRepository.save(FileDB);
    }

    public FileDB findFileDBById(String id) {
        return fileDBRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("File by id " + id + " was not found"));
    }

    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
