package EOC_Auto;

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

public class ConsultantAdd {
	 WebDriver driver = new FirefoxDriver();
	DataProviderAdd datap = new DataProviderAdd();
	 @BeforeTest
	 public void setup() throws InterruptedException
	 {
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
		  	
		  			driver.findElement(By.className("opn_surgeon")).click();
		  		  	Thread.sleep(2000);
	 }
	 @DataProvider(name = "data-provider", parallel = false)
		public Object[][] data() throws Exception {
			Object[][] retObjArr=datap.getTableArray("C:\\QAA\\Master_inputdata.xls",0);
	        return(retObjArr);
	        
		}
  @Test(dataProvider="data-provider")
  public void add(String con_id,String con_title,String con_fname,String con_sname,String con_addr1,String con_addr2,String con_addr3,String city,String phno
		  ,String email,String fax,String secretary,String study_all,String st_eoc,String st_mrk,String st_antho,String st_amis,String st_gmk,String st_corin
		  ,String st_jri,String st_stryker,String st_pcr,String st_zimmer,String st_anthony,String active) throws Exception {
	 
	  	
	  		  	driver.findElement(By.className("add")).click();
	  		  	Thread.sleep(1000);
	  		  	
	  		  	driver.findElement(By.id("consultant_id")).sendKeys(con_id);
	  		  	Select ptitle = new Select(driver.findElement(By.id("title_id")));
	  		  	ptitle.selectByVisibleText(con_title);
	  		  	driver.findElement(By.id("fore_name")).sendKeys(con_fname);
	  		  	driver.findElement(By.id("sur_name")).sendKeys(con_sname);
	  		  	driver.findElement(By.id("display_name")).click();
	  		  	String dname=driver.findElement(By.id("display_name")).getAttribute("value");
	  		  	System.out.println("dname="+dname);
	  		  	String dname1=con_fname.concat(","+con_sname);
	  		  System.out.println("dname1="+dname1);
	  		   	driver.findElement(By.id("address1")).sendKeys(con_addr1);
	  		  	driver.findElement(By.id("address2")).sendKeys(con_addr2);
	  		  	driver.findElement(By.id("address3")).sendKeys(con_addr3);
	  		  	driver.findElement(By.id("city")).sendKeys(city);
	  		  	driver.findElement(By.id("phone")).sendKeys(phno);
	  		  	driver.findElement(By.id("email_id")).sendKeys(email);
	  		  	driver.findElement(By.id("fax")).sendKeys(fax);
	  		  	driver.findElement(By.id("secretary")).sendKeys(secretary);
	  		  	driver.findElement(By.id("chk_uc_study_1")).click();
	  		  	driver.findElement(By.id("surgeon_status")).sendKeys(active);
	  		  Assert.assertEquals(dname,dname1);	
	  		  	driver.findElement(By.id("cmd_opn_surgeon_save")).click();
	  		  	
	  		  Alert alert = driver.switchTo().alert();
		         String AlertText = alert.getText();
		         System.out.println(AlertText);
		         Assert.assertEquals("consultant Details added successfully", AlertText);
		          alert.accept();
		         Thread.sleep(3000);
	  		       
	  		}
	  	
}


