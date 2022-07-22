package com.example.lottery.service.business;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberService;

public class StandardLotterService implements LotteryService {
	private RandomNumberService randomNumberService;
	
	
	public void setRandomNumberService(RandomNumberService randomNumberService) {
		this.randomNumberService = randomNumberService;
	}

	@Override
	public Set<Integer> getLotteryNumbers(int max, int size) {
		return IntStream.generate( () -> randomNumberService.generate(1, max))
				        .distinct()
				        .limit(size)
				        .sorted()
				        .boxed()
				        .collect(Collectors.toSet());
	}

}
