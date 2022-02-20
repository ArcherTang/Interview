package com.web.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoinDeskDto {

	private Time time;
	private Bpi bpi;


	@Getter
	@Setter
	@ToString
	public class Time {
		private String updated;
		private String updatedISO;
		private String updateduk;
	}

	@Getter
	@Setter
	@ToString
	public class Bpi {
		private BpiDetail USD;
		private BpiDetail GBP;
		private BpiDetail EUR;
	}

	@Getter
	@Setter
	@ToString
	public class BpiDetail {
		private String code;
		private String symbol;
		private String rate;
		private String description;
		private String rateFloat;
	}
}
