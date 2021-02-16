package by.academy.deal.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AmericanPhoneNumber implements Validator{
    public static final String regexp = "\\+1\\d{10}";
    private static final Pattern pattern = Pattern.compile(regexp);

    @Override
    public boolean validate (String strPhoneNumber){
        Matcher matcher = pattern.matcher(strPhoneNumber.trim());
        return matcher.matches();
    }
}
