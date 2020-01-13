package com.tyss.Bussinessmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Products {
	@Id
	@Column
	private int id;
	@Column
	private String name;
	
}
