package org.gitpro;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.test.BaseClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.BaseClassFinder;

public class Gittest extends BaseClass {
	
	@DataProvider(name="LoginData")
	public Object[][] getData(){
		return new Object[][] {{"jsl.ece1992@gmail.com","asdf"},{"hashprag@gmail.com","gfrtyj"},{"sderftg56","sertgjf"}};
		
	}
@Test(dataProvider="LoginData")
	private void tc01(String user, String pass) throws InterruptedException, IOException{
		getDriver();
		browserLaunch("https://www.facebook.com/");
		maximizeWindow();
	   //4.pass username
		WebElement txtUserName = findElementById("email");
		//String user1 = getDataFromCell("Sheet1", 1, 0);
		elementSendKeys(txtUserName, user);
		//5.pass passwords
		WebElement txtPassword = findElementById("pass");
		//String pass1 = getDataFromCell("Sheet1", 1, 1);
		elementSendKeys(txtPassword, pass);
		//6.clickLogin
		WebElement btnLogin = findElementByName("login");
		elementclick(btnLogin);
		Thread.sleep(6000);
        TakesScreenshot ts =(TakesScreenshot)driver;	    
	    File screenshotAs = ts.getScreenshotAs(OutputType.FILE); 
	    System.out.println(screenshotAs);
	    File file = new File("C:\\Users\\hashprag\\eclipse-workspace\\Gitpro\\screenshot\\image.png");
	    FileUtils.copyFileToDirectory(screenshotAs, file);
}
}