package com.mentos74.catalogue.services.impl;

import com.mentos74.catalogue.domain.Book;
import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.repository.BookRepository;
import com.mentos74.catalogue.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;


	@Override
	public BookDetailDTO findBookDetailById(Long bookId) {
		Book book = bookRepository.findBookById(bookId);
		BookDetailDTO dto = new BookDetailDTO();
		dto.setBookId(book.getId());
		dto.setAuthorName(book.getAuthor().getName());
		dto.setBookTitle(book.getTitle());
		dto.setBookDescription(book.getDescription());
		return dto;
	}

//	public BookRepository getBookRepository() {
//		return bookRepository;
//	}
//
//	public void setBookRepository(BookRepository bookRepository) {
//		this.bookRepository = bookRepository;
//	}
	
	
	
	
}
