package com.vivek.EmailSender;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @JsonProperty("myemail")
    private String myemail;
    @JsonProperty("Body")
    private String Body;
    @JsonProperty("Subject")
    private String Subject;
    @JsonProperty("Attachment")
    @Lob
    private byte[] Attachment;
    private String filename;
    private String filetype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Model() {}

    public Model( String Myemail, String Body, String Subject, byte[] Attachment) {

        this.myemail = Myemail;
        this.Body = Body;
        this.Subject = Subject;
        this.Attachment = Attachment;
    }





    public String getMyemail() {
        return myemail;
    }

    public void setMyemail(String myemail) {
        this.myemail = myemail;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String Body) {
        this.Body = Body;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String Subject) {
        this.Subject = Subject;
    }

    public byte[] getAttachment() {
        return Attachment;
    }

    public void setAttachment(byte[] Attachment) {
        this.Attachment = Attachment;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", myemail='" + myemail + '\'' +
                ", Body='" + Body + '\'' +
                ", Subject='" + Subject + '\'' +
                ", Attachment=" + Arrays.toString(Attachment) +
                '}';
    }
}