package com.tyss.Bussinessmanagement.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.Bussinessmanagement.dto.ProductResponce;
import com.tyss.Bussinessmanagement.dto.Products;
import com.tyss.Bussinessmanagement.sevice.IProductService;



@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*",origins = "*")
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private IProductService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@PostMapping(path ="/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce addproduct(@RequestBody Products products	) {
		System.out.println("in controller::"+products.getId());
		ProductResponce response = new ProductResponce();
		if (service.insert(products)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully stored..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully stored..");
			
		}
		return response;
	}
	
	
	
	@PutMapping(path ="/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce updateproduct(@RequestBody Products product) {
		ProductResponce response = new ProductResponce();
		if (service.update(product)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully updated..");
			response.setListBill(Arrays.asList(product));
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully updated..");
		}
		return response;
	}
	
	
	
	@DeleteMapping(path ="/product/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce deleteproduct(@PathVariable int Id) {
		System.out.println("employee id::"+Id);
		ProductResponce response = new ProductResponce();
		if (service.delete(Id)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data successfully deleted..");
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully deleted..");
		}
		return response;
	}

	@GetMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponce getAllproducts() {
		ProductResponce response = new ProductResponce();
		List<Products> list = service.getallProducts();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully retrived");
			response.setListBill(list);
		}
		return response;
	}
	
}
