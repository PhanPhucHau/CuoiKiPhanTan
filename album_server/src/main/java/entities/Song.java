package entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name ="songs")
public class Song implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -8435848840283522464L;
	@Id
	@Column(name="song_id")
	private String id;
	private String name;
	private String runtime;
	private String lyric;
	@Column(name = "file_link")
	private String fileLink;

}
