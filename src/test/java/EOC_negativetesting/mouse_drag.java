package EOC_negativetesting;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class mouse_drag {
	 WebDriver driver = new FirefoxDriver();
	DataProviderAdd datap = new DataProviderAdd();
	 @BeforeTest
	 public void setup() throws InterruptedException
	 {
		 driver.get("http://192.168.1.240:8800/rameshkumar_p/myclinic/app#");
		  	
		  	driver.manage().window().maximize();
		  	Thread.sleep(2000);
		  //	driver.findElement(By.id("username")).clear();
		  //	driver.findElement(By.id("username")).sendKeys("admin");
		  //	driver.findElement(By.id("password")).clear();
		  //	driver.findElement(By.id("password")).sendKeys("a");
		  	driver.findElement(By.name("login")).click();
		  	//Selecting Patients
		  	driver.findElement(By.xpath("/html/body/div/div/ul/li[3]/a")).click();
		  	Thread.sleep(4000);
		  	
	 }
	 @DataProvider(name = "data-provider", parallel = false)
		public Object[][] data() throws Exception {
			Object[][] retObjArr=datap.getTableArray("C:\\QAA\\Master_inputdata.xls",1);
	        return(retObjArr);
	        
		}
  @Test(dataProvider="data-provider")
  public void add(String con_id,String con_title,String con_fname,String con_sname,String con_addr1,String con_addr2,String con_addr3,String city,String phno
		  ,String email,String fax,String secretary,String study_all,String st_eoc,String st_mrk,String st_antho,String st_amis,String st_gmk,String st_corin
		  ,String st_jri,String st_stryker,String st_pcr,String st_zimmer,String st_anthony,String active,String warn_alert) throws Exception {
	 
	  	
	  		  	
	  		       
	  		}
	  	
}


