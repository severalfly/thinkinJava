package com.leon.thread.ext;

public class Ext6
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 100; i++)
		{
			new Thread(new TaskExt6(i)).start();
		}
	}
}

class TaskExt6 implements Runnable
{
	private int id;

	public TaskExt6(int id)
	{
		this.id = id;
	}

	@Override
	public void run()
	{
		try
		{

			long sleep = this.id;
			Thread.sleep(sleep);
			System.out.println(sleep);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
