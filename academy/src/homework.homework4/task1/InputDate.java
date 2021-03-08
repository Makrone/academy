package by.academy.homework.homework4.task1;

import java.util.Scanner;

public class InputDate {
	private String strDate;
	private final Scanner scan = new Scanner(System.in);
	private final DateValidator vDate = new DateValidator();

	public String input() {
		do {
			strDate = scan.nextLine();
			if (!vDate.isValid(strDate)) {
				System.out.println("NO NO NO");
				System.out.println("Input date in format dd-mm-yyyy ");
			} else {
				System.out.println("OK");
			}
		} while (!vDate.isValid(strDate));
		scan.close();
		return strDate;
		
	}
}
