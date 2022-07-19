package com.tecsup.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.services.PetService;

/**
 * 
 * @author jgomezm
 *
 */
@RestController
public class PetController {

	@Autowired
	private PetService service;

	/**
	 * 
	 * @return
	 */
	// @JsonIgnore
	@GetMapping("/pets")
	public Iterable<Pet> getPets() {
		//
		return service.findAll();
	}

	
	/**
	 * Create Pet
	 * 
	 * @param newPet
	 * @return
	 */
	@PostMapping("/pets")
	@ResponseStatus(HttpStatus.CREATED)
	Pet create(@RequestBody Pet newPet) {
		return service.create(newPet);
	}

	/**
	 * Find by id
	 * 
	 * @param id
	 * @return
	 * @throws PetNotFoundException
	 */
	@GetMapping("/pets/{id}")
	ResponseEntity<Pet> findOne(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (PetNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Save or update
	 * 
	 * @param newPet
	 * @param id
	 * @return
	 */
	
	@DeleteMapping("/pets/{id}")
	ResponseEntity<String> delete(@PathVariable Long id) {

		try {
			service.delete(id);
			return new ResponseEntity<>("" + id, HttpStatus.OK);
		} catch (PetNotFoundException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
