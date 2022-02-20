package org.pom;

import org.baseclasses.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Execution  extends BaseClass  {
	@BeforeClass
	public static void beforemethod() {
		BaseClass.openbrowser();
		BaseClass.loadurl("https://adactinhotelapp.com/");
		BaseClass.maximise();
		BaseClass.implicitwait(30);
	}
	
	@Test
	public void tetcase() {
		Page_Object_model login=new Page_Object_model();
		login.loginadactin("ragurajan", "africaasia");

	}
	@AfterClass
	public static void aftermethod() {
	BaseClass.closebrowser();

	}
	
	
	
	
	
	
	
	
	
	
	}
	
