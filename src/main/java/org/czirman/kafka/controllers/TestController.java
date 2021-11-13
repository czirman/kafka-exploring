package org.czirman.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${message.topic.name}")
    private String topicName;

    @PostMapping(path ="/test")
    public ResponseEntity<String> test(/* final @RequestBody CreditAss cs */){
        kafkaTemplate.send(topicName, "test");
        return new ResponseEntity("ff", HttpStatus.OK);

    }
}
