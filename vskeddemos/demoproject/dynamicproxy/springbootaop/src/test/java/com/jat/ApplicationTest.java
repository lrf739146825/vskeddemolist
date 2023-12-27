package com.jat;

import static org.testng.Assert.assertEquals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ApplicationTest {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Test
	public void hello() {
		if(log.isTraceEnabled()){
			log.trace("hello start");
		}

		Application log4j2testNG7Application = new Application();

//		String accountName="jatCompany";
//		String currenAccounttName = log4j2testNG7Application.hello(accountName);
//
//		assertEquals("jatCompany", currenAccounttName);

		if(log.isTraceEnabled()){
			log.trace("hello end");
		}
	}
	
}
