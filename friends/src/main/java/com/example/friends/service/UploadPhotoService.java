package com.example.friends.service;


import org.springframework.web.multipart.MultipartFile;

public interface UploadPhotoService {
    void uploadFile(MultipartFile file, String fileName);
}
