package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;

/**
 * 
 * @author jgomezm
 *
 */
public interface PetService {

	/**
	 * 
	 * @param pet
	 * @return
	 */
	Pet create(Pet pet);

	/**
	 * 
	 * @param pet
	 * @return
	 */
	void delete(Long id) throws PetNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	Pet findById(long id) throws PetNotFoundException;

	/**
	 * 
	 * @param name
	 * @return
	 */

	Iterable<Pet> findAll();

}