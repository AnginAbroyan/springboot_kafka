package com.project.message_service.repository;

import com.project.message_service.model.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  BookRepository extends JpaRepository<BookEntity, Long> {
}
