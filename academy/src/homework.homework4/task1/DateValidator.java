package by.academy.homework.homework4.task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidator {
	private Pattern p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-(\\d\\d\\d\\d)");

	public boolean isValid(String s) {
		Matcher m = p.matcher(s);
		return m.matches();
	}

}
