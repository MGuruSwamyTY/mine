package com.tyss.tysslibrary.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.tysslibrary.dao.LibrarianDao;
import com.tyss.tysslibrary.dto.Books;
import com.tyss.tysslibrary.dto.Librarian;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	private LibrarianDao dao;

	@Override
	public boolean addBook(Books book) {
		return dao.addbook(book);
	}

	@Override
	public boolean removeBook(int bId) {
		return dao.removebook(bId);
	}

	@Override
	public List<Books> getAllBook() {
		return dao.getAllbooks();
	}

	@Override
	public ArrayList<Books> searchBook(String bName) {
		return dao.searchbooks(bName);
	}

	@Override
	public Librarian auth(String email, String password) {
		return dao.auth(email, password);
	}

}
