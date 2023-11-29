package com.asma.users.restControllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

import com.asma.users.Mail.Mail;
import com.asma.users.service.MailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class MailRestController {
    @Autowired
    private MailService mailService;

    @PostMapping("/send/{email}")
    public String sendMail (@PathVariable String email, @RequestBody Mail mail) {
        mailService.sendMail(email, mail);
        return "Mail sent successfully";
    }

}