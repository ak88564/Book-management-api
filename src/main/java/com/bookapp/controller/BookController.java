package com.bookapp.controller;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book-restapi")
public class BookController {

    Logger  logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookService bookService;

    // http://localhost:8080/book-restapi/hello
    @GetMapping("/hello")
    public String sayHello(){
        logger.info("Welcome to rest api");
        return "Welcome to rest api";
    }

    //http://localhost:8080/book-restapi/book-by-id/10
    @GetMapping("/book-by-id/{id}")
    public Book getBookById(@PathVariable("id") int bookid){
        return bookService.getById(bookid);
    }

    // http://localhost:8080/book-restapi/books-by-author/Kathy
    @GetMapping("books-by-author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author){
        return bookService.getBooksByAuthor(author);
    }

    // http://localhost:8080/book-restapi/books-by-category/?category=Fiction
    @GetMapping("books-by-category")
    public List<Book> getBookByCategory(@RequestParam("category") String category){
        return bookService.getBooksByCategory(category);
    }
}
