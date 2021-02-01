package by.academy.homework.lesson2;

import java.util.Scanner;

public class Task1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Введите 2 строки");
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		StringBuilder str1_ = new StringBuilder(str1);
		StringBuilder str2_ = new StringBuilder(str2);
		boolean t = false;
		if (str1.length() != str2.length()) {
		} else {
			for (int i = 0; i < str1.length(); i++) {
				for (int j = 0; j < str1_.length(); j++) {
					if (str1_.charAt(0) == str2_.charAt(j)) {
						str1_ = str1_.deleteCharAt(0);
						str2_ = str2_.deleteCharAt(j);
					}
				}
			}
			if (str1_.length() == 0) {
				t = true;
			} 
		}
		System.out.println(t);
		if (t) {
			System.out.println("Строки являются анаграммами");
		}else {
			System.out.println("Строки не являются анаграммами");
		}
		scan.close();
	}

}

