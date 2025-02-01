package com.vivek.EmailSender.controller;

import com.vivek.EmailSender.Model;
import com.vivek.EmailSender.service.EmailSenderService;
import com.vivek.EmailSender.service.Emaildataservice;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
@CrossOrigin
//here you use getmapping for sending the email by passing the url param as the email id of the user so as to get data from the DB
@RestController
@RequestMapping("/api/c")
public class SenderController {

    @Autowired
    private Emaildataservice emaildataservice;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/email/{id}")
    public ResponseEntity<String> getEmail(
            @PathVariable String id,
            @RequestBody List<String> reciptents
    ) throws MessagingException {


        Model emaildata = null;
try{
         emaildata = emaildataservice.getemail(id);

}
catch(Exception E){
    ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email Not Found");
}
        try {
            if (emaildata != null) {
                byte[] pdf = emaildata.getAttachment();
                emailSenderService.sendEmailWithAttachment(
                        reciptents, emaildata.getBody(), emaildata.getSubject(), pdf, emaildata.getFilename()
                );
                return ResponseEntity.ok().body("Email submitted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email data not found.");
            }
        }
        catch(Exception E){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Invalid Email");
        }
    }
}
