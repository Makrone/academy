package by.academy.deal;

import by.academy.deal.validator.AmericanPhoneNumber;
import by.academy.deal.validator.BelarusPhoneNumber;
import by.academy.deal.validator.DateFormat;
import by.academy.deal.validator.Email;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends Person {
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private final static Pattern pattern = Pattern.compile("-");
    private final static DateFormat date = new DateFormat();
    private final static AmericanPhoneNumber americanPhoneNumber = new AmericanPhoneNumber();
    private final static BelarusPhoneNumber belarusPhoneNumber = new BelarusPhoneNumber();
    private final static Email emailVal = new Email();

    public User() {
        super();
    }
    public User(String name, Double money, Date dateOfBirth, String phone, String email) {
        super(name, money);
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phone;
        this.email = email;
    }

    public void readNewUser() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ваше ФИО");
        setName(sc.nextLine());

        System.out.println("Введите количество денег в руб.");
        setMoney(sc.nextDouble());

        sc.nextLine();
        System.out.println("Введите дату рождения в формате dd-MM-yyyy");
        String dateOfBirth = sc.nextLine();
        while (!date.validate(dateOfBirth)) {
            System.out.println("Введите дату рождения в одном из указанных форматов");
            dateOfBirth = sc.nextLine();
        }
        setDateOfBirth(dateOfBirth);

        System.out.println("Введите ваш номер телефона в формате +37533, или +37544, +37529, или +37525 и ваш семизначный номер");
        phoneNumber = sc.nextLine();
        while (!belarusPhoneNumber.validate(phoneNumber) && !belarusPhoneNumber.validate(phoneNumber)) {
            System.out.println("Введите номер телефона в указанном формате");
            phoneNumber = sc.nextLine();
        }
        System.out.println("Введите вашу электронную почту");
        email = sc.nextLine();
        while (!emailVal.validate(email)) {
            System.out.println("Введите электронную почту в указанном формате");
            email = sc.nextLine();
        }
    }

    public void setDateOfBirth(String strDate) throws ParseException {
        Matcher matcher = pattern.matcher(strDate.trim());
        if (matcher.find()) {
            dateOfBirth = new SimpleDateFormat("dd-MM-yyyy").parse(strDate);
        } else {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
        }
    }

    public String getDateOfBirth() {
        return "день: " + dateOfBirth.getDate() + ", месяц: " + (dateOfBirth.getMonth() + 1) + ", год: " + (dateOfBirth.getYear() + 1900);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Пользователь{");
        sb.append("Имя - ").append(getName());
        sb.append(", деньги на момент сделки - ").append(getMoney()).append("$");
        sb.append(", дата рождения - ").append(getDateOfBirth());
        sb.append(", номер мобильного телефона - ").append(phoneNumber);
        sb.append(", электронная почта - ").append(email);
        sb.append('}');
        return sb.toString();
    }
}
