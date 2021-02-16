package by.academy.deal;

public class Person {

	private String name;
	private Double money;

	public Person() {
		super();
	}
	public Person(String name, Double money) {
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
}

