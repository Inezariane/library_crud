package com.example.crud_learn.repositories;

import com.example.crud_learn.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
