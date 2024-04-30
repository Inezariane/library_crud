package com.example.crud_learn.serviceImpl;

import com.example.crud_learn.dto.BookDTO;
import com.example.crud_learn.entities.Book;
import com.example.crud_learn.repositories.BookRepo;
import com.example.crud_learn.services.BookService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks()throws  Exception {
        try{
            return bookRepo.findAll();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Book getBookById(int id)throws Exception {
        try{
            return bookRepo.findById(id).get();
        }catch(Exception e){throw new Exception(e.getMessage());}
    }

    @Override
    public Book createBook(BookDTO book) throws Exception{
        try{
            String title = book.getTitle();
            String author = book.getAuthor();
            Date date = book.getDate();

            if(title == null || author == null || date==null || title.isBlank() || author.isBlank()){
                throw new BadRequestException("All fields are required");
            }

            Book newBook = new Book();
            newBook.setAuthor(author);
            newBook.setTitle(title);
            newBook.setDate(date);

            return bookRepo.save(newBook);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public String deleteBookById(int id) throws Exception {
        try {
            if(bookRepo.existsById(id)){
                bookRepo.deleteById(id);
                return "Deleted Successfully";
            }
            else{
                throw new Exception(String.format("Book %s not found", id));
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Book UpdateBookById(int id, BookDTO book) throws Exception {
        try{
            if(bookRepo.existsById(id)){
                Book bookToUpdate = bookRepo.findById(id).get();
                if(bookToUpdate == null){
                    throw new Exception(String.format("Book %s not found", id));
                }

                bookToUpdate.setTitle(book.getTitle());
                bookToUpdate.setAuthor(book.getAuthor());
                bookToUpdate.setDate(book.getDate());
                return bookRepo.save(bookToUpdate);
            }
            throw new Exception(String.format("Book %s not found", id));
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
