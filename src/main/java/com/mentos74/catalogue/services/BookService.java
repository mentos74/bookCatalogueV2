package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.BookDetailDTO;

import java.util.List;


public interface BookService {

	public BookDetailDTO findBookDetailById(Long bookId);
	public List<BookDetailDTO> listBookDetail();

}
