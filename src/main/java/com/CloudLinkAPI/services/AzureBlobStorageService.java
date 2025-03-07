package com.CloudLinkAPI.services;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
}

