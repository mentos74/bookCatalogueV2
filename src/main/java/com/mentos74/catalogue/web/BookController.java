package com.mentos74.catalogue.web;

import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping("/book/{bookId}")
    public BookDetailDTO findBookDetail(@PathVariable("bookId") Long id) {
        return bookService.findBookDetailById(id);
    }
}

