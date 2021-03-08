package by.academy.homework.homework4.task1;

public class DateMain {

	public static void main(String[] args) {

		Date date = new Date();
		System.out.println("Введите первую дату");
		date.date1 = date.dateIsDate(date.date1);
		System.out.println("Введите вторую дату");
		date.date2 = date.dateIsDate(date.date2);
		date.visokosniy(date.date1.getYear());
		date.getDaysBetweenTwoDates(date.date1, date.date2);
		date.dayOfWeek(date.date1);
		date.dayOfWeek(date.date2);
	}

}
