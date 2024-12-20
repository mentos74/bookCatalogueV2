package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Author;
import com.mentos74.catalogue.domain.Book;
import com.mentos74.catalogue.domain.Category;
import com.mentos74.catalogue.domain.Publisher;
import com.mentos74.catalogue.dto.BookCreateRequestDTO;
import com.mentos74.catalogue.dto.BookDetailResponseDTO;
import com.mentos74.catalogue.dto.BookUpdateRequestDTO;
import com.mentos74.catalogue.exception.BadRequestException;
import com.mentos74.catalogue.repository.BookRepository;
import com.mentos74.catalogue.services.AuthorService;
import com.mentos74.catalogue.services.BookService;
import com.mentos74.catalogue.services.CategoryService;
import com.mentos74.catalogue.services.PublisherService;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
	private final CategoryService categoryService;
	private final PublisherService publisherService;


    @Override
    public BookDetailResponseDTO findBookDetailById(String bookId) {
        Book book = bookRepository.findBySecureId(bookId).
                orElseThrow(() -> new BadRequestException("book_id invalid"));
        BookDetailResponseDTO dto = new BookDetailResponseDTO();
        dto.setBookId(book.getSecureId());
		dto.setCategories(categoryService.constructDTO(book.getCategories()));
		dto.setAuthors(authorService.constructDTO(book.getAuthors()));
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());
        return dto;
    }

    @Override
    public List<BookDetailResponseDTO> listBookDetail() {
        List<Book> listAll = bookRepository.findAll();

        return listAll.stream().map((b) -> {
            BookDetailResponseDTO dto = new BookDetailResponseDTO();
//			dto.setAuthorName(b.getAuthor().getName());
            dto.setBookTitle(b.getTitle());
            dto.setBookDescription(b.getDescription());
            dto.setBookId(b.getSecureId());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewBook(BookCreateRequestDTO dto) {
        List<Author> authors = authorService.findAuthorList(dto.getAuthorIdList());
		List<Category> categories = categoryService.findCategoryList(dto.getCategoryList());
		Publisher publisher = publisherService.findPublisher(dto.getPublisherId());

        Book book = new Book();
        book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setCategories(categories);
        book.setDescription(dto.getDescription());
        book.setTitle(dto.getBookTitle());
		book.setDeleted(false);

        bookRepository.save(book);

    }

    @Override
    public void updateBook(String bookId, BookUpdateRequestDTO dto) {

        Book book = bookRepository.findBySecureId(bookId).
                orElseThrow(() -> new BadRequestException("book_id invalid"));
        book.setTitle(dto.getBookTitle());
        book.setDescription(dto.getDescription());

        bookRepository.save(book);


    }

    @Override
    public void deleteBook(String bookId) {
		Book book = bookRepository.findBySecureId(bookId).
				orElseThrow(() -> new BadRequestException("book_id invalid"));
        bookRepository.delete(book);
    }



}
