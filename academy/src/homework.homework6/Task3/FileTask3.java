package by.academy.homework.homework6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileTask3 {
    public static void main(String[] args) throws IOException {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Ivan", "Ivanov", 15));
        users.add(new User("Anton", "Fntonov", 16));
        users.add(new User("Maksim", "Maksimov", 17));
        users.add(new User("Pavel", "Pavlov", 18));
        users.add(new User("Dmitry", "Dmitryevich", 19));
        users.add(new User("Ilya", "Ilyin", 20));
        users.add(new User("Oksana", "Oksanovna", 21));
        users.add(new User("Tatiana", "Tatianina", 22));
        users.add(new User("Alla", "Olegovna", 23));
        users.add(new User("Nikita", "Nikitovich", 24));

        File dir = new File("users");
        if (!dir.exists()) {
            dir.mkdir();
        }

        for (User user : users) {
            String fileName = user.getFirstName() + "_" + user.getLastName() + "_" + user.getAge() + ".txt";
            File personalFile = new File(dir, fileName);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(personalFile))) {
                oos.writeObject(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

