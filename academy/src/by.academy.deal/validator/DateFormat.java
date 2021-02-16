package by.academy.deal.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormat implements Validator {
    public static final String regexp = "(0?[1-9]|[12][0-9]|3[01])[/-](0?[1-9]|1[0-2])[/-]" +
            "(19[0-9]{2}|20[01][0-9]|202[01])";
    private static final Pattern pattern = Pattern.compile(regexp);

    @Override
    public boolean validate(String strDate) {
        Matcher matcher = pattern.matcher(strDate.trim());
        return matcher.matches();
    }

}
