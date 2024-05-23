package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "classes")
public class Class implements Serializable{
	
	@Id
	@Column(name = "class_id")
	private String id;
	
	private String name;
	
	@Column(name = "no_of_student")
	private int noOfStudents;
	
	@OneToMany(mappedBy = "classes")
	private Set<Student> students;
	
	@OneToMany(mappedBy = "classes")
	private Set<Enrollment> enrollments;

	public Class() {
	}

	public Class(String id, String name, int noOfStudents) {

		this.id = id;
		this.name = name;
		this.noOfStudents = noOfStudents;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", noOfStudents=" + noOfStudents + "]";
	}
	
	
	
	
	
	

}
