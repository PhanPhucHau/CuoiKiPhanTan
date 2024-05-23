package entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "class_profiles")
public class ClassProfile implements Serializable{
			
	@Id
	@Column(name = "profile_id")
	private String id;
	
	private String decription;
	private LocalDate createDate;
	
	@Id
	@OneToOne
	@JoinColumn(name = "class_id")
	private Class classes;
	
	
	public ClassProfile() {
	}


	public ClassProfile(String id, String decription, LocalDate createDate) {
		this.id = id;
		this.decription = decription;
		this.createDate = createDate;
	}

	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getDecription() {
		return decription;
	}


	public void setDecription(String decription) {
		this.decription = decription;
	}


	public LocalDate getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "ClassProfile [id=" + id + ", decription=" + decription + ", createDate=" + createDate + "]";
	}
	
	
	
	
	

}
