package domain;

import java.util.List;
import java.util.Objects;

public class StudentInGroupe {

    private Group group;

    private List<Student> students;

	public StudentInGroupe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentInGroupe(Group group, List<Student> students) {
		super();
		this.group = group;
		this.students = students;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(group, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentInGroupe other = (StudentInGroupe) obj;
		return Objects.equals(group, other.group) && Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "StudentInGroupe [group=" + group + ", students=" + students + "]";
	}

}
