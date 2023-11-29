package com.asma.users.service;


import com.asma.users.Mail.Mail;



public interface MailService {
    void sendMail(String email, Mail mail);

}
