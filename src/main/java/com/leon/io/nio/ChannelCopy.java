package com.leon.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelCopy
{
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws Exception
	{
		FileChannel in = new FileInputStream("").getChannel();
		FileChannel out = new FileOutputStream("").getChannel();

		ByteBuffer buff = ByteBuffer.allocate(BSIZE);

	}
}
