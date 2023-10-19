package com.omsai.kafkasample.controller;

import com.omsai.kafkasample.pojo.User;
import com.omsai.kafkasample.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/omsai/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        kafkaProducer.publishMessage(message);
        return ResponseEntity.ok("Message published successfully");
    }

    @PostMapping("/publishUser")
    public ResponseEntity<String> publishUser(@RequestBody User user) {
        kafkaProducer.sendUser(user);
        return ResponseEntity.ok("User details published successfully");
    }

}
