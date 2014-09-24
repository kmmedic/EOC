package EOC_Auto;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PatientSearch {
  private WebDriver driver;
  @Test
  public void add() throws InterruptedException {
	    driver = new FirefoxDriver();
	  	driver.get("http://192.168.1.240:8800/indira_p/eoc");
	  	driver.manage().window().maximize();
	  	
	 //try{
		 
	 
	  	driver.findElement(By.id("username")).clear();
	  	driver.findElement(By.id("username")).sendKeys("admin");
	  	driver.findElement(By.id("password")).clear();
	  	driver.findElement(By.id("password")).sendKeys("a");
	  	driver.findElement(By.id("btLogin")).click();
	  	//Selecting Patients
	  	driver.findElement(By.className("StudyText")).click();
	  	WebDriverWait wait = new WebDriverWait(driver,05);
	  	wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_header_patient")));
	  	driver.findElement(By.className("cls_header_patient")).click();
	  	Thread.sleep(500);
	  	driver.findElement(By.id("SearchBox")).click();
	  	driver.findElement(By.id("SearchBox")).sendKeys("testpatienta");
	  	driver.findElement(By.className("btnStudySearch")).click();
	  	Thread.sleep(500);
//	  	driver.findElement(By.className("flex_patient")).click();
		List<WebElement> liElements = driver.findElements(By.className("flex_patient"));
		Reporter.log("size of the list"+liElements.size(),true);
		    for(WebElement li : liElements){
		    	 String temp1 = li.getAttribute("class");
		    	 String temp = li.getText();
		    	 Reporter.log("Class in li --- "+temp1,true);
				 Reporter.log("Text in li --- "+temp,true);
				 
				 //wait.until(ExpectedConditions.elementToBeSelected(By.className("flex_patient")));
				 
				 Actions action = new Actions(driver);
		    	 WebElement element = li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr/td/div"));	
		    	 		    	 
		    	 Action doubleClick = action.doubleClick(element).build();
		    	 doubleClick.perform();// After performing double click Map will load
		    	 
		  Reporter.log("Text in li --- "+temp,true);
		 Reporter.log("class in li --- "+temp1,true);
//		   if(temp1.equals("py")){
//		   futurebroadcast = futurebroadcast+1;
//		   }
		   }
//	 }catch (Exception e){
//		 e.printStackTrace();
//	 }
	   }
//  @AfterMethod
//  public void closeConn(){
//	  driver.quit();
//  }
}

