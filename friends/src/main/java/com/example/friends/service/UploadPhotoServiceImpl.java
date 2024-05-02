package com.example.friends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

@Service
public class UploadPhotoServiceImpl implements UploadPhotoService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void uploadFile(MultipartFile file, String fileName) {
        try {

            String staticDir = resourceLoader.getResource("classpath:static/").getFile().getAbsolutePath();


            String uploadDirPath = staticDir + File.separator + "uploads";
            File uploadDir = new File(uploadDirPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }


            Path filePath = Paths.get(uploadDirPath, fileName);
            FileCopyUtils.copy(file.getBytes(), filePath.toFile());

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload file", e);
        }
    }
}
