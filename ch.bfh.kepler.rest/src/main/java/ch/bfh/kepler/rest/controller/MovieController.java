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

//import ch.bfh.swos.bookapp.service.BookService;
//import ch.bfh.swos.bookapp.service.dto.BookDTO;


import ch.bfh.kepler.service.*;
import ch.bfh.kepler.service.dto.MovieDTO;

@Controller
@RequestMapping("/movies")
public class MovieController {

	@Inject
	private MovieService movieService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public MovieDTO createMovie(@RequestBody MovieDTO movie) {
		MovieDTO createdMovie = movieService.create(movie);
		System.out.println("Movie created with id = " + createdMovie.getId());
		return createdMovie;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<MovieDTO> getMovies() {
		System.out.println("Collection of Movie requested");
		return movieService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public MovieDTO getMovie(@PathVariable long id) {
		System.out.println("Movie requested with id = " + id);
		return movieService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public MovieDTO updateMovie(@RequestBody MovieDTO movie, @PathVariable long id) {
		MovieDTO updatedMovie = movieService.update(movie);
		System.out.println("Movie updated with id = " + updatedMovie.getId());
		return updatedMovie;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteMovie(@PathVariable long id) {
		MovieDTO movie = movieService.read(id);
		movieService.delete(movie);
		System.out.println("Delete Movieb with id = " + id);
	}
}
