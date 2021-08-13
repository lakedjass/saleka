package com.saleka.application.notification;

import com.saleka.application.notification.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class NotificationEmail extends Notification{

    private ConfigurationEmail configurationEmail;
    @Autowired
    public NotificationEmail(ConfigurationEmail configurationEmail){
        this.configurationEmail = configurationEmail;
    }
    @Override
    public void notify(Message message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("support@saleka.com");
        mailMessage.setTo(message.getClient().getEmail());
        mailMessage.setSubject(message.getSubject());
        mailMessage.setText(message.getBody());
        // Send mail
        configurationEmail.getJavaMailSender().send(mailMessage);
    }

}
