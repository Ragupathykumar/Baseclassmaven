package org.pom;

import org.baseclasses.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_Object_model extends BaseClass  {
	
	 public Page_Object_model() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="username")
private WebElement txtusername;
@FindBy(id="password")
private WebElement txtpassword;
@FindBy(id="login")
private WebElement btnlogin;



	
public WebElement getTxtusername() {
	return txtusername;
}




public WebElement getTxtpassword() {
	return txtpassword;
}




public WebElement getBtnlogin() {
	return btnlogin;
}




public void loginadactin(String username,String password) {
 
type(getTxtusername(), username);
type(getTxtpassword(), password);
click(getBtnlogin());
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
