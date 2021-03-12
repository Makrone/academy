package by.academy.homework5;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args){
        ArrayList<Double> arrayList = new ArrayList<>();
        LinkedList<Double> linkedList = new LinkedList<>();
        int newElement = 1_000_000;
        int randomElement = 1_00_000;
        for (int i = 0; i < newElement; i++){
            arrayList.add(Math.random());
            linkedList.add(Math.random());
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < randomElement; i++){
            arrayList.get((int) (Math.random() * (newElement-1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < randomElement; i++){
            linkedList.get((int) (Math.random() * (newElement-1)));
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
