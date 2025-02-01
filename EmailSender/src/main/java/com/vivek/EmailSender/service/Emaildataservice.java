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
    public Model getemail(String id) {
        return repo.findByMyemail(id); // Returns null if not found
    }

    public Model adddetails(Model model){
       return  repo.save(model);
    }

    public Model updatedetails(Model model){
        return repo.save(model);
    }
    public void deletedetails(int id){
        repo.deleteById(id);
    }
}
