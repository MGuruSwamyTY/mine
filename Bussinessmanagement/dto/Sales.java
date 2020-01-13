package com.tyss.Bussinessmanagement.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Sales {
	@Id
	@Column
	private int id;
	@Column
	private int p_id;
	@Column
	private Date date;
	@Column
	private int quantity;
	@Column
	private double prize;
}
