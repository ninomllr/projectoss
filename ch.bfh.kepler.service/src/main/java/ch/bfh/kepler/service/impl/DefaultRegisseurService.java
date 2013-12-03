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
public class DefaultRegisseurService implements RegisseurService {

	@Inject
	private RegisseurRepository regisseurRepository;

	private final ModelMapper mapper = new ModelMapper();

	public RegisseurDTO create(RegisseurDTO regisseurDto) {
		Regisseur regisseur = mapper.map(regisseurDto, Regisseur.class);
		Regisseur persistedRegisseur = regisseurRepository.save(regisseur);
		return mapper.map(persistedRegisseur, RegisseurDTO.class);
	}

	public RegisseurDTO read(long id) {
		Regisseur regisseur = regisseurRepository.findOne(id);
        if (regisseur == null) return null;
        return mapper.map(regisseur, RegisseurDTO.class);
	}

	public Collection<RegisseurDTO> list() {
		Iterable<Regisseur> regisseurs = regisseurRepository.findAll();
		Type listType = new TypeToken<Collection<RegisseurDTO>>() {
		}.getType();
		return mapper.map(regisseurs, listType);
	}

	public RegisseurDTO update(RegisseurDTO regisseurDto) {
		Regisseur regisseur = mapper.map(regisseurDto, Regisseur.class);
		Regisseur updatedRegisseur = regisseurRepository.save(regisseur);
		return mapper.map(updatedRegisseur, RegisseurDTO.class);
	}

	public void delete(RegisseurDTO regisseurDto) {
		Regisseur regisseur = regisseurRepository.findOne(regisseurDto.getId());
		regisseurRepository.delete(regisseur);
	}
}