package com.mentos74.catalogue.controller;

import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @GetMapping("/book/list")
    public String findAllBook(Model model) {
        List<BookDetailDTO> listBook = bookService.listBookDetail();
        model.addAttribute("books",listBook);
        return "book/list";
    }
}
