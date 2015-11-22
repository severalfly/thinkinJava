public class Exercise9
{
	int a = 0;
	public Exercise9()
	{
		this(5);
		// a = 5;
	}
	public Exercise9(int i)
	{
		this.a = i;
	}


	public static void main(String[] args) {
		Exercise9 e = new Exercise9(5);
		System.out.println(e.a);
	}
}