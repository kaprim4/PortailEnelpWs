package com.winxo.PortailEnelpWs.controller.upload;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.upload.FileDB;
import com.winxo.PortailEnelpWs.entities.upload.ResponseFile;
import com.winxo.PortailEnelpWs.entities.upload.ResponseMessage;
import com.winxo.PortailEnelpWs.repository.upload.FileDBRepository;
import com.winxo.PortailEnelpWs.service.upload.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
@RequestMapping("/api/v1/storage")
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {

    private final FileStorageService fileStorageService;

    @Autowired
    private FileDBRepository fileDBRepository;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            FileDB fileDB = fileStorageService.store(file);
            return new ResponseEntity<>(fileDB, HttpStatus.OK);
        } catch (Exception e) {
            String msg = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(msg));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileStorageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(dbFile.getId())
                    .toUriString();
            return new ResponseFile(
                    dbFile.getImageName(),
                    fileDownloadUri,
                    dbFile.getImageType(),
                    dbFile.getImageData().length,
                    dbFile.getIsActivated(),
                    dbFile.getIsDeleted(),
                    dbFile.getCreatedAt(),
                    dbFile.getUpdatedAt());
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> findFileDBById(@PathVariable String id) {
        Optional<FileDB> fileDBOptional = fileDBRepository.findFileDBById(id);
        if (fileDBOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        FileDB fileDB_found = fileStorageService.findFileDBById(id);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB_found.getImageName() + "\"")
                .body(fileDB_found.getImageData());
    }
}