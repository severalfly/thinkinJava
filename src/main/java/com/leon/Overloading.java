package com.leon;

public class Overloading
{
	public void p(int i)
	{
		System.out.println("int " + i);
	}

	public void p(long i)
	{
		System.out.println("long " + i);
	}

	public static void main(String[] args)
	{
		Overloading o = new Overloading();
		o.p(5);
	}
}
