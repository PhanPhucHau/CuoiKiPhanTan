package entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "full_time_student")
public class FullTimeStudent extends Student implements Serializable{

	private String faculty;
	private String department;
	
	public FullTimeStudent() {
	}

	public FullTimeStudent(String id, String name, String email, LocalDate dob,String faculty, String department) {
		this.faculty = faculty;
		this.department = department;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "FullTimeStudent [faculty=" + faculty + ", department=" + department + "]";
	}
	
	
	
	
	
	
}
