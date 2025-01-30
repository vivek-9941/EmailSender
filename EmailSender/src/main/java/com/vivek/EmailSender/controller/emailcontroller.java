package com.vivek.EmailSender.controller;

import com.vivek.EmailSender.Model;
import com.vivek.EmailSender.service.Emaildataservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class emailcontroller {


    @Autowired
    private Emaildataservice emaildataservice;

    @PostMapping(value = "/send", consumes = {"multipart/form-data"})
    public ResponseEntity<String> register(@RequestPart("email") Model email,
                                           @RequestPart("attachment") MultipartFile file) throws IOException {
        System.out.println(email);
        email.setFilename(file.getOriginalFilename());
        email.setFiletype(file.getContentType());
        email.setAttachment(file.getBytes());
        Model fetched = emaildataservice.adddetails(email);
        if (fetched == null) {
            return ResponseEntity.status(HttpStatus.IM_USED).body("This is not saved");
        }
        return ResponseEntity.ok("Registered");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestPart("email") Model email,
                                         @RequestPart("attachment") MultipartFile file) throws IOException {
        System.out.println(email);
        email.setFilename(file.getOriginalFilename());
        email.setFiletype(file.getContentType());
        email.setAttachment(file.getBytes());
        Model fetched = emaildataservice.updatedetails(email);
        if (fetched == null) {
            return ResponseEntity.status(HttpStatus.IM_USED).body("This is not saved");
        }
        return ResponseEntity.ok("Updated");
    }
}
