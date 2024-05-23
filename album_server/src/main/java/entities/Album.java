package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="albums")
public class Album implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1477439744206823263L;
	@Id
	@Column(name = "album_id")
	private String id;
	private String title;
	private double price;
	@Column(name = "year_of_release")
	private int yearOfRelease;
	@Column(name="ownload_link")
	private String downloadLink;
	
	@ManyToOne
	@JoinColumn (name ="genre_id")
	private Genre genre;
	
	@ManyToMany
	@JoinTable(
			name = "albums_artists",
			joinColumns =  @JoinColumn(name = "album_id"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "artist_id")
			
			)
	private Set<Artists> artists = new HashSet<Artists>();
	@ManyToMany
	@JoinTable(
			name = "albums_song",
			joinColumns =  @JoinColumn(name = "album_id"),
			inverseJoinColumns = @JoinColumn(referencedColumnName = "song_id")
			
			)
	private Set<Song> songs = new HashSet<Song>();

}
