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
public class DefaultActorService implements ActorService {

	@Inject
	private ActorRepository actorRepository;

	private final ModelMapper mapper = new ModelMapper();

	public ActorDTO create(ActorDTO actorDto) {
		Actor actor = mapper.map(actorDto, Actor.class);
		Actor persistedactor = actorRepository.save(actor);
		return mapper.map(persistedactor, ActorDTO.class);
	}

	public ActorDTO read(long id) {
		Actor actor = actorRepository.findOne(id);
        if (actor == null) return null;
        return mapper.map(actor, ActorDTO.class);
	}

	public Collection<ActorDTO> list() {
		Iterable<Actor> actors = actorRepository.findAll();
		Type listType = new TypeToken<Collection<ActorDTO>>() {
		}.getType();
		return mapper.map(actors, listType);
	}

	public ActorDTO update(ActorDTO actorDto) {
		Actor actor = mapper.map(actorDto, Actor.class);
		Actor updatedactor = actorRepository.save(actor);
		return mapper.map(updatedactor, ActorDTO.class);
	}

	public void delete(ActorDTO actorDto) {
		Actor actor = actorRepository.findOne(actorDto.getId());
		actorRepository.delete(actor);
	}
}