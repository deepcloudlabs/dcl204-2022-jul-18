package com.example.lottery.service;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public interface LotteryService {
	Set<Integer> getLotteryNumbers(int max, int size);

	default List<Set<Integer>> getLotteryNumbers(int max, int size, int column){
		return IntStream.range(0, column)
				        .mapToObj( i -> getLotteryNumbers(max, size))
				        .toList();
	}
}
