package ch.bfh.kepler.model;

import ch.bfh.kepler.model.Genre;
import ch.bfh.kepler.model.Regisseur;

import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Movie
 *
 */
@Entity

public class Movie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Title;
	private Double Duration;
	private String Description;
	@ManyToOne(cascade = ALL)
	private Regisseur Regisseur;
	@ManyToOne(cascade = ALL)
	private Genre Genre;
	private String CoverPath;
	@ManyToMany(mappedBy="movies", cascade = ALL)
	private List<Actor> actors;
	
	public List<Actor> getActors() {
		return actors;
	}
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	private static final long serialVersionUID = 1L;

	public Movie() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}   
	public Double getDuration() {
		return this.Duration;
	}

	public void setDuration(Double Duration) {
		this.Duration = Duration;
	}   
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}   
	public Regisseur getRegisseur() {
		return this.Regisseur;
	}

	public void setRegisseur(Regisseur Regisseur) {
		this.Regisseur = Regisseur;
	}   
	public Genre getGenre() {
		return this.Genre;
	}

	public void setGenre(Genre Genre) {
		this.Genre = Genre;
	}   
	public String getCoverPath() {
		return this.CoverPath;
	}

	public void setCoverPath(String CoverPath) {
		this.CoverPath = CoverPath;
	}
   
}
