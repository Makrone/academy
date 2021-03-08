package by.academy.homework.homework4.task2;

import java.util.Arrays;

public class TArrClassDemo {

	public static void main(String[] args) {

		

		String s = "bbb";
		TArrClass<String> equ = new TArrClass<>();
		equ.add("aaa");
		equ.add("bbb");
		equ.add("ccc");
		equ.add("bbb");
		equ.add("bbb");
		equ.add("ccc");
		equ.add("bbb");
		System.out.println(Arrays.toString(equ.getArr()));
		System.out.println(equ.getLastObjectIndex());
		System.out.println(equ.getLastObject());

		equ.remove(s);
		System.out.println(Arrays.toString(equ.getArr()));
		System.out.println(equ.getLastObjectIndex());
		System.out.println(equ.getLastObject());
	}
}

