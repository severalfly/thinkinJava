package com.leon.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Count
{
	private int count = 0;
	private Random rand = new Random(47);

	public synchronized int increment()
	{
		int tmp = this.count;
		if (this.rand.nextBoolean())
		{
			Thread.yield();
		}
		return (this.count = ++tmp);
	}

	public synchronized int value()
	{
		return this.count;
	}
}

class Entrance implements Runnable
{
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<>();
	private int number = 0;

	private int id;
	private static volatile boolean canceled = false;

	public static void cancel()
	{
		canceled = true;
	}

	public Entrance(int id)
	{
		this.id = id;
		entrances.add(this);
	}

	@Override
	public void run()
	{
		while (!canceled)
		{
			synchronized (this)
			{
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
			try
			{
				Thread.sleep(100);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Stopping " + this);
	}

	private synchronized int getValue()
	{
		return this.number;
	}

	@Override
	public String toString()
	{
		return "Entrance{id=" + id + ": " + getValue() + '}';
	}

	public static int getTotalCount()
	{
		return count.value();
	}

	public static int sumEntrances()
	{
		int sum = 0;
		for (Entrance entrance : entrances)
		{
			sum += entrance.getValue();
		}
		return sum;
	}

}

public class OrnamentalGarden
{
	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
		{
			exec.execute(new Entrance(i));
		}
		Thread.sleep(3 * 1000L);
		Entrance.cancel();
		exec.shutdown();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
		{
			System.out.println("Some tasks were not terminated!");
		}
		System.out.println("Total: " + Entrance.getTotalCount());
		System.out.println("sum of entrances: " + Entrance.sumEntrances());
	}
}
