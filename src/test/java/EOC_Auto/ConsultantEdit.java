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
import org.testng.annotations.Test;

public class ConsultantEdit {
	DataProviderAdd datap = new DataProviderAdd();
  @Test 
  public void add() throws Exception {
	  WebDriver driver = new FirefoxDriver();
	  	driver.get("http://192.168.1.240:8800/indira_p/eoc");
	  	String a[][]= datap.getTableArray("C:\\QA\\inputdata.xls",3);
	  	int row=a.length;
	  	int col=a[0].length;
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
	  	
	  	for(int i=1;i<=row;i++)
	  	{
	  		int j=0;
	  			driver.findElement(By.className("opn_surgeon")).click();
	  		  	Thread.sleep(2000);
	  		  	driver.findElement(By.className("add")).click();
	  		  	Thread.sleep(1000);
	  		  	
	  		  	driver.findElement(By.id("consultant_id")).sendKeys(a[i][j]);
	  		  	Select ptitle = new Select(driver.findElement(By.id("title_id")));
	  		  	ptitle.selectByVisibleText(a[i][j+1]);
	  		  	driver.findElement(By.id("fore_name")).sendKeys(a[i][j+2]);
	  		  	driver.findElement(By.id("sur_name")).sendKeys(a[i][j+3]);
	  		  	driver.findElement(By.id("display_name")).click();
	  		  	String dname=driver.findElement(By.id("display_name")).getAttribute("value");
	  		  	System.out.println("dname="+dname);
	  		  	String dname1=a[i][j+2].concat(","+a[i][j+3]);
	  		  System.out.println("dname1="+dname1);
	  		   	driver.findElement(By.id("address1")).sendKeys(a[i][j+4]);
	  		  	driver.findElement(By.id("address2")).sendKeys(a[i][j+5]);
	  		  	driver.findElement(By.id("address3")).sendKeys(a[i][j+6]);
	  		  	driver.findElement(By.id("city")).sendKeys(a[i][j+7]);
	  		  	driver.findElement(By.id("phone")).sendKeys(a[i][j+8]);
	  		  	driver.findElement(By.id("email_id")).sendKeys(a[i][j+9]);
	  		  	driver.findElement(By.id("fax")).sendKeys(a[i][j+10]);
	  		  	driver.findElement(By.id("secretary")).sendKeys(a[i][j+11]);
	  		  	driver.findElement(By.id("chk_uc_study_1")).click();
	  		  	driver.findElement(By.id("surgeon_status")).sendKeys(a[i][j+14]);
	  		  Assert.assertEquals(dname,dname1);	
	  		  	driver.findElement(By.id("cmd_opn_surgeon_save")).click();
	  		  	
	  		  Alert alert = driver.switchTo().alert();
		         String AlertText = alert.getText();
		         System.out.println(AlertText);
		         Assert.assertEquals("consultant Details updated successfully", AlertText);
		          alert.accept();
		         Thread.sleep(3000);
	  		       
	  		}
	  	
	   }
}

//Yet to complete
