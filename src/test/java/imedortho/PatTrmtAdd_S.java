package imedortho;

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

public class PatTrmtAdd_S {
	DataProviderAdd datap = new DataProviderAdd();
  private WebDriver driver;
  @Test
  public void add() throws Exception {
	
	  String a[][]= datap.getTableArray("C:\\QA\\inputdata.xls",1);

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
	  	wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_header_patient")));
	  	driver.findElement(By.className("cls_header_patient")).click();
	  	Thread.sleep(500);
	  	driver.findElement(By.id("SearchBox")).click();
	  	driver.findElement(By.id("SearchBox")).sendKeys("g");
	  	driver.findElement(By.className("btnStudySearch")).click();
	  	Thread.sleep(500);
	  	
	  	WebElement table = driver.findElement(By.className("flex_patient"));
	  	List<WebElement> tagname1 = table.findElements(By.tagName("tr"));
	  	
	  	
		Reporter.log("size of the list "+tagname1.size(),true);
		int i =1;    
		for(WebElement li : tagname1){

	    	
	    	 	    	 
			Thread.sleep(3000);
				 Actions action = new Actions(driver);
		    	 WebElement element = li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+i+"]/td/div"));
		    	 String sd=li.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+i+"]/td/div")).getText();
		    	 Reporter.log("SD="+sd+"-------------",true);
		    	 i++;
		    	 if(sd.matches("Gogarty"))
		    	 {
		    		 Reporter.log("SD="+sd,true);
		    	  Action doubleClick = action.doubleClick(element).build();
		    	 doubleClick.perform();// After performing double click Map will load
		    	 
		    	 wait.until(ExpectedConditions.elementToBeClickable(By.className("clsapp_pat_treatment")));		    	 
		    	 driver.findElement(By.className("clsapp_pat_treatment")).click();
		    	 
		    	 Thread.sleep(3000);
		 	  	driver.findElement(By.className("add")).click();
		 	  	Thread.sleep(3000);
		 	  	Select bpart = new Select(driver.findElement(By.id("body_part")));
		 	  	bpart.selectByVisibleText(a[0][1]);
		 	  	Select bside = new Select(driver.findElement(By.id("side")));
		 	  	bside.selectByVisibleText(a[0][2]);
		 	  	Select trmt1 = new Select(driver.findElement(By.id("treatment")));
		 	  	trmt1.selectByVisibleText(a[0][3]);
		 	  	driver.findElement(By.id("start_date")).click();
		 	  	driver.findElement(By.id("start_date")).sendKeys(a[0][4]);;
		 	  	Select prev = new Select(driver.findElement(By.id("primary_revision")));
		 	  	prev.selectByVisibleText(a[0][5]);
		 	  	Select stype = new Select(driver.findElement(By.id("sub_type")));
		 	  	stype.selectByVisibleText(a[0][6]);
		      	driver.findElement(By.id("primary_op_consultant")).sendKeys(a[0][7]);
		      	Select cons = new Select(driver.findElement(By.id("consultant")));
		 	  	cons.selectByVisibleText(a[0][8]);
		 	  	driver.findElement(By.id("principle_diagonsis")).sendKeys(a[0][9]);
		 	  	//Select pdiag = new Select(driver.findElement(By.className("dhx_combo_box")));
		 	  	//pdiag.selectByVisibleText("Left Lateral Meniscal Tear");
		 	  	driver.findElement(By.id("secondary_diagonsis")).sendKeys(a[0][10]);
		 	  	//Select sdiag = new Select(driver.findElement(By.className("dhx_combo_box")));
		 	  	//sdiag.selectByVisibleText("Right Lateral Menical Cyst");
		 	  	driver.findElement(By.id("teritiary_diagnosis")).sendKeys(a[0][11]);
		 	  	//Select tdiag = new Select(driver.findElement(By.className("dhx_combo_box")));
		 	  	//tdiag.selectByVisibleText("Torn Right Anterior Cruciate Ligament");
		 	  	Select ostatus = new Select(driver.findElement(By.id("outcome_status")));
		 	  	ostatus.selectByVisibleText(a[0][12]);
		 	  	driver.findElement(By.id("status_date")).click();
		 	  	driver.findElement(By.id("status_date")).sendKeys(a[0][13]);
		 	  	Select oreason = new Select(driver.findElement(By.id("op_rev_reason")));
		 	  	oreason.selectByVisibleText(a[0][14]);
		 	  	Select lcomp = new Select(driver.findElement(By.id("looser_component")));
		 	  	lcomp.selectByVisibleText(a[0][15]);
		 	  	
		 	  	driver.findElement(By.id("odep_study")).sendKeys(a[0][16]);
		 	  	driver.findElement(By.id("other_studies")).sendKeys(a[0][17]);
		 	  	driver.findElement(By.id("ex_sys_id")).sendKeys(a[0][18]);
		 	  	driver.findElement(By.id("consent_taken")).click();
		 	  	driver.findElement(By.id("consent_taken")).sendKeys(a[0][19]);;
		 	  	driver.findElement(By.id("consent_by")).sendKeys(a[0][20]);
		 	  	driver.findElement(By.id("comments")).sendKeys(a[0][21]);
		 	  	driver.findElement(By.id("cmd_treatment_save")).click();
		 	  	break;
		    	 

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

