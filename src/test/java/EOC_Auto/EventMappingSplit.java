package EOC_Auto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

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

public class EventMappingSplit {
	DataProviderAdd datap = new DataProviderAdd();
	
  //@Test(dataProvider="data-provider")
	@Test
  
  public void add() throws Exception {
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
	  	driver.findElement(By.className("opn_form_mapping")).click();
	  	Thread.sleep(2000);
	  	
	  	String psize=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[8]/div/div/div[2]/span/span")).getText();
	  	Reporter.log("size of the page "+psize,true);
	  	
	  	int loop=1;
	  	int pno=1;
	  	while(pno<=3)
	  	{
	  		
	  	//List<WebElement> liElements = driver.findElements(By.className("flex_patient"));
	  		WebElement table = driver.findElement(By.className("flex_opn_forms_mapping"));
		  	List<WebElement> tagname1 = table.findElements(By.tagName("tr"));
		  	
		Reporter.log("size of the list "+tagname1.size(),true);
		int i =1;    
		
		//for(WebElement li : tagname1){
		 for(int j=1;j<=tagname1.size();j++){
			 
   	 	    	 
			Thread.sleep(3000);
				 Actions action = new Actions(driver);
		    	 WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[4]/div"));
		    	 driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[4]/div")).click();;
		    	 String bpart=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[2]/div")).getText();
		    	 String trmt=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[3]/div")).getText();
		    	 String review=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[4]/div")).getText();
		    	 String status=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[5]/div")).getText();
		    	 String study=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[6]/div")).getText();
		    	 Reporter.log("SD="+review+"-------------",true);
		    	 
		    	 
		    	 File excelFile = new File("C:\\QA\\eventmapping.xls");

		         WritableWorkbook book;
		         WritableSheet sheet;
		         Workbook existingBook = null;

		         if (!excelFile.exists()) {
		             book = Workbook.createWorkbook(excelFile);
		             sheet = book.createSheet("TESTRESULTS", 0);
		         } else {
		             existingBook = Workbook.getWorkbook(excelFile);
		             book = Workbook.createWorkbook(excelFile, existingBook);
		             sheet = book.getSheet(0);
		         }

		         Label bpart_cell = new Label(0,loop,bpart);
		         sheet.addCell(bpart_cell);
		         Label trmt_cell = new Label(1,loop,trmt);
		         sheet.addCell(trmt_cell);
		         Label review_cell = new Label(2,loop,review);
		         sheet.addCell(review_cell);
		         Label status_cell = new Label(3,loop,status);
		         sheet.addCell(status_cell);
		         Label study_cell = new Label(4,loop,study);
		         sheet.addCell(study_cell);
		         
		         
		         //OPening the event mapping record		    	 
		    	 List<WebElement> lelement = driver.findElements(By.className("flex_opn_forms_mapping"));
		    	 WebElement element1 = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+i+"]/td[3]/div"));	
      	    	 Action doubleClick = action.doubleClick(element1).build();
		    	 doubleClick.perform();
		    	 Thread.sleep(2000);
		    	 
		    	 //Getting forms mapped to the particular review
		    	 String sforms;
		    	 int jj=1;
		    	 int fno=6;
		    	 try
	    		 {
		    	 do
		    	 {	 
		    		 
		    	  sforms=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td/table/tbody/tr[2]/td[3]/select/optgroup/option["+jj+"]")).getText();
		    	   Reporter.log("Forms Selected Are="+sforms,true);
		    	   Label formlist = new Label(fno,loop,sforms);
			         sheet.addCell(formlist);
		    	   fno++;
		    	   jj++;
		    		 
		    	 }while(sforms!="");
		    	 }catch (Exception e){};//Ending the form list here
		    	 String jw= String.valueOf(jj);
		    	 Label formlist = new Label(5,loop,jw);
		         sheet.addCell(formlist);
		    	 
		    	 driver.findElement(By.id("cmd_opn_forms_mapping_cancel")).click();
		    	 Thread.sleep(2000);
		    	 
		    	 loop++;
		         book.write();
		         book.close();
		    	 
		    	 i++;
		    	 
	       
	   }//End of FOR loop
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[8]/div/div/div[3]/div/span")).click();
		
	   pno++;
	  	}//ENd of WHILE loop
}
 

}



