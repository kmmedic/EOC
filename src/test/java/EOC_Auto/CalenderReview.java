package EOC_Auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CalenderReview {
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
	  	driver.findElement(By.className("cls_header_calendar")).click();
	  	driver.findElement(By.className("gotocalmonthlist calReviewCls cls_odepother_study")).click();
	  	//driver.findElement(By.className("add")).click();
	  	driver.findElement(By.className("cal_month_body_part")).sendKeys("Hip");;
	  	driver.findElement(By.className("erow")).click();
	  		  	//System.out.println("Table text="+s);
	  		
	  	Thread.sleep(2000);
	  	
	 
	  		  	
	  	
	  	/*driver.findElement(By.id("BtnSearch")).click();
	  	Thread.sleep(2000);
	  	Select ptitle = new Select(driver.findElement(By.id("title")));
	  	ptitle.selectByVisibleText("Mr");
	  	//driver.findElement(By.id("title")).sendKeys("Mr");
	  	driver.findElement(By.id("first_name")).sendKeys("Auto");
	  	driver.findElement(By.id("sur_name")).sendKeys("patient");
	  	//verifyText display_name
	  	driver.findElement(By.id("address1")).sendKeys("addr1");
	  	driver.findElement(By.id("address2")).sendKeys("addr2");
	  	driver.findElement(By.id("address3")).sendKeys("addr3");
	  	driver.findElement(By.id("address4")).sendKeys("addr4");
	  	driver.findElement(By.id("postal_code")).sendKeys("656565");
	  	driver.findElement(By.id("home_phone_no")).sendKeys("034-645454");
      	driver.findElement(By.id("work_phone_no")).sendKeys("034-856575756");
      	driver.findElement(By.id("mobile_no")).sendKeys("034-8765756756");
    	driver.findElement(By.id("email_id")).sendKeys("test@gmail.com");
    	driver.findElement(By.id("hospital_ref")).sendKeys("3456");
    	driver.findElement(By.id("nhs_no")).sendKeys("543");
    	driver.findElement(By.name("living_arragements")).sendKeys("Alone");
    	driver.findElement(By.name("cmb_gender")).sendKeys("Male");
    	driver.findElement(By.id("birth_date")).click();
    	driver.findElement(By.id("birth_date")).sendKeys("10101966");
    	driver.findElement(By.name("marital_status")).sendKeys("Married");
    	driver.findElement(By.name("deceased")).click();
    	driver.findElement(By.id("txt_deceased")).sendKeys("Deceased");
    	driver.findElement(By.id("death_cause")).sendKeys("Cause");
    	driver.findElement(By.name("followup_status")).sendKeys("Active");
    	driver.findElement(By.id("change_date")).click();;
    	driver.findElement(By.id("change_date")).sendKeys("12102013");
    	driver.findElement(By.id("notes")).sendKeys("Test notes");
    	driver.findElement(By.id("txt_name")).sendKeys("kin_name");
    	driver.findElement(By.id("txt_relationship")).sendKeys("relation");
    	driver.findElement(By.id("txt_telphone_no")).sendKeys("034-5625356");
    	driver.findElement(By.id("txt_address")).sendKeys("address,address");
    	driver.findElement(By.id("txt_postal_code")).sendKeys("452356");
    	driver.findElement(By.id("occupation")).sendKeys("Engineeer");
    	driver.findElement(By.name("patient_languageid")).sendKeys("English");
    	driver.findElement(By.id("cmd_patient_det_save")).click();*/
      
	   }
}

