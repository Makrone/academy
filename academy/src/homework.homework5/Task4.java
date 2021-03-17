package by.academy.homework.homework6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

//Создайте каталог(папку). Создайте в папке 100 txt файлов (Например, 1.txt, 2.txt ... 100.txt).
//Считываем текст из 2-ого задания, получаем его длинну (576 символов).
//Для каждого файла генерируем рандомное число от 0 до 576, достаем из текста (из 2 задания)
//такое-же количество символов (string.substring()) и сохраняем в наш файл.
//Создайте файл result.txt и запишите туда список всех файлов и их размеры.

public class Task4 {

	public static void main(String[] args) {

		try (BufferedReader bufread = new BufferedReader(new FileReader("task2.txt"));
				BufferedWriter writeResult = new BufferedWriter(new FileWriter("rezultTask4.txt"))) {
			String textstart;
			textstart = bufread.readLine();

			File catalog = new File("src/100txt");
			if (!catalog.exists()) {
				catalog.mkdir();
			}
			
			for (int i = 1; i <= 100; i++) {
				File file = new File(catalog, i + ".txt");

				try (BufferedWriter bufwriter = new BufferedWriter(new FileWriter(file))) {
					Random random = new Random();
					String text;
					text = textstart.substring(random.nextInt(textstart.length() + 1));
					bufwriter.write(text);

				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
				writeResult.write(file.getName() + "-" + file.length() + "\n");
				writeResult.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
