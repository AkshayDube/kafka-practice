package com.example.kafkapractice.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic getLearningTopic() {
        return TopicBuilder
                .name("Second-Topic")
                .build();
    }

    @Bean
    public NewTopic getLearningJsonTopic() {
        return TopicBuilder
                .name("Json-Topic")
                .build();
    }
}
