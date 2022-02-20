package com.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BpiDto {
	private String code;
	private String symbol;
	private String description;
	private String rateFloat;
}
