package com.example.demo;

import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-notification")
public class TestController {

    private final NotificationService notificationService;

    public TestController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public String send(@RequestParam String token) throws FirebaseMessagingException {
        notificationService.sendToToken(token, "Hello!", "This is a test notification");
        return "Notification sent!";
    }
    @PostMapping("/send-test")
    public String sendTest() throws FirebaseMessagingException {

        notificationService.sendToTopic("test_topic", "Hello!", "Success Test!");
        return "Notification sent to Topic!";
    }
    @PostMapping("/sendToTopic")
    public String sendToTopic(@RequestParam String topic) throws FirebaseMessagingException {
        String messageId = notificationService.sendToTopic(topic, "Test Title", "Test Body");
        return "Notification sent! Message ID: " + messageId;
    }

    @PostMapping("/subscribe")
    public String subscribe(@RequestParam String token, @RequestParam String topic) throws FirebaseMessagingException {
        notificationService.subscribeToTopic(token, topic);
        return "Subscribed!";
    }
}