package com.leon.thread;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Meal
{
	private int orderNum;

	Meal(int orderNum)
	{
		this.orderNum = orderNum;
	}

	@Override
	public String toString()
	{
		return "Meal{" + "orderNum=" + orderNum + '}';
	}
}

class WaitPerson implements Runnable
{
	private Restaurant restaurant;

	WaitPerson(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				synchronized (this)
				{
					while (this.restaurant.getMeal() == null)
					{
						wait();
					}
				}
				System.out.println("WaitPerson got " + this.restaurant.getMeal());
				synchronized (restaurant.getChef())
				{
					this.restaurant.setMeal(null);
					restaurant.getChef().notifyAll();
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("WaitPerson interrupted");
		}
	}
}

class Chef implements Runnable
{
	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				synchronized (this)
				{
					while (this.restaurant.getMeal() != null)
					{
						wait();
					}
				}
				if (++this.count == 10)
				{
					System.out.println("Out of food. closing");
					this.restaurant.exec.shutdownNow();
				}
				System.out.print("Order up! ");
				synchronized (this.restaurant.waitPerson)
				{
					//					System.out.println("add for notice " + this.count);
					this.restaurant.setMeal(new Meal(this.count));
					this.restaurant.waitPerson.notifyAll();
				}
				Thread.sleep(100L);
			}
		}
		catch (Exception e)
		{
			System.out.println("Chef intterrupted");
		}

	}
}

@Data
public class Restaurant
{
	private Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	private Chef chef = new Chef(this);

	public Restaurant()
	{
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args)
	{
		new Restaurant();
	}
}
