package com.training.bootsample.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileUploadController {

    private static final String UPLOAD_PATH = "/Users/user/dev/uploads";

    @GetMapping("/uploadFile")
    public String getFileUploadPage() {
        return "file-upload";
    }

    @PostMapping("/uploadFile")
    @ResponseBody
    public void uploadFile(@RequestPart("file") MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        File dest = new File(UPLOAD_PATH + "/" + fileName);
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), dest);
        log.info("File({}) is uploaded to {} successfully", fileName, UPLOAD_PATH);
    }
}
