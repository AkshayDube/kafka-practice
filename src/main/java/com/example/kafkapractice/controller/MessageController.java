package com.example.kafkapractice.controller;

import com.example.kafkapractice.dto.entities.UserDetails;
import com.example.kafkapractice.kafka.JsonKafkaProducer;
import com.example.kafkapractice.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kafka")
public class MessageController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    // http://localhost:8080/api/kafka/test?message=Akshay Dubey
    @GetMapping("/test")
    public ResponseEntity sendMessage(@RequestParam String message) {
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent successfully");
    }

    // http://localhost:8080/api/kafka/json
    @PostMapping("/json")
    public ResponseEntity sendMessageToKafka(@RequestBody UserDetails userDetails) {
        jsonKafkaProducer.sendMessage(userDetails);
        return ResponseEntity.ok("Message sent successfully");
    }

}
