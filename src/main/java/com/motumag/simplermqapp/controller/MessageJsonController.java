package com.motumag.simplermqapp.controller;

import com.motumag.simplermqapp.dto.User;
import com.motumag.simplermqapp.producer.RabbitMQJsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Motuma Gishu, Senior Software Engineer
 * Date: 2/16/25
 * Description: This is the message controller for json serilzed to producer rabbitmq
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MessageJsonController {
    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @PostMapping("/jsonPublisher")

    public ResponseEntity<String> jsonPublisher(@RequestBody User user) {
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("{\"message\": \"" + user + "\"}");
    }
}
