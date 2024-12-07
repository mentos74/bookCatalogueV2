package com.mentos74.catalogue.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/bookId/{bookId}")

    public String findBookDetail(@PathVariable("bookId") Long idBook){
        return null;
    }



}
