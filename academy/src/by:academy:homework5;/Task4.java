package by.academy.homework5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Task4 {
    public static void main(String[] args){
        Random random = new Random();
        ArrayList<Integer> marksList = new ArrayList<>();
        int number = 15;

        for (int i = 1; i < number; i++){
            marksList.add(random.nextInt(10) + 1);
        }

        int maxMark = marksList.get(0);

        for (int i = 0; i < marksList.size(); i++){
            if (maxMark < marksList.get(i)){
                maxMark = marksList.get(i);
            }
        }

        Iterator<Integer> iterator = marksList.iterator();
        System.out.println(marksList.toString());

        while (iterator.hasNext()){
            if (maxMark == iterator.next()){
                System.out.print(maxMark + " ");
            }
        }
    }
}
