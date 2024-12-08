package com.mentos74.catalogue.controller;

import com.mentos74.catalogue.dto.BookCreateDTO;
import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public String findAllBook(Model model) {
        List<BookDetailDTO> listBook = bookService.listBookDetail();
        model.addAttribute("books",listBook);
        return "book/list";
    }

    @GetMapping("/add")
    public String addBook(Model model) {
        BookCreateDTO bookCreateDTO = new BookCreateDTO();
        model.addAttribute("bookCreateDTO", bookCreateDTO);
        return "book/add";
    }

    @PostMapping("/add")
    public String addBookNew(@ModelAttribute(value="bookCreateDTO") BookCreateDTO dto, Model model) {
        bookService.createNewBook(dto);
        return "redirect:/book/list";
    }

}
