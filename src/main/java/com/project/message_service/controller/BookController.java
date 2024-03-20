package com.project.message_service.controller;


import com.project.message_service.model.dto.BookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/book")
public class BookController {


    private final KafkaTemplate<String, BookRequest> kafkaTemplate;

    @Autowired
    public BookController(KafkaTemplate<String, BookRequest> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @PostMapping("/sendToKafka")
    public ResponseEntity<String> createBook(@RequestBody BookRequest bookRequest) {
        kafkaTemplate.send("kafkaTopic", bookRequest);
        return ResponseEntity.ok("Book request sent to Kafka");
    }


}
