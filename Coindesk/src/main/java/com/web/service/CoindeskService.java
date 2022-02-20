package com.web.service;

import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.web.dto.BpiDto;
import com.web.dto.CoinDeskDto;
import com.web.dto.CoinDeskDto.BpiDetail;
import com.web.entity.Bpi;
import com.web.repository.BpiRepository;
import com.web.util.ApiUtils;

@Service
public class CoindeskService {
	private static final String COINDESK_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

	@Autowired BpiRepository bpiRepository;

	private CoinDeskDto callCoindeskApi() {
		return ApiUtils.callApi(COINDESK_URL, CoinDeskDto.class);
	}

	public CoinDeskDto getCoindeskApi() {
		return callCoindeskApi();
	}

	public String getUpdateTime() {
		return callCoindeskApi().getTime().getUpdated();
	}

	public BpiDetail getUSD() {
		return callCoindeskApi().getBpi().getUSD();
	}

	public BpiDetail getGBP() {
		return callCoindeskApi().getBpi().getGBP();
	}

	public BpiDetail getEUR() {
		return callCoindeskApi().getBpi().getEUR();
	}

	public List<Bpi> retrieveBpi() {
		return bpiRepository.findAll();
	}

	public Bpi createBpi(BpiDto bpiDto) {
		Bpi bpi = new Bpi();
		bpi.setCode(bpiDto.getCode());
		bpi.setSymbol(bpiDto.getSymbol());
		bpi.setDescription(bpiDto.getDescription());
		bpi.setRateFloat(bpiDto.getRateFloat());
		bpi.setRate(addThousandsSeparator(bpiDto.getRateFloat()));

		return bpiRepository.save(bpi);
	}

	public void deleteBpi(long id) {
		bpiRepository.deleteById(id);
	}

	public Bpi updateBpi(long id, BpiDto bpiDto) {
		Bpi bpi = bpiRepository.findById(id)
				.orElseThrow(() -> new ResourceAccessException("Employee not found for this id :: " + id));

		if(StringUtils.isNotEmpty(bpiDto.getCode())) {
			bpi.setCode(bpiDto.getCode());
		}
		if(StringUtils.isNotEmpty(bpiDto.getSymbol())) {
			bpi.setSymbol(bpiDto.getSymbol());
		}
		if(StringUtils.isNotEmpty(bpiDto.getDescription())) {
			bpi.setDescription(bpiDto.getDescription());
		}
		if(StringUtils.isNotEmpty(bpiDto.getRateFloat())) {
			bpi.setRateFloat(bpiDto.getRateFloat());
			bpi.setRate(addThousandsSeparator(bpiDto.getRateFloat()));
		}

		return bpiRepository.save(bpi);
	}

	/**
	 * 加上千分位
	 */
	private String addThousandsSeparator(String input) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(5);
		return nf.format(Double.valueOf(input));
	}
}
