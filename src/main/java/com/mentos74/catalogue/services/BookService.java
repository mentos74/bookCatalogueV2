package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.BookCreateDTO;
import com.mentos74.catalogue.dto.BookDetailDTO;
import com.mentos74.catalogue.dto.BookUpdateRequestDTO;

import java.util.List;


public interface BookService {

	public BookDetailDTO findBookDetailById(Long bookId);
	public List<BookDetailDTO> listBookDetail();
	public void createNewBook(BookCreateDTO dto);
	public void updateBook(Long bookId, BookUpdateRequestDTO dto);
	public  void deleteBook(Long bookId);

}
