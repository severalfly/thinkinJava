package com.leon.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSONObject;

/**
 * Produce a sequence of file Objects that match a regular expression in either
 * a local directory. or by walking a directory tree
 * 
 * @author zhangyunfei
 *
 */
public class Directory {
	public static File[] local(File dir, final String regex) {
		return dir.listFiles(new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				return this.pattern.matcher(new File(name).getName()).matches();
			}
		});
	}

	public static File[] local(String pathname, final String regex) {
		return local(new File(pathname), regex);
	}

	public static void main(String[] args) {
		System.out.println(TreeInfo.walk("."));
	}

}

class TreeInfo implements Iterable<File> {
	public List<File> files = new ArrayList<File>();
	public List<File> dirs = new ArrayList<File>();

	@Override
	public Iterator<File> iterator() {
		return files.iterator();
	}

	void addAll(TreeInfo other) {
		this.files.addAll(other.files);
		this.dirs.addAll(other.dirs);

	}

	@Override
	public String toString() {
		return "dirs size: " + (this.dirs == null ? 0 : this.dirs.size()) + ", content: "
				+ JSONObject.toJSONString(this.dirs) + "\n\nfiles size: " + (this.files == null ? 0 : this.files.size())
				+ ", content; " + JSONObject.toJSONString(this.files);
	}

	public static TreeInfo walk(String start, String regex) {
		return recurseDirs(new File(start), regex);
	}

	public static TreeInfo walk(File start, String regex) {
		return recurseDirs(start, regex);
	}

	public static TreeInfo walk(String start) {
		return recurseDirs(new File(start), ".*");
	}

	public static TreeInfo walk(File start) {
		return recurseDirs(start, ".*");
	}

	private static TreeInfo recurseDirs(File startDir, String regex) {
		TreeInfo result = new TreeInfo();

		for (File item : startDir.listFiles()) {
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			} else {
				if (item.getName().matches(regex)) {
					result.files.add(item);
				}
			}
		}
		return result;
	}

}
