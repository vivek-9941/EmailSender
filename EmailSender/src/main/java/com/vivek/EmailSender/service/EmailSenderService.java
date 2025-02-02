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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    // Executor for parallel processing
    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // Thread pool size can be adjusted

    public void sendEmailWithAttachment(List<String> toEmail,
                                        String Body,
                                        String Subject,
                                        byte[] attachment, String filename) throws MessagingException {
        for (String recipient : toEmail) {
            // Submit the task to executor for parallel execution
            executorService.submit(() -> {
                try {
                    sendEmail(recipient, Body, Subject, attachment, filename);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // Helper method to send email to a single recipient
    private void sendEmail(String recipient, String Body, String Subject, byte[] attachment, String filename) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("vivekmane3306@gmail.com");
        mimeMessageHelper.setTo(recipient); // Send separately
        mimeMessageHelper.setText(Body);
        mimeMessageHelper.setSubject(Subject);

        if (attachment != null && attachment.length > 0) {
            ByteArrayResource byteArrayResource = new ByteArrayResource(attachment);
            mimeMessageHelper.addAttachment(filename, byteArrayResource);
        }

        mailSender.send(mimeMessage); // Send email
        System.out.println("Email sent to: " + recipient);
    }
//    When you're sending emails to multiple recipients, each email can be sent in parallel, reducing the total time. Instead of waiting for each email to be sent one
//    after the other, threads can run independently, allowing multiple emails to be sent at the same time.
//
//    However, creating threads for each task can be expensive in terms of memory and system resources. A ThreadPool helps optimize this by managing a pool of worker
//    threads that can handle multiple tasks efficiently.
}