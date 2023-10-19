package com.omsai.kafkasample.producer;

import com.omsai.kafkasample.pojo.User;
import com.omsai.kafkasample.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplateUser;

    public void publishMessage(String message) {
        LOGGER.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(topicName, message);

    }

    public void sendUser(User user) {
        /*Notice: we created a KafkaTemplate<String, User> since we are sending
        Java Objects to the Kafka topic that’ll
        automatically be transformed into a JSON byte[].*/
        LOGGER.info(String.format("Message sent -> %s", user.toString()));
        Message<User> message = MessageBuilder.withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, AppConstants.TOPIC_NAME_TWO).build();
        kafkaTemplateUser.send(message);
    }
}
