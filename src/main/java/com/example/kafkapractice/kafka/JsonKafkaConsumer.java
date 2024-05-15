package com.example.kafkapractice.kafka;

import com.example.kafkapractice.dto.entities.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger log = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "Json-Topic", groupId = "myGroup")
    public void consume(UserDetails userDetails) {
        log.info("message received from producer ----------> " + userDetails);
    }

}
