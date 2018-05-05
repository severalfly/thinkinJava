package com.leon.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

public class DirList2 {
	public static FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return this.pattern.matcher(name).matches();
			}
		};
	}

	public static void main(String[] args) {
		File path = new File(".");
		String[] list = null;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(filter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(JSONObject.toJSONString(list));
	}
}
