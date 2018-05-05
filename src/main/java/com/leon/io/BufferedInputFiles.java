package com.leon.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFiles {
	public static String read(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String s = "";
		StringBuffer sb = new StringBuffer();
		while ((s = reader.readLine()) != null) {
			sb.append(s + "\n");
		}
		reader.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		System.out.println(read("pom.xml"));
	}
}
