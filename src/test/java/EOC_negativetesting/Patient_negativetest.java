package EOC_negativetesting;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EOC_Auto.DataProviderAdd;

public class Patient_negativetest {
	
	DataProviderAdd datap = new DataProviderAdd();
	
	private WebDriver driver = new FirefoxDriver();
	
    @BeforeTest
    public void setup() throws InterruptedException
    {
    	driver.get("http://192.168.1.240:8800/indira_p/eoc");
    	driver.manage().window().maximize();
    	
    	driver.findElement(By.id("username")).clear();
  	  	driver.findElement(By.id("username")).sendKeys("admin");
  	  	driver.findElement(By.id("password")).clear();
  	  	driver.findElement(By.id("password")).sendKeys("a");
  	  	driver.findElement(By.id("btLogin")).click();
  	  	//Selecting Patients
  	  	Thread.sleep(1000);
  	  	driver.findElement(By.className("StudyText")).click();
  	  	WebDriverWait wait = new WebDriverWait(driver,05);
  	  	wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_header_patient")));
  	  	driver.findElement(By.className("cls_header_patient")).click();
  	  	 Thread.sleep(2000);
	  	//driver.findElement(By.id("BtnSearch")).click();
    }
    
    @DataProvider(name = "data-provider", parallel = false)
	public Object[][] data() throws Exception {
		Object[][] retObjArr=datap.getTableArray("C:\\QAA\\PatientDetails.xls",1);
        return(retObjArr);
        
	}
	
    @Test(dataProvider="data-provider")	
  public void add(String title,String fname,String sname,String addr1,String addr2,String addr3,String addr4,String pcode,String hno,String wno,String mno,String email,String href,String nhsno,String gpname,String largn,String gen,String dob,String mstatus,String dec,String cause,String follow,String cdate,String notes,String kname,String rship,String kno,String kaddr,String kcode,String occu,String lang,String warn_alert) throws Exception {
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
    	driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/div/table/tbody/tr[3]/td[4]/img")).click();
    	Thread.sleep(2000);
    	
    	 WebElement revlist = driver.findElement(By.className("flex_contact_select"));
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
	    	 
		}
    	   	
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
    	    	       	    
    	Alert alert = driver.switchTo().alert();
        String AlertText = alert.getText();
        System.out.println(AlertText);
        Assert.assertEquals(warn_alert, AlertText);
        String res="";
       if(warn_alert.matches(AlertText))
       {
    	   res="PASS";
       }
       else
       {
    	   res="FAIL";
       }
       
         alert.accept();
        Thread.sleep(3000);
        driver.findElement(By.id("cmd_patient_det_cancel")).click();
    	Thread.sleep(1000); 
    	FileOutputStream exlFileName= new FileOutputStream("C:\\QAA\\Result.xls");

    	//making the instance of a Writable Excel workbook and giving it a Name

    	WritableWorkbook exlWorkBook = Workbook.createWorkbook(exlFileName);

    	//Creating Writable worksheets in the writable workbook

    	WritableSheet exlWorkSheet = exlWorkBook.createSheet("sheet num 0", 0);

    	//Creating content for a cell in the excel workbook

    	Label cellContent = new Label(0,0,res);

    	//Adding a cell and inserting content in the cell.

    	exlWorkSheet.addCell(cellContent);

    	//Confirm the writing in the excel i.e. Write in the excel workbook.

    	exlWorkBook.write();

    	//Close the workbook

    	exlWorkBook.close();
    	/*File o_File2=new File("C:\\QAA\\Result.txt");
        String line;
        try 
        {
            
            BufferedWriter o_bw1=null;
            if(!o_File2.exists())
            {
                o_File2.createNewFile();
            }
            o_bw1 = new  BufferedWriter(new FileWriter(o_File2) );
            
                    o_bw1.write(warn_alert+" "+res);
                                  
            
            o_bw1.close();
        }catch (Exception e) 
        {
            e.printStackTrace();
        }
    	SendMail.execute("Report_file");*/
    	try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\QAA\\Result.txt", true)));
            out.flush();
            out.println(warn_alert+" "+res);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        
    	}
    
    
    @AfterTest
    public void sendingmail() throws Exception
    {
    	SendMail.execute("Report_file");
    }
  
}



