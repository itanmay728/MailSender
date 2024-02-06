package com.example.MailSender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.MailSender.model.NewDetails;
import com.example.MailSender.repository.NewDetailsRepository;

import jakarta.mail.MessagingException;


@Controller
public class homeController {

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	NewDetailsRepository newDetailsRepository;
	
	@GetMapping("/")
	public String getIndexPage(Model model) {
		
		model.addAttribute("title", "Home");
		return "index";
	}
	
	
	@PostMapping("/")
	public String newDetails(@ModelAttribute NewDetails newDetails) throws MessagingException {

		SimpleMailMessage message = new SimpleMailMessage();
	   
				 
		System.out.println(newDetails);
		
		newDetailsRepository.save(newDetails);

		message.setFrom("ktanmay728@gmail.com");
        message.setTo("Ktanmay1130@gmail.com");
        message.setSubject("Subject : Sample Email Subject");
        
        message.setText("name: " + newDetails.getName()  + "\n" + "Email: " + newDetails.getEmail()  + "\n" + "PhoneNumber: " + newDetails.getPhoneNumber());
        
         
        javaMailSender.send(message);
        
        System.out.println("Mail is sended");
		return "redirect:/";
		
	}
	
}
