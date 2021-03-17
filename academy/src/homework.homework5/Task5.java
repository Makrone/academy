package by.academy.homework5;

import java.util.HashMap;

public class Task5 {

    public static final String str = "Добрый вечер";

    public static void main(String[] args) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else
                map.put(str.charAt(i), 1);
        }

        for (var temp : map.entrySet()) {
            Character key = temp.getKey();
            Integer value = temp.getValue();
            System.out.println("'" + key + "' = " + value);
        }
    }
}
