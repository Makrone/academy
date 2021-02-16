package by.academy.deal;

public class Wine extends Product {
	private String country;
	private int age;

	public Wine() {
		super();
	}

	public Wine(String name, Double price, String manufacture, Integer quantity, String country, int age) {
		super(name, price, manufacture, quantity);
		this.age = age;
		this.country = country;
	}

	@Override
	public double discount() {
		if (country.equals("Italy")) {
			return 0.83;
		} else {
			return 1;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Вино{");
		sb.append("наименование - ").append(getName());
		sb.append(", цена - ").append(getPrice()).append("руб");
		sb.append(", производитель - ").append(getManufacture());
		sb.append(", количество - ").append(getQuantity()).append(" шт.");
		sb.append(", страна - ").append(country);
		sb.append(", выдержка - ").append(age).append(" лет");
		sb.append('}');
		return sb.toString();
	}
}

