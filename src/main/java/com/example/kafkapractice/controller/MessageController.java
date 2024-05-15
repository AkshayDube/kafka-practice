package com.example.kafkapractice.controller;

import com.example.kafkapractice.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    // http://localhost:8080/api/kafka/test?message=Akshay Dubey
    @GetMapping("/test")
    public ResponseEntity sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

}
