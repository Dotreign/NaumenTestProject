package com.example.naumentest.controller;

import com.example.naumentest.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/load-file")
public class FileController {

    FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/")
    public String loadFile(@RequestBody MultipartFile file) {
        try {
            String fileContent = new String(file.getBytes());
            return fileService.dataExtractor(fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
