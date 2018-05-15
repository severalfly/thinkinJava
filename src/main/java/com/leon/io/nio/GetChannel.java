package com.leon.io.nio;

import com.leon.constant.Constants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel
{
	private static final int BSIZE = 1024;

	public static void main(String[] args) throws  Exception
	{
		String name = Constants.PATH_PRE + "/rdata/data.txt";
		FileChannel fc = new FileOutputStream(name).getChannel();
		fc.write(ByteBuffer.wrap("Some text\n".getBytes()));
		fc.close();

		fc = new RandomAccessFile(name, "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap("More text\n".getBytes()));
		fc.close();

		fc = new FileInputStream(name).getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();

		while (buff.hasRemaining())
		{
			System.out.print((char) buff.get());
		}

	}
}
