package com.tyss.Bussinessmanagement.dto;

import java.util.List;

import lombok.Data;
@Data
public class SalesResponse {
	private int statusCode;
	private String message;
	private String description;
	
	private List<Sales> listBill;
}
