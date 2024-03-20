package com.project.message_service.service;


import com.project.message_service.model.dto.BookRequest;
import com.project.message_service.model.dto.BookResponse;

import java.util.List;


public interface BookService {
    BookRequest getById(long id);

    List<BookResponse> getAllBooks();

    void save(BookRequest bookRequest);

    void update(long id, BookRequest bookRequest);
    void delete(long id);

}
