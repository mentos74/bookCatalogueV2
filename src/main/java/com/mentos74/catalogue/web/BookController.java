package com.mentos74.catalogue.web;

import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.services.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping("/book/{bookId}")
    public BookDetailDTO findBookDetail(@PathVariable("bookId") Long id) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        log.info("Start find detail");
        BookDetailDTO result = bookService.findBookDetailById(id);
        log.info("End find detail, execution time = "+ stopWatch.getTotalTimeMillis());

        return result;
    }
}

