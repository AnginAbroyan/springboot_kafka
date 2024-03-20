package com.project.message_service.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class BookRequest {

    private String name;
    private String author;
    private String description;
    private double price;

    public BookRequest() {
    }

    public BookRequest(String name, String author, String description, double price) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}
