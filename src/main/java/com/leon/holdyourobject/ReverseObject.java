package com.leon.holdyourobject;

import java.util.LinkedList;

/**
 * 倒序一个字符串
 * @author zhangyunfei
 *
 */
public class ReverseObject
{
	public static void main(String[] args)
	{
		String str = "abcdefg";
		LinkedList<Character> list = new LinkedList<Character>();
		for (int i = 0; i < str.length(); i++)
		{
			list.addLast(str.charAt(i));
		}
		Character c = null;
		StringBuffer sb = new StringBuffer();
		do
		{
			c = list.pollLast();
			sb.append(c == null ? "" : c);
		}
		while (c != null);
		System.out.println(sb);
	}
}
