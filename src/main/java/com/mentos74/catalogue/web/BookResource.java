package com.mentos74.catalogue.web;

import com.mentos74.catalogue.dto.BookDetailResponseDTO;
import com.mentos74.catalogue.dto.BookCreateRequestDTO;
import com.mentos74.catalogue.dto.BookUpdateRequestDTO;
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

    @GetMapping("/v1/book/{bookId}")
    public BookDetailResponseDTO findBookDetail(@PathVariable("bookId") String bookId) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        log.info("Start find detail");
        BookDetailResponseDTO result = bookService.findBookDetailById(bookId);
        log.info("End find detail, execution time = "+ stopWatch.getTotalTimeMillis());

        return result;
    }

    @PostMapping("/v1/book")
    public ResponseEntity<Void> createNewBook(@RequestBody BookCreateRequestDTO dto){
        bookService.createNewBook(dto);
        return  ResponseEntity.created(URI.create("/book")).build();
    }

    @GetMapping("/v1/book")
    public ResponseEntity<List<BookDetailResponseDTO>> findBookList(){

        return ResponseEntity.ok().body(bookService.listBookDetail());
    }


    @PutMapping("/book/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable String bookId,
                                           @RequestBody BookUpdateRequestDTO dto){

        bookService.updateBook(bookId,dto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable String bookId){

        bookService.deleteBook(bookId);

        return ResponseEntity.ok().build();
    }


}

