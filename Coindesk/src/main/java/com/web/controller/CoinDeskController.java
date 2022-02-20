package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.BpiDto;
import com.web.dto.CoinDeskDto;
import com.web.dto.CoinDeskDto.BpiDetail;
import com.web.entity.Bpi;
import com.web.service.CoindeskService;


@RestController
@RequestMapping("/api")
public class CoinDeskController {

	@Autowired
	CoindeskService coindeskService;

	/**
	 * 取得 coindesk 更新時間
	 */
	@GetMapping("/getCoindeskApi")
	public CoinDeskDto getCoindeskApi() {
		return coindeskService.getCoindeskApi();
	}

	/**
	 * 取得 coindesk 更新時間
	 */
	@GetMapping("/getUpdateTime")
	public String getUpdateTime() {
		return coindeskService.getUpdateTime();
	}

	/**
	 * 取得 coindesk 幣別相關資訊 USD
	 */
	@GetMapping("/getUSD")
	public BpiDetail getUSD() {
		return coindeskService.getUSD();
	}

	/**
	 * 取得幣別資料
	 */
	@GetMapping("/bpi")
	public List<Bpi> getBpi() {
		return coindeskService.retrieveBpi();
	}

	/**
	 * 新增幣別資料
	 */
	@PostMapping("/bpi")
	public Bpi createBpi(@RequestBody BpiDto bpi) {
		return coindeskService.createBpi(bpi);
	}

	/**
	 * 刪除幣別資料
	 */
	@DeleteMapping("/bpi/{bpiId}")
	public void deleteBpi(@PathVariable(name="bpiId")Long bpiId) {
		coindeskService.deleteBpi(bpiId);
	}

	/**
	 * 更新幣別資料
	 */
	@PutMapping("/bpi/{bpiId}")
	public Bpi updateBpi(@PathVariable(name="bpiId")Long bpiId, @RequestBody BpiDto bpi) {
		return coindeskService.updateBpi(bpiId, bpi);
	}
}
