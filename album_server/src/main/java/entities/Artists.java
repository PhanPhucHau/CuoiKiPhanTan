package entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name ="artists")
public class Artists implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8199582184969310693L;
	@Id
	@Column(name ="artist_id")
	private String id;
	private String name;
	@Column(name ="birth_date")
	private LocalDate birthDate;
	private String url;
	

}
