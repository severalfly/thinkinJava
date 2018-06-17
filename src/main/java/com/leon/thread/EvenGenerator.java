package com.leon.thread;

public class EvenGenerator extends IntGenerator
{
	private int currentEvenValue = 0;

	@Override
	public synchronized int next()
	{
		++currentEvenValue; // Danger point here
		++currentEvenValue;
		return currentEvenValue;
	}

	public static void main(String[] args)
	{
		EvenChecker.test(new EvenGenerator());
	}
}
