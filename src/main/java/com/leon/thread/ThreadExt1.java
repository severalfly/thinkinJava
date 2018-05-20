package com.leon.thread;

public class ThreadExt1
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 100; i++)
		{
			new Thread(new SubExt1()).start();
		}
		System.out.println("all start");
	}
}

class SubExt1 implements Runnable
{
	private static int cnt = 0;
	private final int id = cnt++;

	public SubExt1()
	{
		System.out.println(this.id + " start...");
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 3; i++)
		{
			System.out.println(this + "  " + i);
			Thread.yield();
		}
		System.out.println(this + "  end...");
	}

	@Override
	public String toString()
	{
		return "#" + this.id;
	}
}
