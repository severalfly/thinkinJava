package com.leon.io.compress;

import com.leon.constant.Constants;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPCompress
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader(Constants.PATH_PRE + "/rdata/data.txt"));
		BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(Constants.PATH_PRE + "/rdata/test.gz")));
		System.out.println("Write files");

		int c;
		while ((c = in.read()) != -1)
		{
			out.write(c);
		}
		in.close();
		out.close();

		System.out.println("Read Files");

		BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(Constants.PATH_PRE + "/rdata/test.gz"))));
		String s;
		while ((s = in2.readLine()) != null)
		{
			System.out.println(s);
		}
	}
}
