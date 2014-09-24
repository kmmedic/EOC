package EOC_Auto;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class yuvisirtest {
	DataProviderAdd datap = new DataProviderAdd();
	//BaselineAssessmentHip bhip=new BaselineAssessmentHip();
	WebDriver driver = new FirefoxDriver();
	@BeforeTest
	public void setup()
	{
		
	  	driver.get("http://192.168.1.240:8800/indira_p/eoc");
	  	driver.manage().window().maximize();
	}
   @Test
  public void add() throws Exception {
	
	  String a[][]= datap.getTableArray("C:\\QA\\PatTrmtList.xls",0);

	  
	  	
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
	  	driver.findElement(By.id("SearchBox")).sendKeys("test");
	  	driver.findElement(By.className("btnStudySearch")).click();
	  	Thread.sleep(500);
	  	
	  	WebElement table = driver.findElement(By.className("flex_patient"));
	  	List<WebElement> tagname1 = table.findElements(By.tagName("tr"));
	  	
	  	
		Reporter.log("size of the list "+tagname1.size(),true);
		int i =1; 
		int row=1;
		int col=0;
		for(WebElement li : tagname1){

	    	
	    	 	    	 
			Thread.sleep(3000);
				 Actions action = new Actions(driver);
		    	 WebElement element = li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+i+"]/td/div"));
		    	 String sd=li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+i+"]/td/div")).getText();
		    	 Reporter.log("SD="+sd+"-------------",true);
		    	  if(sd.matches(a[row][col]))
		    	 {
		    		 Reporter.log("SD="+sd,true);
		    	  Action doubleClick = action.doubleClick(element).build();
		    	 doubleClick.perform();// After performing double click Map will load
		    	 
		    	 wait.until(ExpectedConditions.elementToBeClickable(By.className("clsapp_pat_treatment")));		    	 
		    	 driver.findElement(By.className("clsapp_pat_treatment")).click();
		    	 
		    	 //Getting list of treatment under treatment tab
		    	 Thread.sleep(3000);
		    	 WebElement trmtlist = driver.findElement(By.className("flex_treatment"));
		 	  	List<WebElement> tagname2 = trmtlist.findElements(By.tagName("tr"));
		 	  	Reporter.log("size of the treatment list "+tagname2.size(),true);
		    	 
		 	  	int j =1;    
				for(WebElement tlist : tagname2){
		    	 //driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div/div[7]/table/tbody/tr["+i+"]/td[3]/div")).click();
		    	 
		    	 Thread.sleep(3000);
				 Actions action1 = new Actions(driver);
		    	 WebElement element1 = tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div/div[7]/table/tbody/tr["+j+"]/td[3]/div"));
		    	 String tname=tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div/div[7]/table/tbody/tr["+j+"]/td[3]/div")).getText();
		    	 String tdate=tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div/div[7]/table/tbody/tr["+j+"]/td[2]/div")).getText();
		    	 Reporter.log("Treatment Name="+tname+"Treatment date="+tdate,true);
		    	 String[] tt=tname.split("  ");
		    	 int len=tt.length;
		    	 Reporter.log("Length of array="+len,true);
		    	 
		    	if(tdate.matches(a[row][col+2]) && tname.matches(a[row][col+1]))
		    	 {
		    		 //Reporter.log("SD="+sd,true);
		    	  Action doubleClick1 = action1.doubleClick(element1).build();
		    	 doubleClick1.perform();// After performing double click Map will load
		    	 
		    	 wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_reviews")));		    	 
		    	 driver.findElement(By.className("cls_reviews")).click();
		    	 
		    	 //Getting list of reviews under review tab
		    	 Thread.sleep(3000);
		    	 WebElement revlist = driver.findElement(By.className("flex_treat_review"));
		 	  	List<WebElement> tagname3 = revlist.findElements(By.tagName("tr"));
		 	  	Reporter.log("size of the review list "+tagname3.size(),true);
		    	 
		 	  	int k =1;    
				for(WebElement rlist : tagname3){
					Thread.sleep(3000);
					 Actions action2 = new Actions(driver);
			    	 WebElement element2 = rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div"));
			    	 String rname=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getText();
			    	 String rdate=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[2]/div")).getText();
			    	 Reporter.log("Review Name="+rname+"Review date="+rdate,true);
			    	 
			    	 if(rname.equals("Pre-operative Assessment"))
			    	 {
			    		 Action doubleClick2 = action2.doubleClick(element2).build();
				    	 doubleClick2.perform();// After performing double click Map will load
				    	 Thread.sleep(3000);
				    	 //bhip.baselinehip();
				    	 BaselineAssessmentHip bb=new BaselineAssessmentHip();
				    	// bb.baselinehip();
				    	 		    		   		 
			    	 }//end of review IF loop
			    	 k++;
		    	 
		    	 
				}//end of review list FOR loop
				
		  	 }//end of treatment list IF loop*/
		    	j++;
				}//end of treatment list FOR loop
		    	 
		    	 break;
		    	 }//end of patient if loop
		    	  i++;
		}//end of patient list for loop
				    	 }
}


