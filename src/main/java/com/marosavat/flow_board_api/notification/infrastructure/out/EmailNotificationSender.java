package com.marosavat.flow_board_api.notification.infrastructure.out;

import com.marosavat.flow_board_api.notification.domain.Notification;
import com.marosavat.flow_board_api.notification.domain.NotificationSender;
import com.marosavat.flow_board_api.notification.domain.exception.NotificationNotSent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailNotificationSender implements NotificationSender {

    private final JavaMailSender mailSender;
    private final String from;

    public EmailNotificationSender(
            JavaMailSender mailSender,
            @Value("${mail.from}") String from) {
        this.mailSender = mailSender;
        this.from = from;
    }


    @Override
    public void send(Notification notification) {
        String to = notification.recipient();
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(from);
            message.setTo(to);
            message.setSubject(notification.title());
            message.setText(notification.content());

            mailSender.send(message);
            log.info("[Notification] Email sent successfully to: {}", to);
        } catch (Exception e) {
            log.error("[Notification] Failed to send email to: {}", to, e);
            throw new NotificationNotSent("Failed to send email", e);
        }
    }
}
