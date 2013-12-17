package ch.bfh.kepler.rest.controller;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ch.bfh.kepler.service.RegisseurService;
import ch.bfh.kepler.service.dto.RegisseurDTO;


@Controller
@RequestMapping("/regisseurs")
public class RegisseurController {
	@Inject
	private RegisseurService regisseurService;

	/**
	 * Create
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public RegisseurDTO createRegisseur(@RequestBody RegisseurDTO regisseur) {
		RegisseurDTO createRegisseur = regisseurService.create(regisseur);
		System.out.println("Regisseur created with id = " + createRegisseur.getId());
		return createRegisseur;
	}

	/**
	 * ReadAll
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<RegisseurDTO> getRegisseurs() {
		System.out.println("Collection of Regisseur requested");
		return regisseurService.list();
	}

	/**
	 * Read
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public RegisseurDTO getRegisseur(@PathVariable long id) {
		System.out.println("Regisseur requested with id = " + id);
		return regisseurService.read(id);
	}

	/**
	 * Update
	 */
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public RegisseurDTO updateRegisseur(@RequestBody RegisseurDTO regisseur) {
		RegisseurDTO updateRegisseur = regisseurService.update(regisseur);
		System.out.println("Regisseur updated with id = " + updateRegisseur.getId());
		return updateRegisseur;
	}

	/**
	 * Delete
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteRegisseur(@PathVariable long id) {
		RegisseurDTO regisseur = regisseurService.read(id);
		regisseurService.delete(regisseur);
		System.out.println("Delete Regisseur with id = " + id);
	}

}
