package by.academy.homework5;

public class Task6 {
    public static void main(String[] args) {
        int[] arr = new int[8];
        try {
            for (int i = 0; i <= 10; i++) {
                arr[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException  e) {
            System.out.println("Array index out of bounds");
        }
    }
}