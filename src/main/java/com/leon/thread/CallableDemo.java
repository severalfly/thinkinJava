package com.leon.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo
{
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();
		for (int i = 0; i < 10; i++)
		{
			results.add(exec.submit(new TaskWithResult((i))));
		}
		for (Future<String> result : results)
		{
			try
			{
				System.out.println(result.get());
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}

class TaskWithResult implements Callable<String>
{
	private int id;

	public TaskWithResult(int id)
	{
		this.id = id;
	}

	@Override
	public String call() throws Exception
	{
		return "result of taskwithResult is: " + this.id;
	}

}

