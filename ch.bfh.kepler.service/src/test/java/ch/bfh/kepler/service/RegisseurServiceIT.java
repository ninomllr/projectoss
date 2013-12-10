package ch.bfh.kepler.service;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ch.bfh.kepler.service.RegisseurService;
import ch.bfh.kepler.service.dto.RegisseurDTO;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/serviceContext.xml")
public class RegisseurServiceIT {

	@Inject
	private RegisseurService regisseurService;

	@Test
	public void test() {

		// Create
		RegisseurDTO newRegisseur = new RegisseurDTO();
		newRegisseur.setFirstname("test");
		newRegisseur.setFirstname("test");
		newRegisseur = regisseurService.create(newRegisseur);
		
		// Read
		RegisseurDTO readRegisseur = regisseurService.read(newRegisseur.getId());
		Assert.assertTrue(newRegisseur.getFirstname().equals(readRegisseur.getFirstname()));

		// Update
		readRegisseur.setFirstname("Test2");
		readRegisseur = regisseurService.update(readRegisseur);
		RegisseurDTO updatedRegisseur = regisseurService.read(readRegisseur.getId());
		Assert.assertTrue(readRegisseur.getFirstname().equals(updatedRegisseur.getFirstname()));


		// Delete
		regisseurService.delete(updatedRegisseur);
		RegisseurDTO deletedRegisseur = regisseurService.read(readRegisseur.getId());
		Assert.assertNull(deletedRegisseur);

	}

}