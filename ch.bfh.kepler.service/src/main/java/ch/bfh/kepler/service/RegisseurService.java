package ch.bfh.kepler.service;

import java.util.Collection;

import ch.bfh.kepler.service.dto.RegisseurDTO;


public interface RegisseurService {
	
	public RegisseurDTO create(RegisseurDTO book);
	public RegisseurDTO read(long id);
	public Collection<RegisseurDTO> list();
	public RegisseurDTO update(RegisseurDTO book);
	public void delete(RegisseurDTO book);

}