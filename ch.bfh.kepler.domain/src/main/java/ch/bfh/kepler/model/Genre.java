package ch.bfh.kepler.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Genre
 *
 */
@Entity

public class Genre implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Genre;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "Genre", cascade = ALL)
	private List<Movie> movies;

	public Genre() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getGenre() {
		return this.Genre;
	}

	public void setGenre(String Genre) {
		this.Genre = Genre;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
   
}
