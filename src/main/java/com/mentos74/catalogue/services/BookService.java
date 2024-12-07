package com.mentos74.catalogue.services;

import com.mentos74.catalogue.dto.BookDetailDTO;


public interface BookService {

	public BookDetailDTO findBookDetailById(Long bookId);

}
