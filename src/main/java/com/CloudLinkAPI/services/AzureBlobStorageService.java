package com.CloudLinkAPI.services;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.models.BlobItem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class AzureBlobStorageService {

    @Value("${azure.storage.connection-string}")
    private String connectionString;

    @Value("${azure.storage.container-name}")
    private String containerName;

    public String uploadFile(MultipartFile file) throws IOException {
        // Cria um client para o container
        BlobContainerClient containerClient = new BlobContainerClientBuilder()
                .connectionString(connectionString)
                .containerName(containerName)
                .buildClient();

        // Cria um client para o blob (arquivo)
        BlobClient blobClient = containerClient.getBlobClient(file.getOriginalFilename());

        // Faz o upload do arquivo
        blobClient.upload(file.getInputStream(), file.getSize(), true);

        return "Arquivo enviado com sucesso: " + blobClient.getBlobUrl();
    }
    
    public String listBlobs() {
    	// Cria um client para o container
        BlobContainerClient containerClient = new BlobContainerClientBuilder()
                .connectionString(connectionString)
                .containerName(containerName)
                .buildClient();
        
        // Cria uma lista de arquivos do container
        StringBuilder blobsList = new StringBuilder("Blobs no container:\n");
        for (BlobItem blobItem : containerClient.listBlobs()) {
            blobsList.append(blobItem.getName()).append("\n");
        }

        return blobsList.toString();
    }

    
}

