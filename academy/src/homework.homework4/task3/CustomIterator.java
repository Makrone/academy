package by.academy.homework.homework4.task3;

import by.academy.homework.homework4.IteratorMultiArr;

public class CustomIterator {

	public static void main(String[] args) {

		Integer array[][] = {{1, 2, 3}, {4, 5, 6}};
		IteratorMultiArr <Integer> arrIterator = new IteratorMultiArr<Integer>(array);
		
		while(arrIterator.hasNext()) {
			System.out.println(arrIterator.next());
		}
	}
}
