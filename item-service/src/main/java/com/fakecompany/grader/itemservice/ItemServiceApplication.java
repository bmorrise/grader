package com.fakecompany.grader.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ItemServiceApplication {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(() -> {
			while (true) {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName);
				Thread.sleep(5000);
				try
				{
					throw new Exception("An error has occurred");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		SpringApplication.run(ItemServiceApplication.class, args);
	}

}
