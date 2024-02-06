package com.example.MailSender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MailSender.model.NewDetails;

public interface NewDetailsRepository extends JpaRepository<NewDetails, Long>{

}
