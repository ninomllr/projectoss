package ch.bfh.kepler.service;

import javax.inject.Inject;

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
		newActor.setFirstname("test");
		newActor = actorService.create(newActor);
		
		System.out.println((actorService==null?"hure":"nein"));
		System.out.println(newActor.getId());
		
		// Read
		//ActorDTO readActor = actorService.read(newActor.getId());
		//Assert.assertTrue(newActor.getFirstname().equals(readActor.getFirstname()));
		/*
		// Update
		readBook.setLastname("Test2");
		readBook = actorService.update(readBook);
		ActorDTO updatedBook = actorService.read(readBook.getId());
		Assert.assertTrue(readBook.getLastname().equals(updatedBook.getLastname()));

		// Delete
		actorService.delete(updatedBook);
		ActorDTO deletedBook = actorService.read(readBook.getId());
		Assert.assertNull(deletedBook);*/
	}

}