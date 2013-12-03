package ch.bfh.kepler.service;

import java.util.Collection;

import ch.bfh.kepler.service.dto.GenreDTO;


public interface GenreService {
	
	public GenreDTO create(GenreDTO book);
	public GenreDTO read(long id);
	public Collection<GenreDTO> list();
	public GenreDTO update(GenreDTO book);
	public void delete(GenreDTO book);

}