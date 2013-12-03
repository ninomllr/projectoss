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
public class DefaultGenreService implements GenreService {

	@Inject
	private GenreRepository genreRepository;

	private final ModelMapper mapper = new ModelMapper();

	public GenreDTO create(GenreDTO genreDto) {
		Genre genre = mapper.map(genreDto, Genre.class);
		Genre persistedGenre = genreRepository.save(genre);
		return mapper.map(persistedGenre, GenreDTO.class);
	}

	public GenreDTO read(long id) {
		Genre genre = genreRepository.findOne(id);
        if (genre == null) return null;
        return mapper.map(genre, GenreDTO.class);
	}

	public Collection<GenreDTO> list() {
		Iterable<Genre> genres = genreRepository.findAll();
		Type listType = new TypeToken<Collection<GenreDTO>>() {
		}.getType();
		return mapper.map(genres, listType);
	}

	public GenreDTO update(GenreDTO genreDto) {
		Genre genre = mapper.map(genreDto, Genre.class);
		Genre updatedGenre = genreRepository.save(genre);
		return mapper.map(updatedGenre, GenreDTO.class);
	}

	public void delete(GenreDTO genreDto) {
		Genre genre = genreRepository.findOne(genreDto.getId());
		genreRepository.delete(genre);
	}
}