package by.academy.homework.homework7;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Task1 {
	public static void main(String[] args) {

		List<Long> listLong = new Random().longs(100, 1, 100).map(x -> (long) (x * Math.PI - 20)).filter(x -> x < 100)
				.sorted().skip(3).distinct().boxed().collect(Collectors.toList());

		Map<Long, String> mapLongString = listLong.stream()
				.collect(Collectors.toMap(x -> x, value -> "Number: " + value));

		System.out.println(mapLongString);
	}
}