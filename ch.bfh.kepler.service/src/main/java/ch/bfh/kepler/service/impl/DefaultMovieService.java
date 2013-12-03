package ch.bfh.kepler.service.impl;

import java.lang.reflect.Type;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import ch.bfh.kepler.model.*;
import ch.bfh.kepler.repository.*;
import ch.bfh.kepler.service.*;
import ch.bfh.kepler.service.dto.*;

@Named
public class DefaultMovieService implements MovieService {

	@Inject
	private MovieRepository movieRepository;

	private final ModelMapper mapper = new ModelMapper();

	public MovieDTO create(MovieDTO movieDto) {
		Movie movie = mapper.map(movieDto, Movie.class);
		Movie persistedMovie = movieRepository.save(movie);
		return mapper.map(persistedMovie, MovieDTO.class);
	}

	public MovieDTO read(long id) {
		Movie movie = movieRepository.findOne(id);
        if (movie == null) return null;
        return mapper.map(movie, MovieDTO.class);
	}

	public Collection<MovieDTO> list() {
		Iterable<Movie> movies = movieRepository.findAll();
		Type listType = new TypeToken<Collection<MovieDTO>>() {
		}.getType();
		return mapper.map(movies, listType);
	}

	public MovieDTO update(MovieDTO movieDto) {
		Movie movie = mapper.map(movieDto, Movie.class);
		Movie updatedMovie = movieRepository.save(movie);
		return mapper.map(updatedMovie, MovieDTO.class);
	}

	public void delete(MovieDTO movieDto) {
		Movie movie = movieRepository.findOne(movieDto.getId());
		movieRepository.delete(movie);
	}
}