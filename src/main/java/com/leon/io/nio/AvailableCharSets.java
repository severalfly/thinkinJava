package com.leon.io.nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class AvailableCharSets
{
	public static void main(String[] args)
	{
		SortedMap<String, Charset> charSets = Charset.availableCharsets();

	}
}
