package by.academy.homework.homework7;

import java.time.LocalDate;

public class User extends Person {
    private String login;
    private String password;
    private String email;

    public User() {
        super();
    }

    public User(String firstName, String lastName, int age, LocalDate dateOfBirth, String login, String password, String email) {
        super(firstName, lastName, age, dateOfBirth);
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String printUserInfo() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("firstName='").append(getFirstName()).append('\'');
        sb.append(", lastName='").append(getLastName()).append('\'');
        sb.append(", age=").append(getAge());
        sb.append(", dateOfBirth=").append(getDateOfBirth());
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}