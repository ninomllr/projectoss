package ch.bfh.kepler.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.kepler.service.ActorService;
import ch.bfh.kepler.service.dto.ActorDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class ActorServiceIT {

	@Inject
	private ActorService actorService;

	@Test
	public void test() {

		// Create
		ActorDTO newActor = new ActorDTO();
		newActor.setFirstname("test");
		newActor = actorService.create(newActor);
		
		// Read
		ActorDTO readActor = actorService.read(newActor.getId());
		Assert.assertTrue(newActor.getFirstname().equals(readActor.getFirstname()));
		
		// Update
		readActor.setLastname("Test2");
		readActor = actorService.update(readActor);
		ActorDTO updatedActor = actorService.read(readActor.getId());
		Assert.assertTrue(readActor.getLastname().equals(updatedActor.getLastname()));

		// Delete
		actorService.delete(updatedActor);
		ActorDTO deletedActor = actorService.read(readActor.getId());
		Assert.assertNull(deletedActor);
	}

}