package ch.bfh.kepler.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.kepler.service.MovieService;
import ch.bfh.kepler.service.dto.MovieDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class MovieServiceIT {

	@Inject
	private MovieService movieService;

	@Test
	public void test() {

		// Create
		MovieDTO newMovie = new MovieDTO();
		newMovie.setTitle("test");
		newMovie = movieService.create(newMovie);
		
		// Read
		MovieDTO readMovie = movieService.read(newMovie.getId());
		Assert.assertTrue(newMovie.getTitle().equals(readMovie.getTitle()));

		// Update
		readMovie.setTitle("Test2");
		readMovie = movieService.update(readMovie);
		MovieDTO updatedMovie = movieService.read(readMovie.getId());
		Assert.assertTrue(readMovie.getTitle().equals(updatedMovie.getTitle()));


		// Delete
		movieService.delete(updatedMovie);
		MovieDTO deletedMovie = movieService.read(readMovie.getId());
		Assert.assertNull(deletedMovie);

	}

}