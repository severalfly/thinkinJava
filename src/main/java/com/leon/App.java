package com.leon;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        List<String> list = new ArrayList<>();
        list.add("aaa");
        for (String str : list)
        {
            System.out.println(str);
        }
	}

}
