package com.leon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		System.out.println("start to input your words(double empty line to exit)");
		boolean br= false;
		while ((s = reader.readLine()) != null )
		{
			if (s.length() != 0)
			{
				System.out.println(s.toUpperCase());
				br = false;
			}
			else
			{
				if (br)
				{
					break;
				}
				else
				{
					br = true;
				}


			}
		}
		System.out.println("done");
	}
}
