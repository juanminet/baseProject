package com.base.project.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class baseTest {
	
	private static EntityManagerFactory entityManagerFactory = null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory =  Persistence.createEntityManagerFactory("baseprojectPU");		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {		
		entityManagerFactory = null;		
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCRUD() {

		// Definition base
		String value = "Mourinho";
		String description = "Garcia";

		// Create base
		Long idBase = createCoach(value,description);

		// Make assert
		assertNotNull(idBase);

		// Read base
		Base base = readBase(idBase);

		// Make assert
		makeAssertBase(value, base);

		// Update base
		String newValue = "Guardiola";

		updateCoach(idBase, newValue);

		// Read base
		base = readBase(idBase);

		// Make assert
		makeAssertBase(newValue,base);

		// Delete Base
		deleteBase(idBase);

		// Read base
		base = readBase(idBase);

		// Make assert
		assertNull(base);
	}

	private void deleteBase(Long idBase) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//read base
		Base base = entityManager.find(Base.class, idBase);
		
		//delete base
		entityManager.getTransaction().begin();
		entityManager.remove(base);
		entityManager.getTransaction().commit();
		
	}

	private void updateCoach(Long idBase, String newValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//read base
		Base base = entityManager.find(Base.class, idBase);
		
		//update base
		base.setValue(newValue);
		
		entityManager.getTransaction().begin();
		entityManager.persist(base);
		entityManager.getTransaction().commit();		
	}

	private void makeAssertBase(String value, Base base) {
		assertEquals(value, base.getValue());
	}

	private Base readBase(Long idBase) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Base base = entityManager.find(Base.class, idBase);
		return base;
	}

	private Long createCoach(String value, String description) {
		Base base = new Base();
		base.setValue(value);
		base.setDescription(description);
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Persist entity
		entityManager.getTransaction().begin();
		entityManager.persist(base);
		entityManager.getTransaction().commit();
		
		return Long.valueOf(base.getId());
	}

}
