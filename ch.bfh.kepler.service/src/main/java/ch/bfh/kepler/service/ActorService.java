package ch.bfh.kepler.service;

import java.util.Collection;

import ch.bfh.kepler.service.dto.ActorDTO;


public interface ActorService {
	
	public ActorDTO create(ActorDTO book);
	public ActorDTO read(long id);
	public Collection<ActorDTO> list();
	public ActorDTO update(ActorDTO book);
	public void delete(ActorDTO book);

}