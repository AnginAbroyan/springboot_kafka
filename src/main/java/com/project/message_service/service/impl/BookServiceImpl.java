package com.project.message_service.service.impl;


import com.project.message_service.model.domain.BookEntity;
import com.project.message_service.model.dto.BookRequest;
import com.project.message_service.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class BookServiceImpl {

    private final BookRepository bookRepository;


    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;

    }

    @KafkaListener(topics = "kafkaTopic", groupId = "groupId")
    public void listen(BookRequest bookRequest) {
        BookEntity bookEntity = BookEntity.builder()
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .description(bookRequest.getDescription())
                .price(bookRequest.getPrice())
                .build();
        bookRepository.save(bookEntity);
        log.info("Book saved: {}", bookEntity);
    }
}


