package com.example.crud_learn.controllers;

import com.example.crud_learn.dto.BookDTO;
import com.example.crud_learn.serviceImpl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {
    private final BookServiceImpl bookService;

    @PostMapping("/create")
    public ResponseEntity createBook(@RequestBody BookDTO dto)throws Exception{
        return ResponseEntity.ok(bookService.createBook(dto));
    }

    @GetMapping("/all")
    public ResponseEntity getAllBooks()throws Exception{
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable("id") int id)throws Exception{
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable("id") int id, @RequestBody BookDTO dto)throws Exception{
        return ResponseEntity.ok(bookService.UpdateBookById(id, dto));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") int id)throws Exception{
        return ResponseEntity.ok(bookService.deleteBookById(id));
    }
}
