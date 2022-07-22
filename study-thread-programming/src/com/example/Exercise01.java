package com.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Thread:  i) Multi-tasking 
//         ii) Multi-core -> Parallel Programming
public class Exercise01 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Application is just started.");
		var task1 = new LotteryTask();
		var task2 = new LotteryTask();
		var t1 = new Thread(task1); // Platform (OS) manages -> Kernel-level Thread
		var t2 = new Thread(task2);
		t1.start();
		t2.start();
		t1.join();
		System.out.println(task1.getNumbers());
		t2.join();
		System.out.println(task2.getNumbers());
		System.out.println("Application is done.");
	}

}

class LotteryTask implements Runnable {

	private List<Integer> numbers;

	@Override
	public void run() {
		numbers = ThreadLocalRandom.current().ints(1, 60).distinct().limit(6).sorted().boxed().toList();
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}
