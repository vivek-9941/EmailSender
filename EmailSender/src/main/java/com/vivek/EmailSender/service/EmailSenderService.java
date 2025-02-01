package com.vivek.EmailSender.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;
        public void sendEmailWithAttachment(List<String> toEmail,
                                            String Body,
                                            String Subject,
                                            byte[] attachment, String filename) throws MessagingException {
            MimeMessage mimeMessage =  mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("vivekmane3306@gmail.com");
            mimeMessageHelper.setTo(toEmail.toArray(new String[0]));
            mimeMessageHelper.setText(Body);
            mimeMessageHelper.setSubject(Subject);
            ByteArrayResource byteArrayResource = new ByteArrayResource(attachment);
            mimeMessageHelper.addAttachment(filename, byteArrayResource);

            mailSender.send(mimeMessage);
            System.out.println("send");



        }

}
