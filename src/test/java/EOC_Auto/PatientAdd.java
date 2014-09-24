package EOC_Auto;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Object;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLXML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.read.biff.Record;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PatientAdd  {
	
DataProv datap = new DataProv();
	
	private WebDriver driver = new FirefoxDriver();
	
    @BeforeTest
    public void setup() throws InterruptedException
    {
    	driver.get("http://192.168.1.240:8800/indira_p/eoc");
    	//driver.get("https://ortho-demo.imeddoc.net/Login");
    	driver.manage().window().maximize();
    	
    	driver.findElement(By.id("username")).clear();
  	  	driver.findElement(By.id("username")).sendKeys("admin");
  	  	driver.findElement(By.id("password")).clear();
  	  	driver.findElement(By.id("password")).sendKeys("a");
  	  	driver.findElement(By.id("btLogin")).click();
  	  	//Selecting Patients
  	  	//driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]")).click();
  	  driver.findElement(By.xpath("/html/body/div[3]/div[2]")).click();
  	  
  	WebDriverWait wait = new WebDriverWait(driver,10);
	  	wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_header_patient")));
	  	driver.findElement(By.className("cls_header_patient")).click();
	  	 Thread.sleep(2000);  
  	  	
	  	//driver.findElement(By.id("BtnSearch")).click();
    }
    
    @DataProvider(name = "data-provider", parallel = false)
	public Object[][] data() throws Exception {
		Object[][] retObjArr=datap.getTableArray("C:\\QAA\\PatientDetails.xls",2);
        return(retObjArr);
        
	}
	
    @Test(dataProvider="data-provider")	
  public void add(String title,String fname,String sname,String addr1,String addr2,String addr3,String addr4,String pcode,String hno,String wno,String mno,String email,String href,String nhsno,String gpname,String largn,String gen,String dob,String mstatus,String dec,String cause,String follow,String cdate,String notes,String kname,String rship,String kno,String kaddr,String kcode,String occu,String lang) throws InterruptedException, BiffException, IOException {
    	//int l=0;
    	//try
    	//{
    	driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[8]/a/img")).click();
    	Thread.sleep(2000);    		
    	driver.findElement(By.id("BtnSearch")).click();
    	Thread.sleep(2000);
	  	Select ptitle = new Select(driver.findElement(By.id("title")));
	  	ptitle.selectByVisibleText(title);
	  	//driver.findElement(By.id("title")).sendKeys("Mr");
	    driver.findElement(By.id("first_name")).sendKeys(fname);
	  	driver.findElement(By.id("sur_name")).sendKeys(sname);
	  	//verifyText display_name
	  	driver.findElement(By.id("address1")).sendKeys(addr1);
	  	driver.findElement(By.id("address2")).sendKeys(addr2);
	  	driver.findElement(By.id("address3")).sendKeys(addr3);
	  	driver.findElement(By.id("address4")).sendKeys(addr4);
	  	driver.findElement(By.id("postal_code")).sendKeys(pcode);
	  	driver.findElement(By.id("home_phone_no")).sendKeys(hno);
      	driver.findElement(By.id("work_phone_no")).sendKeys(wno);
      	driver.findElement(By.id("mobile_no")).sendKeys(mno);
    	driver.findElement(By.id("email_id")).sendKeys(email);
    	driver.findElement(By.id("hospital_ref")).sendKeys(href);
    	driver.findElement(By.id("nhs_no")).sendKeys(nhsno);
    	//driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[4]/img")).click();
    	//Thread.sleep(2000);
    	
    /*	 WebElement revlist = driver.findElement(By.className("flex_contact_select"));
 	  	List<WebElement> tagname3 = revlist.findElements(By.tagName("tr"));
 	  	Reporter.log("size of the GP list "+tagname3.size(),true);
    	 
 	  	int k =1;    
		for(WebElement rlist : tagname3){
			Thread.sleep(3000);
			 Actions action2 = new Actions(driver);
	    	 WebElement element2 = rlist.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[5]/table/tbody/tr["+k+"]/td[2]/div"));
	    	 String rname=rlist.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[5]/table/tbody/tr["+k+"]/td[2]/div")).getText();
	    	 String rdate=rlist.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[5]/table/tbody/tr["+k+"]/td[2]/div")).getText();
	    	 Reporter.log("Review Name="+rname+"Review date="+rdate,true);
	    	 
	    	 if(rname.equals(gpname))
	    	 {
	    		 
	    		 Action doubleClick2 = action2.doubleClick(element2).build();
		    	 doubleClick2.perform();// After performing double click Map will load
		    	 break;
		    	 }
	    	 k++;
	    	 
		}*/
    	   	
    	driver.findElement(By.name("living_arragements")).sendKeys(largn);
    	driver.findElement(By.name("cmb_gender")).sendKeys(gen);
    	driver.findElement(By.id("birth_date")).click();
    	driver.findElement(By.id("birth_date")).sendKeys(dob);
    	driver.findElement(By.name("marital_status")).sendKeys(mstatus);
    	driver.findElement(By.name("deceased")).click();
    	driver.findElement(By.id("txt_deceased")).sendKeys(dec);
    	driver.findElement(By.id("death_cause")).sendKeys(cause);
    	driver.findElement(By.name("followup_status")).sendKeys(follow);
    	driver.findElement(By.id("change_date")).click();;
    	driver.findElement(By.id("change_date")).sendKeys(cdate);
    	driver.findElement(By.id("notes")).sendKeys(notes);
    	driver.findElement(By.id("txt_name")).sendKeys(kname);
    	driver.findElement(By.id("txt_relationship")).sendKeys(rship);
    	driver.findElement(By.id("txt_telphone_no")).sendKeys(kno);
    	driver.findElement(By.id("txt_address")).sendKeys(kaddr);
    	driver.findElement(By.id("txt_postal_code")).sendKeys(kcode);
    	driver.findElement(By.id("occupation")).sendKeys(occu);
    	driver.findElement(By.name("patient_languageid")).sendKeys(lang);
    	Thread.sleep(1000);
    	System.out.println("Saving");
    	driver.findElement(By.id("cmd_patient_det_save")).click();
    	Thread.sleep(2000);
    	
    	    	    	       	    
    	//try
    	//{
	       // Alert alerta = driver.switchTo().alert();
	      //   String AlertTexta = alerta.getText();
	      //   System.out.println("Alert Text On Save"+AlertTexta);
	       //  Reporter.log("Alert Text On Save"+AlertTexta);
	         
	      /* //Declare the name of the Excel file
	         FileOutputStream exlFileName= new FileOutputStream("D:\\QAA\\Patient_outout.xls");

	         //making the instance of a Writable Excel workbook and giving it a Name
	         WritableWorkbook exlWorkBook = Workbook.createWorkbook(exlFileName);

	         //Creating Writable worksheets in the writable workbook
	         WritableSheet exlWorkSheet = exlWorkBook.createSheet("sheet num 0", 0);

	         //Creating content for a cell in the excel workbook
	         Label cellContent = new Label(0,l,AlertTexta);

	         //Adding a cell and inserting content in the cell.
	         exlWorkSheet.addCell(cellContent);

	         //Confirm the writing in the excel i.e. Write in the excel workbook.
	         exlWorkBook.write();

	         //Close the workbook
	         exlWorkBook.close();
	         l++;*/
	         
	         
	        // if(!AlertTexta.isEmpty())
	         
	        // {
	        //	 alerta.accept();
	        //	 driver.findElement(By.id("cmd_patient_det_cancel")).click();
	        //	 Thread.sleep(1000);
	           	 //System.out.println("Entered if loop");
	        	      	 
	        // }
    	//}catch(Exception e2)
    	
	         {//System.out.println("Entered else loop");
	        	/* driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/div/div/div/ul/li/a/span")).click();
	         	Thread.sleep(1000);
	         	driver.findElement(By.id("cmd_patient_det_delete")).click();
	         	driver.findElement(By.id("btn-ok")).click();
	           	Thread.sleep(2000);
	         	Alert alert2 = driver.switchTo().alert();
		         String AlertText2 = alert2.getText();
		         System.out.println(AlertText2);
		         Assert.assertEquals("Patient Details deleted successfully", AlertText2);
		          alert2.accept();*/
		          			          
		         // Thread.sleep(1000);
	         }
    //	}catch(Exception ee){}
    	//l++;
    	
    	}
  
}



