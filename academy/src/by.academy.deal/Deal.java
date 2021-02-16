package by.academy.deal;

import by.academy.deal.Person;
import by.academy.deal.Cheese;
import by.academy.deal.Bread;
import by.academy.deal.Product;
import by.academy.deal.Wine;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Deal {
	private Person seller;
	private Person buyer;
	private Product[] products;
	private double priceBill;
	private int countProducts = 0;
	public static final int MIN_LENGTH_ARRAY = 1;
	private static final LocalDate dealDate = LocalDate.now();
	private static final LocalDate deadlineDate = LocalDate.now().plusDays(10);
	public static final String MENU_DEAL = """
            Меню сделки:
            Введите:
            1.Добавить продукт в сделку
            2.Удалить продукт из сделки по его наименованию
            3.Вывести информацию о сделке
            4.Провести сделку
            0.Выход в главное меню""";
	public static final String MENU_PRODUCT = """
            Меню продуктов:
            Введите:
            1.Добавить хлеб
            2.Добавить вино
            3.Добавить сыр
            0.Выход в меню сделки""";

	public Deal() {
		super();
	}

	public Deal(Person seller, Person buyer, Product[] products) {
		this.seller = seller;
		this.buyer = buyer;
		this.products = products;
	}

	private double priceBill() {
		double price = 0;
		if (products != null && products[0] != null) {
			for (Product product : products) {
				if (product != null) {
					price += product.getPrice() * product.discount() * product.getQuantity();
					System.out.println(product.getName() + ", цена: " + product.getPrice() + "$, количество: "
							+ product.getQuantity() + " шт., скидка: " + (int)((1 - product.discount()) * 100) + "%, итого: "
							+ product.getPrice() * product.discount() * product.getQuantity() + "$");
				}
			}
			System.out.println("Общая сумма: " + price + "$");
		} else {
			System.out.println("Не выбран ни 1 товар для расчёта цены");
		}
		priceBill = price;
		return price;
	}

	public void addProduct(Product product) {
		if (products == null) {
			products = new Product[MIN_LENGTH_ARRAY];
		}
		if (products.length <= countProducts) {
			expandArray();
		}
		products[countProducts++] = product;
		System.out.println("Продукт добавлен");
	}

	private void expandArray() {
		Product[] tmpProducts = new Product[products.length * 2 + 1];
		System.arraycopy(products, 0, tmpProducts, 0, products.length);
		products = tmpProducts;
	}

	public void removeProduct(String nameOfProduct) {
		int indexOfProduct = -1;
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				if (products[i].getName().equals(nameOfProduct)) {
					indexOfProduct = i;
					break;
				}
			}
		}
		if (indexOfProduct == -1) {
			System.out.println("Продукта с таким именем нету в вашей сделки");
		} else {
			System.arraycopy(products, indexOfProduct + 1, products, indexOfProduct, countProducts - indexOfProduct - 1);
			products[--countProducts] = null;
			System.out.println("Продукт удален");
		}
	}

	public void menuDeal() {
		Scanner sc = new Scanner(System.in);
		System.out.println(MENU_DEAL);

		String value = sc.nextLine();
		while (!value.equals("0")) {
			switch (value) {
				case "1": {
					menuProducts();
					System.out.println("----------------------------");
					System.out.println(MENU_DEAL);
					break;
				}
				case "2": {
					if (products != null && products[0] != null) {
						System.out.println("Введите наименование товара, которого хотите удалить");
						String nameOfProduct = sc.nextLine();
						removeProduct(nameOfProduct);
					} else {
						System.out.println("Нет товаров для удаления из сделки");
					}
					System.out.println("----------------------------");
					System.out.println(MENU_DEAL);
					break;
				}
				case "3": {
					priceBill();
					System.out.println("----------------------------");
					System.out.println(MENU_DEAL);
					break;
				}
				case "4": {
					if (products == null) {
						System.out.println("Нет товаров для совершения сделки");
						System.out.println("----------------------------");
						System.out.println(MENU_DEAL);
					} else {
						if (buyer.getMoney() >= priceBill()) {
							return;
						} else {
							System.out.println("Недостаточно средств у покупателя");
							System.out.println("----------------------------");
							System.out.println(MENU_DEAL);
						}
					}
					break;
				}
				default: {
					System.out.println("Введите корректное значение");
				}
			}
			value = sc.nextLine();
		}
	}

	private void menuProducts() {
		Scanner sc = new Scanner(System.in);
		System.out.println(MENU_PRODUCT);
		String value = sc.nextLine();
		while (!value.equals("0")) {
			switch (value) {
				case "1": {
					System.out.println("Введите с новой строки значение следующих полей для хлеба:");
					Bread meat = new Bread();
					readProduct(meat);
					System.out.println("Введите цвет хлеба");
					meat.setColor(sc.nextLine());
					System.out.println("Введите вес куска хлеба в гр.");
					meat.setWeight(sc.nextInt());
					sc.nextLine();
					addProduct(meat);
					System.out.println("----------------------------");
					System.out.println(MENU_PRODUCT);
					break;
				}
				case "2": {
					System.out.println("Введите с новой строки значение следующих полей для вина:");
					Wine wine = new Wine();
					readProduct(wine);
					System.out.println("Введите страну производителя");
					wine.setCountry(sc.nextLine());
					System.out.println("Введите выдержку вина в годах");
					wine.setAge(sc.nextInt());
					sc.nextLine();
					addProduct(wine);
					System.out.println("----------------------------");
					System.out.println(MENU_PRODUCT);
					break;
				}
				case "3": {
					System.out.println("Введите с новой строки значение следующих полей для сыра:");
					Cheese cheese = new Cheese();
					readProduct(cheese);
					System.out.println("Введите вес порции сыра в гр.");
					cheese.setWeight(sc.nextDouble());
					sc.nextLine();
					addProduct(cheese);
					System.out.println("----------------------------");
					System.out.println(MENU_PRODUCT);
					break;
				}
				default: {
					System.out.println("Введите корректное значение");
					System.out.println("----------------------------");
					System.out.println(MENU_PRODUCT);
				}
			}
			value = sc.nextLine();
		}
	}

	private void readProduct(Product product) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите наименование продукта");
		product.setName(sc.nextLine());

		System.out.println("Введите цену продукта в руб");
		product.setPrice(sc.nextDouble());

		sc.nextLine();
		System.out.println("Введите производителя продукта");
		product.setManufacture(sc.nextLine());

		System.out.println("Введите количество в шт.");
		product.setQuantity(sc.nextInt());
	}

	public Person getSeller() {
		return seller;
	}

	public void setSeller(Person seller) {
		this.seller = seller;
	}

	public Person getBuyer() {
		return buyer;
	}

	public void setBuyer(Person buyer) {
		this.buyer = buyer;
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public LocalDate getDealDate() {
		return dealDate;
	}

	public LocalDate getDeadlineDate() {
		return deadlineDate;
	}

	public double getPriceBill() {
		return priceBill;
	}

	public void setPriceBill(double priceBill) {
		this.priceBill = priceBill;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Сделка{");
		sb.append("продавец - ").append(seller);
		sb.append(", покупатель - ").append(buyer);
		sb.append(", продукты - ").append(Arrays.toString(products));
		sb.append(", сумма сделки - ").append(priceBill).append("руб");
		sb.append(", дата сделки - ").append(dealDate);
		sb.append(", дедлайн сделки - ").append(deadlineDate);
		sb.append('}');
		return sb.toString();
	}

}

