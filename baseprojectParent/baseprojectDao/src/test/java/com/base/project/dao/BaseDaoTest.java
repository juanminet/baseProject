package com.base.project.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
@ContextConfiguration(locations = "classpath:test-spring-dao-context.xml")
public class BaseDaoTest {

	@Autowired
	IBaseDao baseDao;

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
	@Transactional
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
		baseDao.deleteBase(idBase);	}

	private void updateCoach(Long idBase, String newValue) {
		Base base = baseDao.getBaseById(idBase);
		base.setValue(newValue);
		
		baseDao.setBase(base);
		
	}

	private void makeAssertBase(String value, Base base) {
		assertEquals(value,base.getValue());
	}

	private Base readBase(Long idBase) {
		return baseDao.getBaseById(idBase);
	}

	private Long createBase(String value, String description) {
		Base base = new Base();
		base.setValue(value);
		base.setDescription(description);
		
		baseDao.setBase(base);
		
		return Long.valueOf(base.getId());
	}
}
