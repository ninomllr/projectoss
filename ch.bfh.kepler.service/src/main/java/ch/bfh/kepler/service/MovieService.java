package ch.bfh.kepler.service;

import java.util.Collection;

import ch.bfh.kepler.service.dto.MovieDTO;


public interface MovieService {
	
	public MovieDTO create(MovieDTO book);
	public MovieDTO read(long id);
	public Collection<MovieDTO> list();
	public MovieDTO update(MovieDTO book);
	public void delete(MovieDTO book);

}