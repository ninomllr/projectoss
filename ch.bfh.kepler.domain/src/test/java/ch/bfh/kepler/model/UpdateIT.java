package ch.bfh.kepler.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;




import org.junit.Assert;
import org.junit.Test;

public class UpdateIT {

	@Test
	public void test() {
		
		EntityManager em = Persistence.createEntityManagerFactory("ch.bfh.kepler.domain").createEntityManager();

		Query q = em.createQuery("select a from Movie a");
		@SuppressWarnings("unchecked")
		List<Movie> foundMovies = q.getResultList();
		Movie firstMovie = foundMovies.get(0);

		// Write access needs a transaction
		em.getTransaction().begin();
		firstMovie.setTitle("BadBoys");
		em.getTransaction().commit();

		Assert.assertTrue(firstMovie.getTitle().equals("BadBoys"));
		
	}

}
