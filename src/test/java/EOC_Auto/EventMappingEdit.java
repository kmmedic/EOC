package EOC_Auto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

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

public class EventMappingEdit {
	DataProviderAdd datap = new DataProviderAdd();
	
  //@Test(dataProvider="data-provider")
	@Test
  
  public void add() throws Exception {
	  WebDriver driver = new FirefoxDriver();
	  	driver.get("http://192.168.1.240:8800/indira_p/eoc");
	  	driver.manage().window().maximize();
	  	Thread.sleep(2000);
	  	String a[][]= datap.getTableArray("C:\\QA\\inputdata.xls",2);  
	  	int size=a.length;
	  	Reporter.log("Length="+a[0][0],true);
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
	  	
	  	
	  	
	  	WebElement table = driver.findElement(By.className("flex_opn_forms_mapping"));
	  	List<WebElement> tagname1 = table.findElements(By.tagName("tr"));
	  	
	  	
		//List<WebElement> liElements = driver.findElements(By.className("flex_patient"));
		Reporter.log("size of the list "+tagname1.size(),true);
		int i =1;    
		for(WebElement li : tagname1){
   	 	    	 
			Thread.sleep(3000);
				 Actions action = new Actions(driver);
		    	 WebElement element = li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[4]/div"));
		    	 li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[4]/div")).click();;
		    	 String bpart=li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[2]/div")).getText();
		    	 String trmt=li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[3]/div")).getText();
		    	 String review=li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[4]/div")).getText();
		    	 Reporter.log("SD="+review+"-------------",true);
		    	 i++;
		    	 if(bpart.matches("Hip") && trmt.matches("Reduction") && review.matches("6 week review")  )
		    		
		    	 {

		    	  Action doubleClick = action.doubleClick(element).build();
		    	 doubleClick.perform();// After performing double click Map will load
		    	 Thread.sleep(2000);
		    	 
		    	 String ss=driver.findElement(By.xpath("//*[@id="+"'selectedColumns_Pre'"+"]")).getText();
		    	 Reporter.log("SS="+ss,true);
		    	 
		    	 String sforms;
		    	 int j=1;
		    	 try
	    		 {
		    	 do
		    	 {	 
		    		 
		    	  sforms=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td/table/tbody/tr[2]/td[3]/select/optgroup/option["+j+"]")).getText();
		    	   Reporter.log("Forms Selected Are="+sforms,true);
		    	   j++;
		    		 
		    	 }while(sforms!="");
		    	 }catch (Exception e){};
	  	
	  	
	  	    	 }
	  		  	
	       
	   }
}
 

}



