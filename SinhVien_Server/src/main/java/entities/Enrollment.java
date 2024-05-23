package entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment implements Serializable{
	
	@Id
	private String semester;
	
	@Id
	private int year;
	
	private int score;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student students;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	private Class classes;

	public Enrollment() {
		super();
	}

	public Enrollment(String semester, int year, int score, Student students, Class classes) {
		super();
		this.semester = semester;
		this.year = year;
		this.score = score;
		this.students = students;
		this.classes = classes;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student getStudents() {
		return students;
	}

	public void setStudents(Student students) {
		this.students = students;
	}

	public Class getClasses() {
		return classes;
	}

	public void setClasses(Class classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Enrollment [semester=" + semester + ", year=" + year + ", score=" + score + ", students=" + students
				+ ", classes=" + classes + "]";
	}
	
	
	
	
	
	

}
