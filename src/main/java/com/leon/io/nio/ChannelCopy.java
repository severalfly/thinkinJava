package com.leon.io.nio;

import com.leon.constant.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy
{
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception
	{
		String name1 = Constants.PATH_PRE + "/rdata/name1.txt";
		String name2 = Constants.PATH_PRE + "/rdata/name2.txt";
		FileChannel in = new FileInputStream(name1).getChannel();
		FileChannel out = new FileOutputStream(name2).getChannel();

		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		while (in.read(buff) != -1)
		{
			buff.flip();
			out.write(buff);
			buff.clear();
		}

	}
}
