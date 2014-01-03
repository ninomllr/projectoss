package ch.bfh.kepler.service.dto;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;


/**
 * Entity implementation class for Entity: Genre
 *
 */

public class GenreDTO implements Serializable {

	   
	private Long idGenre;
	private String Genre;
	private static final long serialVersionUID = 1L;
	
	private List<MovieDTO> movies;

	public GenreDTO() {
		super();
	}   
	public Long getId() {
		return this.idGenre;
	}

	public void setId(Long id) {
		this.idGenre = id;
	}   
	public String getGenre() {
		return this.Genre;
	}

	public void setGenre(String Genre) {
		this.Genre = Genre;
	}
	
//	public List<MovieDTO> getMovies() {
//		return movies;
//	}
//	
//	public void setMovies(List<MovieDTO> movies) {
//		this.movies = movies;
//	}
   
}
