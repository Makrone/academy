package by.academy.homework.lesson1;
	import java.util.Scanner;
	 
	public class Test3{
	    public static void main(String[] args){
	        Scanner scn = new Scanner(System.in);
	        int integer = 0;
	        System.out.println("Введите Число:");
	        integer = scn.nextInt();
	        while(integer > 10 || integer < 1){	            
	            integer = scn.nextInt();
	            if(integer < 10 && integer > 1){
	                break;
	            }
	        }
	        System.out.print("\n");
	        for(int i = 1; i < 10; i++){
	            System.out.println(integer + " * " + i + " = " + integer * i);
	        }
	    }
	}