package by.academy.homework.lesson1;

public class Cat {
	public static void main(String[]... args) {
	
	int age;
	String nickname;
	
	public Cat() {
		super();	
	}
	
	public Cat(String nickname) {
		super();
		this.nickname = nickname;
	}
	public Cat(int age, String nickname) {
		super();
		this.age = age;
		this.nickname = nickname;
	}
	 
	public void grow () {
		 age++;		 
	 }
	 public void eat () {
		 System.out.println ("Eat");
	 }
	 public void sleep () {
		 System.out.println ("Sleep");
	 }
		 public void walk() {
			 System.out.println("Walk");
		 }
		 
	}
