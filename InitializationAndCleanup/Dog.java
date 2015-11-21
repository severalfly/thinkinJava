public class Dog
{
	private void bark(String name)
	{
		System.out.println(name);
	}

	private void bark(int name)
	{
		System.out.println(name);
	}
	public static void main(String[] args) {
		Dog dog = new Dog();
			dog.bark("hello world!!!");
			dog.bark(8);
		}
}
