package com.leon.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalVariableHolder
{
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>()
	{
		private Random rand = new Random();

		protected synchronized Integer initialValue()
		{
			return rand.nextInt(10000);
		}
	};

	public static void increment()
	{
		value.set(value.get() + 1);
	}

	public static int get()
	{
		return value.get();
	}

	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
		{
			exec.execute(new Accessor(i));
		}
		Thread.sleep(3000);
		exec.shutdown();
	}
}

class Accessor implements Runnable
{
	private int id;

	public Accessor(int id)
	{
		this.id = id;
	}

	@Override
	public void run()
	{
		while (!Thread.currentThread().isInterrupted())
		{
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	@Override
	public String toString()
	{
		return "Accessor{" + "id=" + id + ": " + ThreadLocalVariableHolder.get() + '}';
	}
}