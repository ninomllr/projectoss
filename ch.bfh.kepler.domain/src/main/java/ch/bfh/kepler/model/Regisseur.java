package ch.bfh.kepler.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Regisseur
 *
 */
@Entity

public class Regisseur implements Serializable {

	   
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Firstname;
	private String Lastname;
	@Basic(fetch = LAZY)
	@Temporal(DATE)
	private Date DateOfBirth;
	private String Nationality;
	private String PortaitPath;
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "Regisseur", cascade = ALL)
	private List<Movie> movies;

	public Regisseur() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
   
}
