package com.mentos74.catalogue.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Data
public class BookDetailDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7889938648939242355L;

	private Long bookId;

	private String authorName;

	private String bookTitle;

	private String bookDescription;




}

