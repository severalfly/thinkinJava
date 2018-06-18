package com.leon.thread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

class LiftOffRunner implements Runnable
{
	private BlockingQueue<LiftOff> rockets;

	public LiftOffRunner(BlockingQueue<LiftOff> rockets)
	{
		this.rockets = rockets;
	}

	public void add(LiftOff lo)
	{
		try
		{
			this.rockets.put(lo);
		}
		catch (Exception e)
		{
			System.out.println("Interrupted during put()");
		}
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				LiftOff lo = rockets.take();
				lo.run();
			}
		}
		catch (Exception e)
		{
			System.out.println("Waking from take()");
		}
		System.out.println("Exiting LoftOffRunner");
	}
}

public class TestBlockQueues
{
	static void getKey()
	{
		try
		{
			new BufferedReader(new InputStreamReader(System.in)).readLine();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	static void getKey(String message)
	{
		System.out.println(message);
		getKey();
	}

	static void test(String msg, BlockingQueue<LiftOff> queue)
	{
		System.out.println(msg);
		LiftOffRunner runner = new LiftOffRunner(queue);
		Thread t = new Thread(runner);
		t.start();
		for (int i = 0; i < 5; i++)
		{
			runner.add(new LiftOff(2));
		}
		getKey("Press 'Enter' (" + msg + ")");
		t.interrupt();
		System.out.println("Finish " + msg + " test");
	}

	public static void main(String[] args)
	{
		test("LinkedBlockingQueue", new LinkedBlockingDeque<>());
		test("ArrayBlockingQueue", new ArrayBlockingQueue<>(3));
		test("SynchronousQueue", new SynchronousQueue<>());

	}
}
