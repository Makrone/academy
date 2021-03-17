package by.academy.homework.lesson1;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите сумму: ");
		int cost = sc.nextInt();
		if (cost < 0) {
			System.out.println("Ошибка! Введите число");
			return;
		}
		System.out.print("Введите возраст : ");
		int age = sc.nextInt();
		if (age < 0) {
			System.out.println("Ошибка! Введите возраст");
			return;
		}

		if (cost < 100) {
			System.out.println("Сумма скидки 5% : " 
								+ ((1 - 0.05) * cost));
		} else if (cost >= 100 & cost < 200) {
			System.out.println("Сумма скидки 7% : " 
								+ ((1 - 0.07) * cost));
		} else if (cost >= 200 & cost < 300) {
			if (age > 18) {
				System.out.println("Сумма скидки 16% : " 
								+ ((1 - 0.16) * cost));
			} else {
				System.out.println("Сумма скидки 9% : " 
								+ ((1 - 0.09) * cost));
			}
		} else if (cost >= 300 & cost < 400){
			System.out.println("Сумма скидки 15% : " 
								+ ((1 - 0.15) * cost));
		} else {
			System.out.println("Сумма скидки 20% : " 
								+ ((1 - 0.2) * cost));
		}
	}
}
