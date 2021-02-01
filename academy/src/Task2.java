package by.academy.homework.lesson2;

import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Ввести количество слов: ");
		int n = scan.nextInt();

		String[] words = new String[n];
		System.out.println("Ввести слова: ");
		scan.nextLine();
		for (int i = 0; i < n; i++) {
			words[i] = scan.nextLine();
		}
		scan.close();
		
		int[] counter = new int[words.length];

		for (int i = 0; i < words.length; i++) {
			counter[i] = words[i].length();
			for (int j = 0; j < words[i].length(); j++) {
				if (j != words[i].indexOf(words[i].charAt(j))) {
					counter[i]--;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] < counter[result]) {
				result = i;
			}
		}
		System.out.println(words[result]);
	}
}