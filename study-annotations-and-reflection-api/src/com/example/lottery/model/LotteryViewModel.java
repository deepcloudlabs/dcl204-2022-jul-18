package com.example.lottery.model;

import java.util.List;

import com.example.lottery.service.RandomNumber;

public class LotteryViewModel {
	@RandomNumber(min = 1, max = 60, distinct = true, sorted = true, size = 6)
	private List<Integer> numbers;

	public List<Integer> getNumbers() {
		return numbers;
	}

}
