package com.vivek.EmailSender.controller;

import com.vivek.EmailSender.Model;
import com.vivek.EmailSender.service.EmailSenderService;
import com.vivek.EmailSender.service.Emaildataservice;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/c")
public class testconstroller {
            @Autowired
        private Emaildataservice emaildataservice;
            @Autowired
        EmailSenderService emailSenderService;
        @GetMapping("/email/{id}/{newid}")
        public ResponseEntity<String> getemail(@PathVariable int id, @PathVariable  String newid) throws MessagingException {
//            Model gotmodel = emaildataservice.getemail(id);
                Model  emaildata   = emaildataservice.getemail(id);
            if(emaildata != null){
                byte[] pdf = emaildata.getAttachment();
                emailSenderService.sendEmailWithAttachment(
                        newid ,emaildata.getBody(),emaildata.getSubject(),pdf,emaildata.getFilename()
                );
            return ResponseEntity.ok().body("submitted");
            }
            else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
}
