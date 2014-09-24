package EOC_negativetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Addpatient {
	WebDriver driver=new FirefoxDriver();
	
	@BeforeTest
	public void setup() throws Exception{
	driver.get("http://smb-beta.imeddoc.net/login.php");
	driver.manage().window().maximize();
	Thread.sleep(1000);	
	driver.findElement(By.id("username")).clear();
	driver.findElement(By.id("username")).sendKeys("admin");
	Thread.sleep(1000);
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys("Sp0rtsM3d");
	Thread.sleep(1000);
	driver.findElement(By.id("btLogin")).click();
	Thread.sleep(2000);
	}
	
	@Test
	public void patient() throws Exception{
		Thread.sleep(2000);
		driver.findElement(By.linkText("Patient")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("BtnSearch")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("medicare_number")).clear();
		driver.findElement(By.id("medicare_number")).sendKeys("smb1");
		Thread.sleep(1000);
		driver.findElement(By.id("vip_patient")).click();
		Thread.sleep(1000);
		
		/*Select title = new  Select(driver.findElement(By.id("txt_title")));
		title.selectByVisibleText("Mr");
		Thread.sleep(1000);
		driver.findElement(By.id("insurname")).sendKeys("Firstname");
		Thread.sleep(1000);
		driver.findElement(By.id("inname")).sendKeys("Lastname");
		Thread.sleep(1000);
		driver.findElement(By.id("inknownas")).sendKeys("Knows");
		Thread.sleep(1000);
		Select gender = new  Select(driver.findElement(By.id("gender")));
		gender.selectByVisibleText("Male");
		Thread.sleep(1000);
		driver.findElement(By.id("indob")).clear();
		driver.findElement(By.id("indob")).sendKeys("31-03-2000");
		Thread.sleep(1000);
		Select country =new Select(driver.findElement(By.id("cmbCntry")));
		country.selectByVisibleText("Ireland");
		Thread.sleep(1000);
		driver.findElement(By.id("inaddr1")).sendKeys("Address1");
		Thread.sleep(1000);
		driver.findElement(By.id("inaddr2")).sendKeys("Address2");
		Thread.sleep(1000);
		driver.findElement(By.id("Street")).sendKeys("street");
		Thread.sleep(1000);
		driver.findElement(By.id("City")).sendKeys("City");
		Thread.sleep(1000);
		driver.findElement(By.id("State")).clear();
		driver.findElement(By.id("State")).sendKeys("Ire");
		Thread.sleep(1000);
		driver.findElement(By.id("ZIP")).sendKeys("000000");
		Thread.sleep(1000);
		driver.findElement(By.id("inphone")).sendKeys("0000000000");
		Thread.sleep(1000);
		driver.findElement(By.id("inmobile")).sendKeys("0000000000");
		Thread.sleep(1000);
		driver.findElement(By.id("work_phone")).sendKeys("0000000000");
		Thread.sleep(1000);
		driver.findElement(By.id("inemail")).sendKeys("first@mail.com");
		Thread.sleep(1000);*/
		Select pprovider = new  Select(driver.findElement(By.id("referring_doctor")));
		pprovider.selectByVisibleText("Haas Paul");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver,05);
  	  	wait.until(ExpectedConditions.elementToBeClickable(By.id("txt_position")));
		driver.findElement(By.id("txt_position")).sendKeys("Physical Therapy");
		Thread.sleep(1000);
		Select level = new  Select(driver.findElement(By.id("cmbSports")));
		level.selectByIndex(2);
		
		Thread.sleep(1000);
		driver.findElement(By.name("notes")).sendKeys("Testnotes");
		Thread.sleep(1000);

	}

}
