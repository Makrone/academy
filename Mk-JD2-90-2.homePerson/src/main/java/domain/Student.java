package domain;

import java.util.Objects;

public class Student {
	private long id;
	private String name;
	private int age;
	private double score;
	private boolean olympicGamer;

	public Student() {
		super();

	}

	public Student(long id, String name, int age, double score, boolean olympicGamer) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.olympicGamer = olympicGamer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public boolean getOlympicGamer() {
		return olympicGamer;
	}

	public void setOlympicGamer(boolean olympicGamer) {
		this.olympicGamer = olympicGamer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, name, olympicGamer, score);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name)
				&& olympicGamer == other.olympicGamer
				&& Double.doubleToLongBits(score) == Double.doubleToLongBits(other.score);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + ", olympicGamer="
				+ olympicGamer + "]";
	}

}
