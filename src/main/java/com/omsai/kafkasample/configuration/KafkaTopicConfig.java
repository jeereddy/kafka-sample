package com.omsai.kafkasample.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic javaTopic(){
        return TopicBuilder.name("javaguides")
                .build();
    }
    @Bean
    public NewTopic javaTopicTwo(){
        return TopicBuilder.name("javamessage").build();
    }
}
