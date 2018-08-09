package com.sandbox.sandbox.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BooksController implements BooksInterface {

    @GetMapping("/books")
    public List<Book> getAllBooks()
    {
        return Arrays.asList((new Book(1L, "Book11215", "Autjor blabal")),
                            (new Book(2L, "Book2222222", "Autjor asdasdasdsadsa")),
                            (new Book(3L, "Book333333", "Autjor sdsdsdd")));

    }
}
