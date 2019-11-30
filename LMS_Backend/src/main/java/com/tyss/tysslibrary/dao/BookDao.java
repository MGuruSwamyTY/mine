package com.tyss.tysslibrary.dao;

import java.util.List;

import com.tyss.tysslibrary.dto.Books;

public interface BookDao {

	public boolean addBook(Books book);

	public boolean removeBook(int bId);

	public List<Books> getAllBook();

	public Books searchBook(String bName);
	
}
