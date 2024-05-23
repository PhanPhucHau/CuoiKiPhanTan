package entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "part_time_student")
public class PartTimeStudent extends Student implements Serializable{
	
	private String superisor;

	public PartTimeStudent() {
	}

	public PartTimeStudent(String id, String name, String email, LocalDate dob, String superisor) {
		super();
		this.superisor = superisor;
	}

	public String getSuperisor() {
		return superisor;
	}

	public void setSuperisor(String superisor) {
		this.superisor = superisor;
	}

	@Override
	public String toString() {
		return "PartTimeStudent [superisor=" + superisor + "]";
	}
	
	
	
	
	
	

}
