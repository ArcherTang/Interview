package com.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "BPI")
public class Bpi {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String code;
	private String symbol;
	private String rate;
	private String description;
	private String rateFloat;
}
