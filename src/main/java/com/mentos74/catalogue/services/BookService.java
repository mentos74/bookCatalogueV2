package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.BookCreateRequestDTO;
import com.mentos74.catalogue.dto.BookDetailResponseDTO;
import com.mentos74.catalogue.dto.BookUpdateRequestDTO;

import java.util.List;


public interface BookService {

	public BookDetailResponseDTO findBookDetailById(String bookId);
	public List<BookDetailResponseDTO> listBookDetail();
	public void createNewBook(BookCreateRequestDTO dto);
	public void updateBook(String bookId, BookUpdateRequestDTO dto);
	public  void deleteBook(String bookId);

}
