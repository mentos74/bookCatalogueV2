package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.BookCreateRequestDTO;
import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.dto.BookUpdateRequestDTO;

import java.util.List;


public interface BookService {

	public BookDetailDTO findBookDetailById(Long bookId);
	public List<BookDetailDTO> listBookDetail();
	public void createNewBook(BookCreateRequestDTO dto);
	public void updateBook(Long bookId, BookUpdateRequestDTO dto);
	public  void deleteBook(Long bookId);

}
