package com.tyss.tysslibrary.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyss.tysslibrary.dto.Books;
import com.tyss.tysslibrary.dto.Librarian;
import com.tyss.tysslibrary.service.LibrarianService;

@Controller
@RequestMapping("/librarian")
public class LibrarianController {
	@Autowired
	private LibrarianService service;

	@GetMapping("/login")
	public String loginPage(HttpServletRequest req) {
		if(req.getSession(false)==null) {
			return "login";
		}
		return "home";
	}
	
	@PostMapping("/login")
	public String login(String email,String password, ModelMap map, HttpServletRequest request) {
		Librarian librarian=service.auth(email, password);
		if(librarian==null) {
			map.addAttribute("msgred", "Invalid credentials");
			return "login";
		}
		request.getSession().setAttribute("librarian", librarian);
		return "home";
	}
	
	@GetMapping("/addbook")
	public String getIndex() {
		return "addbook";
	}

	@PostMapping("/addbook")
	public String addBook(Books book,ModelMap model) {
		if(service.addBook(book)) {
			return "home";
		}
		return "error";
	}
	
	@GetMapping("/getallbooks")
	public String getallbook(Books books,ModelMap map, HttpServletRequest request) {
		if(request.getSession(false)==null) {
			return "home";
		}
		ArrayList<Books> book1=(ArrayList<Books>) service.getAllBook();
		map.addAttribute("list", book1);
		return "getallbook";
	}
	
	@GetMapping("/deletebook")
	public String delete(@RequestParam("bId")Integer bId, ModelMap map,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null) {
			service.removeBook(bId);
			map.addAttribute("msg", "The book deleted");
			session.invalidate();
		}
		return "redirect:home";
	}
	
	@GetMapping("/searchbooks")
	public String searchbooks(@RequestParam("bName")String bName,ModelMap map, HttpServletRequest request) {
		if(request.getSession(false)==null) {
			return "home";
		}
		ArrayList<Books> book1=(ArrayList<Books>) service.searchBook(bName);
		map.addAttribute("list", book1);
		return "searchbooks";
	}
	
	
	@GetMapping("/home")
	public String home(HttpServletRequest request) {
		if(request.getSession(false)==null) {
			return "login";
		}
		return "home";
	}
	
}
