package EOC_Auto;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TreatmentAdd {
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
	  	driver.findElement(By.className("opn_treatment")).click();
	  	Thread.sleep(2000);
	  	driver.findElement(By.className("add")).click();
	  	Thread.sleep(1000);
	  	
	  	driver.findElement(By.id("treatment_master_name")).sendKeys("Auto_treatment");;
	  	Select status = new Select(driver.findElement(By.id("treatment_master_status")));
	  	status.selectByVisibleText("Active");
	  	driver.findElement(By.id("chk_uc_study_1")).click();
	  	
	  	driver.findElement(By.id("btn-ok")).click();
	  	Alert alert = driver.switchTo().alert();
        String AlertText = alert.getText();
        System.out.println(AlertText);
        Assert.assertEquals("Treatment Details added successfully", AlertText);
         alert.accept();
        Thread.sleep(3000);
        
        //Verifying whether added treatment reflects in Event Mapping
        driver.findElement(By.className("opn_form_mapping")).click();
	  	Thread.sleep(2000);
	  	driver.findElement(By.className("add")).click();
	  	Thread.sleep(1000);
	  	Select trmt = new Select(driver.findElement(By.id("treatment")));
	  	trmt.selectByVisibleText("Auto_treatment");
        	  			  	
	       
	   }
}

