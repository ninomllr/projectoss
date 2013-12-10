package ch.bfh.kepler.service.dto;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import ch.bfh.kepler.model.Movie;

/**
 * Entity implementation class for Entity: Actor
 *
 */

public class ActorDTO implements Serializable {

	private Long id;
	private String Firstname;
	private String Lastname;
	private Date DateOfBirth;
	private String Nationality;
	private String PortaitPath;
	private static final long serialVersionUID = 1L;
	
	private List<MovieDTO> movies;
	
	public List<MovieDTO> getMovies() {
		return movies;
	}

	public ActorDTO() {
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
   
}
