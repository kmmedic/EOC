package imaginehealth;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Patientdocsend {

	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	public void setup(){
		String url="http://192.168.1.240:8800/rameshkumar_p/myclinic/index";
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("login")).click();
	}
	@Test
	public void testappointment() throws Exception
	 {
		Thread.sleep(1000);
		new Select(driver.findElement(By.id("cbosearch"))).selectByVisibleText("Last Name");
	    Thread.sleep(1000);
	    driver.findElement(By.id("SearchBox")).clear();
	    driver.findElement(By.id("SearchBox")).sendKeys("test");
	    Thread.sleep(1000);
	    driver.findElement(By.id("btn_study_search")).click();
	    Thread.sleep(1000);
	    //Double click retrieve value 
	    Thread.sleep(1000);
	    WebElement trmtlist = driver.findElement(By.className("flex_patient"));
	    List<WebElement> tagname2 = trmtlist.findElements(By.tagName("tr"));
	    Reporter.log("size of the treatment list "+tagname2.size(),true);
	    Actions action1 = new Actions(driver);
	    int i=1;
		  for(WebElement tlist : tagname2)
		   {		
			  WebElement element1 = tlist.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[3]/div[2]/div/div[6]/table/tbody/tr["+i+"]/td[2]/div"));
			  String sname =tlist.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[3]/div[2]/div/div[6]/table/tbody/tr["+i+"]/td[2]/div")).getText();
		  	if(sname.matches("test"))
		  	{
		  		Action doubleClick1 = action1.doubleClick(element1).build();
		    	 doubleClick1.perform();
		    	 
		    	 System.out.println("enter loop");
		    	 break;
		  	}	
		  }
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div[2]/div/div/ul/li[3]/a/span")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[7]/table/tbody/tr[1]/td[3]/div")).click();
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[4]/div[1]/div[9]/div/span")));
		  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div/div[4]/div[1]/div[9]/div/span")).click();
		  Thread.sleep(1000);
		  //driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/table/tbody/tr[4]/td/div/input")).sendKeys("12345");
		  driver.findElement(By.id("FckDiv")).sendKeys("123");
		//driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/button[1]")).click();
	 }

}
