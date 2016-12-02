package com.vsked.test;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConfigurationTest {
	
	@Test
	public void propertiesTest(){
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
		    new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
		    .configure(params.properties()
		        .setFileName("config/systemConfig.properties"));
		try{
		    Configuration config = builder.getConfiguration();
		    String db_jdbcUrl=config.getString("db_jdbcUrl");
		    String db_userName=config.getString("db_userName");
		    String db_userPass=config.getString("db_userPass");
		    
		    System.out.println(db_jdbcUrl);
		    System.out.println(db_userName);
		    System.out.println(db_userPass);
		    assertEquals("helthmanager",db_userName);
		}catch(Exception cex){
			System.out.println(cex.getMessage());
		}
	}
	
	@Test
	public void xmlTest(){
		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<XMLConfiguration> builder =
		    new FileBasedConfigurationBuilder<XMLConfiguration>(XMLConfiguration.class)
		    .configure(params.xml()
		        .setFileName("config/myconfig.xml")
		        .setValidating(false)
		        .setSchemaValidation(false)
		        );
		try{
		XMLConfiguration config = builder.getConfiguration();
		String SSN=config.getString("Employee.SSN");
		String Name=config.getString("Employee.Name");
		String DateOfBirth=config.getString("Employee.DateOfBirth");
		String EmployeeType=config.getString("Employee.EmployeeType");
		double Salary=config.getDouble("Employee.Salary");
		
		System.out.println(SSN);
		System.out.println(Name);
		System.out.println(DateOfBirth);
		System.out.println(EmployeeType);
		System.out.println(Salary);
		assertEquals("555121211",SSN);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	

}
