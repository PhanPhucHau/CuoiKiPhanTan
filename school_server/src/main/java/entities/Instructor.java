package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.UniqueConstraint;

@Entity
@DiscriminatorValue("Instructor")

@DiscriminatorColumn(name = "disc", discriminatorType = DiscriminatorType.STRING)


public class Instructor extends Person implements Serializable {
	private static final long serialVersionUID = 8065808962349626612L;
	private LocalDateTime hireDate;
	
	
	

	
	
	
	@ElementCollection
	@CollectionTable(
		name = "phones",
		joinColumns = @JoinColumn(name = "customer_id"), 
		uniqueConstraints  = @UniqueConstraint(columnNames = {"customer_id", "phone_number"})
	)	
	@Column(name = "phone_number")
	private Set<String> phones;
	
	

	public Instructor() {
	}
	
	public Instructor(String firstName, String lastName, LocalDateTime hireDate) {
		super(firstName, lastName);
		this.hireDate = hireDate;
	}

	public LocalDateTime getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDateTime hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return String.format("Instructor [hireDate=%s, toString()=%s]", hireDate, super.toString());

	}

}