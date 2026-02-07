package com.example.demo;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class NotificationService {

    public void sendToToken(String token, String title, String body) throws FirebaseMessagingException {
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build())
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("Sent message to token. Response: " + response);
    }


    public void subscribeToTopic(String token, String topic) throws FirebaseMessagingException {
        FirebaseMessaging.getInstance().subscribeToTopic(Collections.singletonList(token), topic);
        System.out.println("Subscribed to topic: " + topic);
    }


    public String sendToTopic(String topic, String title, String body) throws FirebaseMessagingException {
        Message message = Message.builder()
                .setTopic(topic)
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build())
                .build();

        String response = FirebaseMessaging.getInstance().send(message);
        System.out.println("FCM Response ID: " + response);
        return response;
    }
}
