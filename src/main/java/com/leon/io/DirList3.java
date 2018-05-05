package com.leon.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

/**
 * 列出当前文件夹的内容
 * 
 * @author zhangyunfei
 *
 */
public class DirList3 {
	public static void main(final String[] args) {
		File path = new File(".");
		String[] list = null;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);

				@Override
				public boolean accept(File dir, String name) {
					return this.pattern.matcher(name).matches();
				}
			});
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(JSONObject.toJSONString(list));
	}
}
