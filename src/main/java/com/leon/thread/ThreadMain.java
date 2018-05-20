package com.leon.thread;

public class ThreadMain
{
	public static void main(String[] args)
	{
		lannchMore();
		//		lannchOnce();
	}

	private static void lannchMore()
	{
		for (int i = 0; i < 5; i++)
		{
			new Thread(new LiftOff(5)).start();
		}
		System.out.println("waiting for LiftOff");
	}

	private static void lannchOnce()
	{
		LiftOff launch = new LiftOff(5);
		Thread thread = new Thread(launch);
		thread.start();
		System.out.println("Waiting for LiftOff");
	}
}
