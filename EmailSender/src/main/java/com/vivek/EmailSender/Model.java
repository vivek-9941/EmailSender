package com.vivek.EmailSender;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.Arrays;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonProperty("myemail")
    private String myemail;

    @JsonProperty("body")
    private String body;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("attachment")
    @Lob
    private byte[] attachment;

    private String filename;
    private String filetype;

    // Default constructor
    public Model() {}

    // Parameterized constructor
    public Model(String myemail, String body, String subject, byte[] attachment) {
        this.myemail = myemail;
        this.body = body;
        this.subject = subject;
        this.attachment = attachment;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyemail() {
        return myemail;
    }

    public void setMyemail(String myemail) {
        this.myemail = myemail;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", myemail='" + myemail + '\'' +
                ", body='" + body + '\'' +
                ", subject='" + subject + '\'' +
                ", attachment=" + Arrays.toString(attachment) +
                '}';
    }
}
