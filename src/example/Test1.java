package example;

import org.testng.annotations.Test;

import example.utils.DataInteraction;

import org.testng.annotations.BeforeMethod;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Test1 {
	
	static WebDriver  driver= null;
	private final static Logger logger = Logger.getLogger(Test1.class);

	
  @Test(priority=1)
  public void login() throws IOException {

	  logger.info("login functin started");
	  
	  String d[][] = DataInteraction.readExcel("erp2");
	  
	  driver.findElement(By.id("txtUserName")).sendKeys(d[0][0]);
	  driver.findElement(By.id("txtPassword")).sendKeys(d[0][1]);
	  	  
	  driver.findElement(By.id("btnSubmit")).click();
	  logger.info("login functin completed");
	  
	  //screen shot
	 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileHandler.copy(src, new File("C:\\Users\\welcome\\Desktop\\out.png"));
	 
  }
  @Test(priority=2,dependsOnMethods= {"login"})
  public void search() {

	  logger.info("search function started");
	  String d[][] = DataInteraction.readExcel("erp3");
	  
	  driver.findElement(By.xpath("//*[@id=\"ctl00_txtsearch\"]")).sendKeys(d[0][0]);
	  driver.findElement(By.xpath("//*[@id=\"ctl00_txtsearch\"]")).sendKeys(Keys.ENTER);
	  
	  logger.info("search function completed");
	  
  }
  
  
  @Test
  public void logout() {

  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
	  
	  driver =new ChromeDriver();
	  driver.get("http://erp.techvisionit.com/");
	  
  }

  @AfterTest
  public void afterTest() {
  }

}
