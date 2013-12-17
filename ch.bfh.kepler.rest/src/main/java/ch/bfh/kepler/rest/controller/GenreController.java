package ch.bfh.kepler.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.kepler.model.Genre;
import ch.bfh.kepler.service.GenreService;
import ch.bfh.kepler.service.dto.GenreDTO;

@Controller
@RequestMapping("/genres")
public class GenreController {
	@Inject
	private GenreService genreService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public GenreDTO createGenre(@RequestBody GenreDTO genre) {
		GenreDTO createdMovie = genreService.create(genre);
		System.out.println("Genre created with id = " + createdMovie.getId());
		return createdMovie;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<GenreDTO> getGenre() {
		System.out.println("Collection of Genre requested");
		return genreService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public GenreDTO getGenre(@PathVariable long id) {
		System.out.println("Genre requested with id = " + id);
		return genreService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public GenreDTO updateGenre(@RequestBody GenreDTO genre, @PathVariable long id) {
		GenreDTO updateGenre = genreService.update(genre);
		System.out.println("Genre updated with id = " + updateGenre.getId());
		return updateGenre;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteGenre(@PathVariable long id) {
		GenreDTO genre = genreService.read(id);
		genreService.delete(genre);
		System.out.println("Delete Genre with id = " + id);
	}
}
