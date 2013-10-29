package ch.bfh.kepler.model;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import javax.persistence.*;

public class ReadIT {

	@Test
	public void test() {
		
		EntityManager em = Persistence.createEntityManagerFactory(
			"ch.bfh.kepler.domain").createEntityManager();

	Query q = em.createQuery("select a from Movie a");
	@SuppressWarnings("unchecked")
	List<Movie> movies = q.getResultList();
	Movie firstMovie = movies.get(0);
	Assert.assertTrue(firstMovie.getTitle().equals("Superfilm"));

	//List<Regisseur> foundRegisseur = movies.getRegisseurs();
	Regisseur regisseur = firstMovie.getRegisseur();
	Assert.assertTrue(regisseur.getLastname().startsWith("Spielberg"));
	
	List<Actor> actor = firstMovie.getActors();
	Actor firstActor = actor.get(0);
	Assert.assertTrue(firstActor.getLastname().startsWith("Panzer"));
	
	}

}
