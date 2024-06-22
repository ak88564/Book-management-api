package com.bookapp.service;

import com.bookapp.models.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{

    @Override
    public Book getById(int bookid){
        return getBookList().stream().filter((book -> book.getBookid()==bookid)).findAny().orElse(new Book());
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return getBookList().stream().filter((book) -> book.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByCategory(String category){
        return getBookList().stream().filter((book) -> book.getCategory().equals(category)).collect(Collectors.toList());
    }

    private List<Book> getBookList(){
        return Arrays.asList(new Book("Java","Kathy","Tech",10),
                new Book("Spring","Rod","Tech",11),
                new Book("Ferrai","Robin","Fiction",13),
                new Book("Miracle","Kathy","Fiction",12),
                new Book("Captain","Hal","Comic",14),
                new Book("Skullv Glow","Kumaram","Horror",15));
    }
}
