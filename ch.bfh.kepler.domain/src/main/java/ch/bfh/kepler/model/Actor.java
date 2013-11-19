package ch.bfh.kepler.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.TemporalType.DATE;


import org.eclipse.persistence.annotations.JoinFetch;

import static org.eclipse.persistence.annotations.JoinFetchType.OUTER;
import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Actor
 *
 */
@Entity

public class Actor implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Firstname;
	private String Lastname;
	@Temporal(DATE)
	private Date DateOfBirth;
	private String Nationality;
	private String PortaitPath;
	private static final long serialVersionUID = 1L;
	
	@ManyToMany(cascade = ALL)
	@JoinFetch(OUTER)
	private List<Movie> movies;
	
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Actor() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getFirstname() {
		return this.Firstname;
	}

	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}   
	public String getLastname() {
		return this.Lastname;
	}

	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}   
	public Date getDateOfBirth() {
		return this.DateOfBirth;
	}

	public void setDateOfBirth(Date DateOfBirth) {
		this.DateOfBirth = DateOfBirth;
	}   
	public String getNationality() {
		return this.Nationality;
	}

	public void setNationality(String Nationality) {
		this.Nationality = Nationality;
	}   
	public String getPortaitPath() {
		return this.PortaitPath;
	}

	public void setPortaitPath(String PortaitPath) {
		this.PortaitPath = PortaitPath;
	}
   
}
