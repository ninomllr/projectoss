package ch.bfh.kepler.service.dto;


import java.io.Serializable;
import java.lang.Double;
import java.lang.String;
import java.util.List;


/**
 * Entity implementation class for Entity: Movie
 *
 */

public class MovieDTO implements Serializable {

	private Long id;
	private String Title;
	private Double Duration;
	private String Description;
	private RegisseurDTO Regisseur;
	private GenreDTO Genre;
	private String CoverPath;
	private List<ActorDTO> actors;
	
	public List<ActorDTO> getActors() {
		return actors;
	}
	public void setActors(List<ActorDTO> actors) {
		this.actors = actors;
	}
	private static final long serialVersionUID = 1L;

	public MovieDTO() {
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
	public RegisseurDTO getRegisseur() {
		return this.Regisseur;
	}

	public void setRegisseur(RegisseurDTO Regisseur) {
		this.Regisseur = Regisseur;
	}   
	public GenreDTO getGenre() {
		return this.Genre;
	}

	public void setGenre(GenreDTO Genre) {
		this.Genre = Genre;
	}   
	public String getCoverPath() {
		return this.CoverPath;
	}

	public void setCoverPath(String CoverPath) {
		this.CoverPath = CoverPath;
	}
   
}
