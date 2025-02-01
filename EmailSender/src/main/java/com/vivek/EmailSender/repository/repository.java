package com.vivek.EmailSender.repository;

import com.vivek.EmailSender.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends JpaRepository<Model, Integer> {
    Model findByMyemail(String myemail);
// Fixed method name
}
