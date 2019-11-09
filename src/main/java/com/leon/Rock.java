package com.leon;

public class Rock
{
	public Rock(int i)
	{
		System.out.println("Rock");
		if (i > 0)
		{
			return;
		}
		System.out.println("end");
	}

	public static void main(String[] args)
	{
		Rock rock = new Rock(1);

	}
}
