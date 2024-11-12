package com.example.messagingstompwebsocket.service;

import com.example.messagingstompwebsocket.Greeting;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private final SimpMessagingTemplate messagingTemplate;

    public GreetingService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendGreeting(String destination, String messageContent) {
        Greeting greeting = new Greeting("Bấy bì, " + messageContent + "!");
        messagingTemplate.convertAndSend(destination, greeting);
    }
}
