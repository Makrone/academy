package by.academy.homework.homework4.task1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Date {

	public LocalDate date1;
	public LocalDate date2;

	public Date() {
		super();
	}

	protected static class Year {
		int year;

		protected Year(int year) {
			this.year = year;
		}

		protected int getYear() {
			return year;
		}

	}

	public static class Month {
		int month;

		public Month(int month) {
			this.month = month;
		}

		int getMonth() {
			return month;
		}

	}

	private static class Day {
		int day;

		private Day(int day) {
			this.day = day;
		}

		int getDay() {
			return day;
		}

	}

	public LocalDate getDate1() {
		return date1;
	}

	public LocalDate getDate2() {
		return date2;
	}

	public LocalDate dateIsDate(LocalDate date) {
		InputDate input = new InputDate();
		String strDate = input.input();
		Date.Year year = new Date.Year(Integer.parseInt(strDate.substring(6, 10)));
		Date.Month month = new Date.Month(Integer.parseInt(strDate.substring(3, 5)));
		Date.Day day = new Date.Day(Integer.parseInt(strDate.substring(0, 2)));

		date = LocalDate.of(year.getYear(), month.getMonth(), day.getDay());
		return date;
	}

	protected void visokosniy(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			System.out.println(year + " visokosniy");
		} else {
			System.out.println(year + " NE visokosniy");
		}
	}

	protected void getDaysBetweenTwoDates(LocalDate date1, LocalDate date2) {

		System.out.println("Между первой и второй датой " + Math.abs(ChronoUnit.DAYS.between(date1, date2)) + " дней");
	}

	public void dayOfWeek(LocalDate date) {
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		System.out.println(date + " - " + dayOfWeek);
	}

}
