package EOC_Auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EventMappingAdd {
  @Test
  public void add() throws InterruptedException {
	  WebDriver driver = new FirefoxDriver();
	  	driver.get("http://192.168.1.240:8800/indira_p/eoc");
	  	driver.manage().window().maximize();
	  	Thread.sleep(2000);
	  	driver.findElement(By.id("username")).clear();
	  	driver.findElement(By.id("username")).sendKeys("admin");
	  	driver.findElement(By.id("password")).clear();
	  	driver.findElement(By.id("password")).sendKeys("a");
	  	driver.findElement(By.id("btLogin")).click();
	  	//Selecting Patients
	  	driver.findElement(By.className("StudyText")).click();
	  	Thread.sleep(4000);
	  	driver.findElement(By.className("cls_header_options")).click();
	  	driver.findElement(By.className("opn_form_mapping")).click();
	  	Thread.sleep(2000);
	  	driver.findElement(By.className("add")).click();
	  	Thread.sleep(1000);
	  	
	  	Select bpart = new Select(driver.findElement(By.id("body_part")));
	  	bpart.selectByVisibleText("Knee");
	  	Select trmt = new Select(driver.findElement(By.id("treatment")));
	  	trmt.selectByVisibleText("testtreat");
	  	Select reviewdet = new Select(driver.findElement(By.id("review_det_id")));
	  	reviewdet.selectByVisibleText("Inpatient Stay");
	  	Select rstatus = new Select(driver.findElement(By.id("review_det_status")));
	  	rstatus.selectByVisibleText("Active");
	  	Select alist = new Select(driver.findElement(By.id("availList_Total")));
	  	alist.selectByVisibleText("Inpatient Complications");
	  	
	  	driver.findElement(By.name("add")).click();
	  	driver.findElement(By.id("cmd_opn_forms_mapping_save")).click();
	  		  	
	       
	   }
}

