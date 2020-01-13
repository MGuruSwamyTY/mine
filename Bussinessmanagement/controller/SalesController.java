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
import com.tyss.Bussinessmanagement.dto.Sales;
import com.tyss.Bussinessmanagement.dto.SalesResponse;
import com.tyss.Bussinessmanagement.sevice.ISalesService;

@RestController
@CrossOrigin(allowCredentials = "true",allowedHeaders = "*",origins = "*")
@RequestMapping("/sales")
public class SalesController {
	@Autowired
	private ISalesService service;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		CustomDateEditor editor = new CustomDateEditor(format, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	
	@PostMapping(path ="/sale", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse addproduct(@RequestBody Sales sale	) {
		System.out.println("in controller::"+sale.getId());
		SalesResponse response = new SalesResponse();
		if (service.insert(sale)) {
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
	
	
	
	@PutMapping(path ="/sale", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse updateproduct(@RequestBody Sales sale) {
		SalesResponse response = new SalesResponse();
		if (service.update(sale)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully updated..");
			response.setListBill(Arrays.asList(sale));
		} else {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully updated..");
		}
		return response;
	}
	
	
	
	@DeleteMapping(path ="/sale/{Id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse deleteproduct(@PathVariable int Id) {
		System.out.println("sale id::"+Id);
		SalesResponse response = new SalesResponse();
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

	@GetMapping(path = "/sale", produces = MediaType.APPLICATION_JSON_VALUE)
	public SalesResponse getAllsales() {
		SalesResponse response = new SalesResponse();
		List<Sales> list = service.getallSales();
		if (list == null) {
			response.setStatusCode(400);
			response.setMessage("failure");
			response.setDescription("data not successfully retrived..");
		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("data  successfully retrived");
			response.setListBill(list);;
		}
		return response;
	}
	
}
