package com.arproject.arproject.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);

}
