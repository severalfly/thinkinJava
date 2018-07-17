package com.leon.io;

import java.io.*;

public class Redirecting
{
	public static void main(String[] args) throws IOException
	{
		PrintStream console = System.out;

		BufferedInputStream in = new BufferedInputStream(new FileInputStream("rdata/data.txt"));
		PrintStream out = new PrintStream(new FileOutputStream("rdata/test.out"));

		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null)
			System.out.println(s);
		out.close();
		System.setOut(console);
	}
}
