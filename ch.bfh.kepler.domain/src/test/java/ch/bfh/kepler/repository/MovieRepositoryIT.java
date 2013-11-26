package ch.bfh.kepler.repository;

import javax.inject.*;

import org.junit.Test;
import org.junit.runner.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.*;

import ch.bfh.kepler.model.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/persistenceContext.xml")
public class MovieRepositoryIT {

	@Inject
	private MovieRepository movieRepository;

	@Test
	public void test() {

		// Create
		Movie newBook = new Movie();
		newBook.setTitle("Test");
		movieRepository.save(newBook);
		// Read
		Movie readBook = movieRepository.findOne(newBook.getId());
		org.junit.Assert.assertTrue(newBook.getTitle().equals(
				readBook.getTitle()));
		// Update
		readBook.setTitle("Test2");
		readBook = movieRepository.save(readBook);
		Movie updatedBook = movieRepository.findOne(readBook.getId());
		org.junit.Assert.assertTrue(readBook.getTitle().equals(
				updatedBook.getTitle()));
		// Delete
		movieRepository.delete(updatedBook);
		Movie deletedBook = movieRepository.findOne(readBook.getId());
		org.junit.Assert.assertNull(deletedBook);
	}
}
