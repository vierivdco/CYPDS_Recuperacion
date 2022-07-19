package com.tecsup.petclinic.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.PetNotFoundException;
@SpringBootTest
public class PetServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(PetServiceTest.class);

	@Autowired
	private PetService petService;

	/**
	 * 
	 */
	@Test
	public void testCreatePet() {

		String PET_NAME = "Ponky";
		int OWNER_ID = 1;
		int TYPE_ID = 1;

		Pet pet = new Pet(PET_NAME, OWNER_ID, TYPE_ID, null);

		
		Pet petCreated = petService.create(pet);
		
		logger.info("PET CREATED :" + petCreated);

		//          ACTUAL                 , EXPECTED 
		assertThat(petCreated.getId()      , notNullValue());
		assertThat(petCreated.getName()    , is(PET_NAME));
		assertThat(petCreated.getOwnerId() , is(OWNER_ID));
		assertThat(petCreated.getTypeId()  , is(TYPE_ID));

	}
	/**
	 * 
	 */
	@Test
	public void testDeletePet() {

		String PET_NAME = "Bird";
		int OWNER_ID = 1;
		int TYPE_ID = 1;

		Pet pet = new Pet(PET_NAME, OWNER_ID, TYPE_ID, null);

		pet = petService.create(pet);
		logger.info("" + pet);

		try {
			petService.delete(pet.getId());
		} catch (PetNotFoundException e) {
			assertThat(e.getMessage(), false);
		}
			
		try {
			petService.findById(pet.getId());
			assertThat(true, is(false));
		} catch (PetNotFoundException e) {
			assertThat(true, is(true));
		} 				

	}
}