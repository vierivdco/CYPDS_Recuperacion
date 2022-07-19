package com.tecsup.petclinic.services;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.repositories.PetRepository;

/**
 * 
 * @author jgomezm
 *
 */
@Service
public class PetServiceImpl implements PetService {

	private static final Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);

	@Autowired
	PetRepository petRepository;
	@Override
	public Pet create(Pet pet) {
		return petRepository.save(pet);
	}
	
	@Override
	public void delete(Long id) throws PetNotFoundException{

		Pet pet = findById(id);
		petRepository.delete(pet);

	}

	@Override
	public Pet findById(long id) throws PetNotFoundException {

		Optional<Pet> pet = petRepository.findById(id);

		if ( !pet.isPresent())
			throw new PetNotFoundException("Record not found...!");
			
		return pet.get();
	}
	
	@Override
	public Iterable<Pet> findAll() {
		
		// TODO Auto-generated 
		return petRepository.findAll();
	
	}

}