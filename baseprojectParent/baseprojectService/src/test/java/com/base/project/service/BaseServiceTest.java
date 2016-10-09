package com.base.project.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.base.project.model.Base;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:test-spring-service-context.xml")
public class BaseServiceTest {
	
	@Autowired
	IBaseService baseService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testBaseCRUD() {
		// Definition base
		String value = "Mourinho";
		String description = "Garcia";

		// Create base
		Long idBase = createBase(value, description);

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
		makeAssertBase(newValue, base);

		// Delete Base
		deleteBase(idBase);

		// Read base
		base = readBase(idBase);

		// Make assert
		assertNull(base);
	}

	private void deleteBase(Long idBase) {
		// TODO Auto-generated method stub
		baseService.deleteBase(idBase);	}

	private void updateCoach(Long idBase, String newValue) {
		Base base = baseService.getBaseById(idBase);
		base.setValue(newValue);
		
		baseService.setBase(base);
		
	}

	private void makeAssertBase(String value, Base base) {
		assertEquals(value,base.getValue());
	}

	private Base readBase(Long idBase) {
		return baseService.getBaseById(idBase);
	}

	private Long createBase(String value, String description) {
		Base base = new Base();
		base.setValue(value);
		base.setDescription(description);
		
		baseService.setBase(base);
		
		return Long.valueOf(base.getId());
	}
	
	@Test
	public void testAllBases(){
		// Definition base
		String value1 = "Mourinho";
		String description1 = "Garcia";
		String value2 = "Guardiola";
		String description2 = "Pepito";
		String value3 = "Antonia";
		String description3 = "Sapatito";
		
		//Read all bases
		List<Base> listBases = readAllBases();
		
		assertEquals(0,listBases.size());
				
		// Create base
		Long idBase1 = createBase(value1, description1);
		Long idBase2 = createBase(value2, description2);
		Long idBase3 = createBase(value3, description3);
		
		//Read all bases
		listBases = readAllBases();		
		assertEquals(3,listBases.size());		
		
		// Delete Base
		deleteBase(idBase1);
		
		//Read all bases
		listBases = readAllBases();		
		assertEquals(2,listBases.size());	
				
		deleteBase(idBase2);
		
		//Read all bases
		listBases = readAllBases();		
		assertEquals(1,listBases.size());	
		
		deleteBase(idBase3);
		
		//Read all bases
		listBases = readAllBases();
		
		assertEquals(0,listBases.size());	
	}

	private List<Base> readAllBases() {
		return baseService.getAllBases();
	}

}
