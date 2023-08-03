package com.example.springbootfileupload.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

@RestController
@RequestMapping("/upload")
public class UploadController {


    /// Receive message
    @PostMapping("/v1")
    public Map<String, Object> upload(@RequestParam("attach") MultipartFile file) throws IOException {
        // File info
        Map<String, Object> result = new HashMap<>();

        System.out.println("File name = "  + file.getOriginalFilename());
        System.out.println("File type = " + file.getContentType());

        // Save to disk
        // file path example 1) Windows c:/, 3) Mac ~/Documents/
        String filePath = "C:/Users/Ramkishan/Downloads";
        file.transferTo(new File(filePath + file.getOriginalFilename()));
        result.put("Success", true);
        System.out.println(result);

        return result;
    }
}
