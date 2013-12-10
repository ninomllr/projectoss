package ch.bfh.kepler.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.kepler.service.GenreService;
import ch.bfh.kepler.service.dto.GenreDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class GenreServiceIT {

	@Inject
	private GenreService genreService;

	@Test
	public void test() {

		// Create
		GenreDTO newGenre = new GenreDTO();
		newGenre.setGenre("test");
		newGenre = genreService.create(newGenre);
		
		// Read
		GenreDTO readGenre = genreService.read(newGenre.getId());
		Assert.assertTrue(newGenre.getGenre().equals(readGenre.getGenre()));

		// Update
		readGenre.setGenre("Test2");
		readGenre = genreService.update(readGenre);
		GenreDTO updatedGenre = genreService.read(readGenre.getId());
		Assert.assertTrue(readGenre.getGenre().equals(updatedGenre.getGenre()));


		// Delete
		genreService.delete(updatedGenre);
		GenreDTO deletedGenre = genreService.read(readGenre.getId());
		Assert.assertNull(deletedGenre);

	}

}