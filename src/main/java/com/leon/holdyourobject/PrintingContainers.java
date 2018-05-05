package com.leon.holdyourobject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import com.alibaba.fastjson.JSONObject;

public class PrintingContainers
{
	static Collection fill(Collection<String> collection)
	{
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}

	static Map<String, String> fill(Map<String, String> map)
	{
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "Spot");
		return map;
	}

	public static void main(String[] args)
	{
		System.out.println(JSONObject.toJSONString(fill(new ArrayList<String>())));
		System.out.println(JSONObject.toJSONString(fill(new LinkedList<String>())));
		System.out.println(JSONObject.toJSONString(fill(new HashSet<String>())));
		System.out.println(JSONObject.toJSONString(fill(new TreeSet<String>())));
		System.out.println(JSONObject.toJSONString(fill(new LinkedHashSet<String>())));

		System.out.println(JSONObject.toJSONString(fill(new HashMap<String, String>())));
		System.out.println(JSONObject.toJSONString(fill(new TreeMap<String, String>())));
		System.out.println(JSONObject.toJSONString(fill(new LinkedHashMap<String, String>())));

	}
}
