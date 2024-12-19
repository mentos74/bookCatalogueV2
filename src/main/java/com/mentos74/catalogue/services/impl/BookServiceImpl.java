package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Author;
import com.mentos74.catalogue.domain.Book;
import com.mentos74.catalogue.domain.Category;
import com.mentos74.catalogue.domain.Publisher;
import com.mentos74.catalogue.dto.BookCreateRequestDTO;
import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.dto.BookUpdateRequestDTO;
import com.mentos74.catalogue.exception.BadRequestException;
import com.mentos74.catalogue.repository.AuthorRepository;
import com.mentos74.catalogue.repository.BookRepository;
import com.mentos74.catalogue.services.AuthorService;
import com.mentos74.catalogue.services.BookService;
import com.mentos74.catalogue.services.CategoryService;
import com.mentos74.catalogue.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;

import java.util.ArrayList;
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
    public BookDetailDTO findBookDetailById(Long bookId) {
        Book book = bookRepository.findById(bookId).
                orElseThrow(() -> new BadRequestException("book_id invalid"));
        BookDetailDTO dto = new BookDetailDTO();
        dto.setBookId(book.getId());
//		dto.setAuthorName(book.getAuthor().getName());
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());
        return dto;
    }

    @Override
    public List<BookDetailDTO> listBookDetail() {
        List<Book> listAll = bookRepository.findAll();

        return listAll.stream().map((b) -> {
            BookDetailDTO dto = new BookDetailDTO();
//			dto.setAuthorName(b.getAuthor().getName());
            dto.setBookTitle(b.getTitle());
            dto.setBookDescription(b.getDescription());
            dto.setBookId(b.getId());
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

        bookRepository.save(book);

    }

    @Override
    public void updateBook(Long bookId, BookUpdateRequestDTO dto) {

        Book book = bookRepository.findById(bookId).
                orElseThrow(() -> new BadRequestException("book_id invalid"));
        book.setTitle(dto.getBookTitle());
        book.setDescription(dto.getDescription());

        bookRepository.save(book);


    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

//	public BookRepository getBookRepository() {
//		return bookRepository;
//	}
//
//	public void setBookRepository(BookRepository bookRepository) {
//		this.bookRepository = bookRepository;
//	}


}
