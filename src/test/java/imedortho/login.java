package imedortho;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
    DataProv datap = new DataProv();
    excelwrite1 exw=new excelwrite1();
	
	private WebDriver driver = new FirefoxDriver();
	
  @Test
  public void setup() throws InterruptedException
  {
  	driver.get("http://192.168.1.241/imedortho_demo11914/Login");
  	//driver.get("https://ortho-demo.imeddoc.net/Login");
  	driver.manage().window().maximize();
  	
  	driver.findElement(By.id("username")).clear();
	  	driver.findElement(By.id("username")).sendKeys("admin");
	  	driver.findElement(By.id("password")).clear();
	  	driver.findElement(By.id("password")).sendKeys("a");
	  	driver.findElement(By.id("btLogin")).click();
	  	exw.readExcel("C:\\QA\\excelwrite.xls", 0, 3, 3, "SUccess");
}
  
  
 
  
  
}