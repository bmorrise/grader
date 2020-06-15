package com.fakecompany.grader.itemservice;

import com.fakecompany.grader.itemservice.exception.ExceptionOne;
import com.fakecompany.grader.itemservice.exception.ExceptionThree;
import com.fakecompany.grader.itemservice.exception.ExceptionTwo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class ItemServiceApplication
{
	
	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.submit(() -> {
			while (true)
			{
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName);
				Thread.sleep(Double.valueOf(Math.random() * 10000).longValue()+5000);
				Double random = Math.floor(Math.random() * 5);
				try
				{
					// First Exception
					if (random == 0)
					{
						throw new ExceptionOne("Exception One" + UUID.randomUUID().toString());
					}
					// Second Exception
					if (random == 1)
					{
						throw new ExceptionTwo("Exception Two" + UUID.randomUUID().toString());
					}
					// Third Exception
					if (random == 2)
					{
						throw new ExceptionThree("Exception Three" + UUID.randomUUID().toString());
					}
					// Fourth Exception
					if (random == 3)
					{
						throw new ExceptionThree("Exception Four" + UUID.randomUUID().toString());
					}
					// Fifth Exception
					if (random == 4)
					{
						throw new ExceptionThree("Exception Five" + UUID.randomUUID().toString());
					}
					else
					{
						throw new Exception("An error has occurred " + UUID.randomUUID().toString());
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		SpringApplication.run(ItemServiceApplication.class, args);
	}
	
}
