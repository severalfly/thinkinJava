package com.leon.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class AtoicIntegerTest implements Runnable
{
	private AtomicInteger i = new AtomicInteger(0);

	public AtomicInteger getI()
	{
		return this.i;
	}

	public void setI(AtomicInteger i)
	{
		this.i = i;
	}

	@Override
	public void run()
	{

	}
}
