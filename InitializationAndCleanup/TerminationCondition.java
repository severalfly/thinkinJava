class Book{
	public static int cnt = 0; 
	boolean checkedOut = false;
	Book(boolean checkOut)
	{
		this.checkedOut = checkOut;
	}
	void checkIn()
	{
		System.out.println("test");
		this.checkedOut = false;
	}

	protected void finalize()
	{
		Book.cnt ++;
		System.out.println(cnt);
		if(this.checkedOut)
		{
			System.out.println("Error: checked out");
		}
	}
}
public class TerminationCondition
{
	public static void main(String[] args) {
		Book novel = new Book(true);
		novel.checkIn();

		new Book(true);
		System.gc();
	}
}