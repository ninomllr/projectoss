package ch.bfh.kepler.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.h2.command.ddl.CreateAggregate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.kepler.model.Actor;
import ch.bfh.kepler.service.ActorService;
import ch.bfh.kepler.service.dto.ActorDTO;

@Controller
@RequestMapping("/actors")
public class ActorController {
	
	@Inject
	private ActorService actorService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ActorDTO createMovie(@RequestBody ActorDTO actor) {
		ActorDTO createActor = actorService.create(actor);
		System.out.println("Actor created with id = " + createActor.getId());
		return createActor;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<ActorDTO> getActor() {
		System.out.println("Collection of Movie requested");
		return actorService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ActorDTO getMovie(@PathVariable long id) {
		System.out.println("Actor requested with id = " + id);
		return actorService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	@ResponseBody
	public ActorDTO updateMovie(@RequestBody ActorDTO actor, @PathVariable long id) {
		ActorDTO updatedActor = actorService.update(actor);
		System.out.println("Actor updated with id = " + updatedActor.getId());
		return updatedActor;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteActor(@PathVariable long id) {
		ActorDTO actor = actorService.read(id);
		actorService.delete(actor);
		System.out.println("Delete Actor with id = " + id);
	}

}
