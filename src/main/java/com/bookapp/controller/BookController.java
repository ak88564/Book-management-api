package com.bookapp.controller;

import com.bookapp.models.Book;
import com.bookapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book-restapi")
public class BookController {

    @Autowired
    BookService bookService;

    // http://localhost:8080/book-restapi/hello
    @GetMapping("/hello")
    public String sayHello(){
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
