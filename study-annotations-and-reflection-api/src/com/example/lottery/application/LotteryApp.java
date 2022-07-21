package com.example.lottery.application;

import com.example.lottery.model.LotteryViewModel;
import com.example.lottery.service.RandomNumberGeneratorService;

public class LotteryApp {

	public static void main(String[] args) {
		var lotteryModel = new LotteryViewModel();
		var service = new RandomNumberGeneratorService();
		service.generate(lotteryModel);
		System.out.println(lotteryModel.getNumbers());
	}

}
