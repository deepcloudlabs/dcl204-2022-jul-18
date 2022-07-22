package com.example.random.service.business;

import com.example.random.service.QoS;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

@QoS(QualityLevel.CHEAP)
public class CheapRandomNumberService implements RandomNumberService {
	private static int counter = 0;
	@Override
	public int generate(int min, int max) {
		System.err.println("CheapRandomNumberService::generate");
		counter++;
		return min + (counter % (max-min+1) );
	}

}
