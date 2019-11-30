package com.tyss.tysslibrary.dao;

import java.util.ArrayList;
import java.util.Collection;

import com.tyss.tysslibrary.dto.Books;
import com.tyss.tysslibrary.dto.Librarian;

public interface LibrarianDao {

	public Librarian auth(String email, String password);
	
	public boolean addbook(Books books);
	
	public ArrayList<Books> getAllbooks();
	
	public boolean removebook(int bId);
	
	public ArrayList<Books> searchbooks(String bName);
	
}