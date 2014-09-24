package nn.EOC;

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

public class OptionReviewEdit {
  private WebDriver driver;
  @Test
  public void add() throws InterruptedException, BiffException, IOException {
	  FileInputStream fi=new FileInputStream("C:\\QA\\inputdata.xls");
	   Workbook w=Workbook.getWorkbook(fi);
	   Sheet s=w.getSheet(1);
	   String a[][] = new String[s.getRows()][s.getColumns()];
	   int row=s.getRows();
	 //for all input sheet rows, write to new Results workbook with Result column appended
	   for (int i = 0; i < s.getRows(); i++)
	   {
	   //System.out.println("Current row: " + i + " reading s.getColumns: " + s.getColumns());
	   // for all inputsheet columns
	   for (int j = 0; j < s.getColumns(); j++)
	   {
	   	a[i][j] = s.getCell(j,i).getContents();
	   	  
	  // System.out.println("Value Of i is "+i+"Value of j is "+j+"Value of A is "+a[i][j]);
	   }
	   }

	    driver = new FirefoxDriver();
	  	driver.get("http://192.168.1.240:8800/indira_p/eoc");
	  	driver.manage().window().maximize();
	  	
	 //try{
		 
	 
	  	driver.findElement(By.id("username")).clear();
	  	driver.findElement(By.id("username")).sendKeys("admin");
	  	driver.findElement(By.id("password")).clear();
	  	driver.findElement(By.id("password")).sendKeys("a");
	  	driver.findElement(By.id("btLogin")).click();
	  	//Selecting Patients
	  	driver.findElement(By.className("StudyText")).click();
	  	WebDriverWait wait = new WebDriverWait(driver,05);
	  	wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_header_options")));
	  	driver.findElement(By.className("cls_header_options")).click();
	  	Thread.sleep(500);
	  	driver.findElement(By.className("opn_surgeon")).click();
	  	
	  	WebElement table = driver.findElement(By.className("flex_opn_surgeon"));
	  	List<WebElement> tagname1 = table.findElements(By.tagName("tr"));
	  	
	  	
		//List<WebElement> liElements = driver.findElements(By.className("flex_patient"));
		Reporter.log("size of the list "+tagname1.size(),true);
		int i =1;    
		for(WebElement li : tagname1){
//		    	 String temp1 = li.getAttribute("class");
//		    	 String temp = li.getText();
//		    	 Reporter.log("Class in li --- "+temp1,true);
//				 Reporter.log("Text in li --- "+temp,true);
//				 Reporter.log("-------------",true);
				 
				 //if(temp.equals("testpatienta")==true)
				 //wait.until(ExpectedConditions.elementToBeSelected(By.className("flex_patient")));
				 //{
			
//	    	 String temp1 = li.getAttribute("class");
	    	
	    	 	    	 
			Thread.sleep(3000);
				 Actions action = new Actions(driver);
		    	 WebElement element = li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[2]/div"));
		    	 String sd=li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[2]/div")).getText();
		    	 Reporter.log("SD="+sd+"-------------",true);
		    	 i++;
		    	 if(sd.matches("testsarconsult"))
		    	 {
		    		 Reporter.log("SD="+sd,true);
		    	  Action doubleClick = action.doubleClick(element).build();
		    	 doubleClick.perform();// After performing double click Map will load
		    	 wait.until(ExpectedConditions.elementToBeClickable(By.id("address1")));
		    	 driver.findElement(By.id("address1")).sendKeys("addr1");
		    	 
		    	 driver.findElement(By.id("cmd_opn_surgeon_save")).click();
		    	 
		    	 Alert alert = driver.switchTo().alert();
		         String AlertText = alert.getText();
		         System.out.println(AlertText);
		         Assert.assertEquals("consultant Details updated successfully", AlertText);
		          alert.accept();
		         Thread.sleep(3000);
		    	 
				
//		   if(temp1.equals("py")){
//		   futurebroadcast = futurebroadcast+1;
	   }//if loop ends here
				 }
		   
//	 }catch (Exception e){
//		 e.printStackTrace();
//	 }
	   }
//  @AfterMethod
//  public void closeConn(){
//	  driver.quit();
//  }
}

