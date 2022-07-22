package com.example.lottery.application;

import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotterService;
import com.example.random.service.RandomNumberService;

public class LotteryApp {

	public static void main(String[] args) {
		var lotteryService = new StandardLotterService();
		var services = ServiceLoader.load(RandomNumberService.class);
		lotteryService.setRandomNumberService(services.findFirst().get());
		lotteryService.getLotteryNumbers(60, 6, 10)
		              .forEach(System.out::println);
	}

}
