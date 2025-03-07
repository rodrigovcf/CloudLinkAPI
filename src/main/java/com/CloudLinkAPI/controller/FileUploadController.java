package com.CloudLinkAPI.controller;

import com.CloudLinkAPI.services.AzureBlobStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileUploadController {

    private final AzureBlobStorageService storageService;

    public FileUploadController(AzureBlobStorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String fileUrl = storageService.uploadFile(file);
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Erro ao fazer upload do arquivo");
        }
    }
    
    @GetMapping("/list")
    public String listBlobs() {
        return storageService.listBlobs();
    }
}
