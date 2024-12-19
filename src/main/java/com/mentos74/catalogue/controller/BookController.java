package com.mentos74.catalogue.controller;

import com.mentos74.catalogue.dto.BookCreateRequestDTO;
import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.services.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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
        BookCreateRequestDTO bookCreateDTO = new BookCreateRequestDTO();
        model.addAttribute("bookCreateDTO", bookCreateDTO);
        return "book/add";
    }

    @PostMapping("/add")
    public String addBookNew(@ModelAttribute("bookCreateDTO") @Valid BookCreateRequestDTO bookCreateDTO,
                             BindingResult bindingResult,
                             Errors errors ,
                             Model model) {


        if(errors.hasErrors()){
            model.addAttribute("bookCreateDTO",bookCreateDTO);
            return "book/add";
        }

        bookService.createNewBook(bookCreateDTO);
        return "redirect:/book/list";
    }

}
