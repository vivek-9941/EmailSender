package com.vivek.EmailSender.service;
import com.vivek.EmailSender.Model;
import com.vivek.EmailSender.repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Emaildataservice {
    @Autowired
    private repository repo;


    // Non-static method to fetch data by ID
    public Model getemail(int id) {
        return repo.findById(id).orElse(null); // Returns null if not found
    }

    public Model adddetails(Model model){
       return  repo.save(model);
    }

    public Model updatedetails(Model model){
        return repo.save(model);
    }
    public void deletedetails(Model model){
        repo.delete(model);
    }
}
