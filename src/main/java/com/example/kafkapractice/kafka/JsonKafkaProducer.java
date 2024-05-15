package com.example.kafkapractice.kafka;

import com.example.kafkapractice.dto.entities.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, UserDetails> kafkaTemplate;

    public void sendMessage(UserDetails userDetails) {
        log.info("User Details {}", userDetails);
        Message<UserDetails> message = MessageBuilder
                .withPayload(userDetails)
                .setHeader(KafkaHeaders.TOPIC, "Json-Topic")
                .build();
        kafkaTemplate.send(message);
        log.info("User Details sent to kafka {}", userDetails);
    }

}
