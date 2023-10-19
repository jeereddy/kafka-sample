package com.omsai.kafkasample.consumer;

import com.omsai.kafkasample.pojo.User;
import com.omsai.kafkasample.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "spring.kafka.consumer.group-id")
    public void consume(String message) {
        LOGGER.info(String.format("Message received -> %s", message));
    }

    @KafkaListener(topics = AppConstants.TOPIC_NAME_TWO, groupId = AppConstants.GROUP_ID)
    public void consumeUser(User user){
        LOGGER.info(String.format("Message received -> %s", user.toString()));
    }
}
