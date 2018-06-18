package com.leon.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Car
{
	private boolean waxOn = false;

	public synchronized void waxed()
	{
		this.waxOn = true;
		notifyAll();
	}

	public synchronized void buffed()
	{
		this.waxOn = false;
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException
	{
		while (this.waxOn == false)
		{
			wait();
		}
	}

	public synchronized void waitForBuffing() throws InterruptedException
	{
		while (this.waxOn == true)
		{
			wait();
		}
	}
}

class WaxOn implements Runnable
{
	private Car car;

	public WaxOn(Car c)
	{
		this.car = c;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				System.out.print("Wax On! ");
				Thread.sleep(200);
				this.car.waxed();
				this.car.waitForBuffing();
			}
		}
		catch (Exception e)
		{
			System.out.println("Exiting while wax on");
		}
		System.out.println("Eding Wax On task");
	}
}

class WaxOff implements Runnable
{
	private Car car;

	public WaxOff(Car car)
	{
		this.car = car;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				this.car.waitForWaxing();
				System.out.println("Wax Off!");
				Thread.sleep(200);
				this.car.buffed();
			}
		}
		catch (Exception e)
		{
			System.out.println("Exiting while wax off");

		}
		System.out.println("Ending Wax Off task");
	}
}

public class WaxOMatic
{
	public static void main(String[] args) throws InterruptedException
	{
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));

		Thread.sleep(5 * 1000L);
		exec.shutdownNow();
	}
}
