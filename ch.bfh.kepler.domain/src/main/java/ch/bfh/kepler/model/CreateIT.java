package ch.bfh.kepler.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * @author rovi
 * 
 */
public class CreateIT {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Genre genre = new Genre();
		genre.setGenre("Thriller");
		
		Regisseur regisseur = new Regisseur();
		regisseur.setFirstname("Steven");
		regisseur.setLastname("Spielberg");
		regisseur.setDateOfBirth(new Date(1979, 12,1));
		regisseur.setNationality("Swiss");
		regisseur.setPortaitPath("");

		Actor actor = new Actor();
		actor.setFirstname("Paul");
		actor.setLastname("Panzer");
		actor.setDateOfBirth(new Date(1979, 12,1));
		actor.setNationality("Swiss");
		actor.setPortaitPath("");
		
		Movie movie = new Movie();
		movie.setTitle("Superfilm");
		movie.setDuration(109.5);
		movie.setRegisseur(regisseur);
		movie.setGenre(genre);
		movie.setDescription("Superdescription");
	
		
		ArrayList<Actor> actors = new ArrayList<Actor>();
		actors.add(actor);
		
		movie.setActors(actors);

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.kepler.domain").createEntityManager();

		em.getTransaction().begin();
		em.persist(movie);
		em.getTransaction().commit();
	}
}