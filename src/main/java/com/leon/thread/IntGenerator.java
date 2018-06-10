package com.leon.thread;

public abstract class IntGenerator
{
	private volatile boolean canceled = false;

	public abstract int next();

	public void cnacel()
	{
		this.canceled = true;
	}

	public boolean isCanceled()
	{
		return this.canceled;
	}
}
