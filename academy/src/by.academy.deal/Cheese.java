package by.academy.deal;

import by.academy.deal.validator.Validator;

public class Cheese extends Product {

	private int ageInDays;
	private double weight;

	public Cheese() {
		super();
	}

	public Cheese(String name, Double price, String manufacture, Integer quantity, int ageInDays, double weight) {
		super(name, price, manufacture, quantity);
		this.ageInDays = ageInDays;
		this.weight = weight;
	}

	@Override
	public double discount() {
		if (ageInDays > 20) {
			return 0.8;
		} else {
			return 1;
		}
	}

	public int getAgeInDays() {
		return ageInDays;
	}

	public void setAgeInDays(int ageInDays) {
		this.ageInDays = ageInDays;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Сыр{");
		sb.append("наименование - ").append(getName());
		sb.append(", цена - ").append(getPrice()).append("руб");
		sb.append(", производитель - ").append(getManufacture());
		sb.append(", количество - ").append(getQuantity()).append(" шт.");
		sb.append(", возраст сыра ").append(ageInDays).append(" дней");
		sb.append(", вес - ").append(weight).append(" гр.");
		sb.append('}');
		return sb.toString();
	}
}
