package com.base.project.web.rest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.base.project.web.controller.commands.BaseCommand;



public class RestConsumerTest {
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
	
//	@Test
//	public void testRestConsumer() {
//		   RestTemplate restTemplate = new RestTemplate();
//	       String baseListString = restTemplate.getForObject("http://localhost:8080/baseprojectWeb/rest/base/all", String.class);
//	       System.out.println(baseListString);
//	       
//	       
//	       ResponseEntity<BaseCommand[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/baseprojectWeb/rest/base/all", BaseCommand[].class);
//	       BaseCommand[] baseList =responseEntity.getBody();
//	       MediaType contentType = responseEntity.getHeaders().getContentType();
//	       HttpStatus statusCode = responseEntity.getStatusCode();
//	       
//	       restTemplate = new RestTemplate();
//	       BaseCommand base = restTemplate.getForObject("http://localhost:8080/baseprojectWeb/rest/base/" + baseList[0].getIdBase(), BaseCommand.class);
//	       System.out.println("[" + base.getIdBase() + " , " + base.getValue() + " , " + base.getDescription() + "]");
//	}
	
	@Test
	public void testJava(){
		String str1 = "String1";
		String str2 = str1;
		String str3 = "String1";
		String str4 = new String("String1");
		
		if (str1 == str2){
		System.out.println("YES");	
		}
		
		if (str1 == "String1"){
			System.out.println("YES");
		}
		
		if (str1 == str3){
			System.out.println("YES");
		}
		
		if (str1 == str4){
			System.out.println("YES");
		}
	}
}
