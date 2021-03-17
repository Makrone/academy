package by.academy.homework.homework6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//Прочесть информацию введеную из клавиатури и записать в созданный вами txt файл,
//если введена "stop" строка тогда закончить запись в файл.

public class Task1 {

	public static void main(String[] args) {

		try (BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bufwriter = new BufferedWriter(new FileWriter("task1.txt"))) {
			
			String text;
			String stopString = "stop";
			while (!(text = bufread.readLine()).equals(stopString)) {

				bufwriter.write(text + "\n");
				bufwriter.flush();
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}
}