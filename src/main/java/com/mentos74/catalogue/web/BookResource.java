package com.mentos74.catalogue.web;

import com.mentos74.catalogue.dto.BookCreateDTO;
import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.services.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {

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

    @PostMapping("/book")
    public ResponseEntity<Void> createNewBook(@RequestBody BookCreateDTO dto){
        bookService.createNewBook(dto);
        return  ResponseEntity.created(URI.create("/book")).build();
    }

    @GetMapping("/book")
    public ResponseEntity<List<BookDetailDTO>> findBookList(){

        return ResponseEntity.ok().body(bookService.listBookDetail());
    }
}

