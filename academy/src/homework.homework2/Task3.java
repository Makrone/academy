package by.academy.homework.lesson2;

import java.util.Scanner;

public class Task3 {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Введите 2 слова, состоящие из четного числа букв");
			String str1 = scan.nextLine();
			String str2 = scan.nextLine();
			String str3;
			if (str1.length() % 2 != 0 || str2.length() % 2 != 0) {
				System.out.println("Вы ввели слова с нечетным количеством букв");
			} else {
				str3 = str1.substring(0, str1.length() / 2) + str2.substring(str2.length() / 2, str2.length());
				System.out.println(str3);
			}
		}
	}

