package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;

import com.example.lottery.service.business.StandardLotterService;
import com.example.random.service.QoS;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberService;

public class LotteryApp {

	public static void main(String[] args) throws Exception {
		var props = new Properties();
		props.load(new FileInputStream(new File("src","application.properties")));
		var qualityLevel = QualityLevel.valueOf(props.getProperty("random.service"));
		var lotteryService = new StandardLotterService();
		var services = ServiceLoader.load(RandomNumberService.class);
		var service = services.stream()
				              .map(Provider::get)
				              .filter(srv -> srv.getClass().isAnnotationPresent(QoS.class))
				              .filter(srv -> srv.getClass().getAnnotation(QoS.class).value()==qualityLevel)
				              .findFirst()
				              .orElseThrow();
		lotteryService.setRandomNumberService(service);
		lotteryService.getLotteryNumbers(60, 6, 10)
		              .forEach(System.out::println);
	}

}
