package com.leon.initialization;

public class Flower
{
	int petalCount = 0;
	String s = "initial value";

	public Flower(int petalCount)
	{
		//		this("ttt"); todo 11111111
		this.petalCount = petalCount;
		System.out.println("Constructor w/ int arg only, petalCount = " + this.petalCount);
	}

	public Flower(String s)
	{
		//		this(1);  todo 22222， 与 11111111 不能同时打开，会有重复构造方法的编译错误
		this.s = s;
		System.out.println("Constructor w/ String arg only, s = " + this.s);
	}

	public Flower(int petalCount, String s)
	{
		this(petalCount);
		//		this(s); todo // 这里是不能再次调用构造方法的，因为
		this.s = s;
		System.out.println("String & int args");

	}

	public Flower()
	{
		this(47, "hi");
		System.out.println("default constructro (no args)");
	}

	void printPetalCount()
	{
		System.out.println("petalcount = " + this.petalCount + " s = " + this.s);
	}

	public static void main(String[] args)
	{
		Flower x = new Flower();
		x.printPetalCount();
	}
}
