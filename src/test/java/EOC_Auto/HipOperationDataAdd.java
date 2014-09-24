
package EOC_Auto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HipOperationDataAdd {
	
	DataProviderAdd datap = new DataProviderAdd();
	
	private WebDriver driver = new FirefoxDriver();
	
    @BeforeTest
    public void setup()
    {
    	driver.get("http://192.168.1.246/main");
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
  			    	 
  			    	 if(rname.equals("Inpatient Stay"))
  			    	 {
  			    		 String colort=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
  			    		 Reporter.log("Color="+colort,true);
  			    		 //assertEquals(colort,"rgb(255, 0, 0)");
  			    		 Action doubleClick2 = action2.doubleClick(element2).build();
  				    	 doubleClick2.perform();// After performing double click Map will load
  				    	 Thread.sleep(3000);
  				    	 
  				    	String euroq = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Hip Operation Data')]";
				    	 WebElement euroyes = driver.findElement(By.xpath(euroq));
						  euroyes.click();
  				    	
  				    	String b[][]= datap.getTableArray("C:\\QA\\HipOperationData.xls",0);
  				      int brow=1;
  				      int bcol=0;
  				      Thread.sleep(2000);
  				        					  
                    //Evaluation Date
  				    driver.findElement(By.id("eval_date")).click();
  				      driver.findElement(By.id("eval_date")).sendKeys(b[brow][bcol+77]);
  				     //Operation desc 
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/span/div/input")).sendKeys(b[brow][bcol]);
		            //Code
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[2]/td/table/tbody/tr/td[2]/span")).click();
  					driver.findElement(By.id("code")).sendKeys(b[brow][bcol+1]);
  					//Op indication
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+2]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span")).click();
  					//Admission date
  					driver.findElement(By.id("admission_date")).click();
  					driver.findElement(By.id("admission_date")).sendKeys(b[brow][bcol+1+3]);
  					//Discharge date
  					driver.findElement(By.id("discharge_date")).click();
  					driver.findElement(By.id("discharge_date")).sendKeys(b[brow][bcol+4]);
  					
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[2]/a")).click();
  					//Hospital
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/span/div/input")).sendKeys(b[brow][bcol+5]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/span")).click();
  				    //Lead Surgeon
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+6]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/span")).click();
  					//Lead grade
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+7]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span")).click();
  					//2nd lead
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(b[brow][bcol+8]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/span")).click();
  					//2nd grade
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/span/div/input")).sendKeys(b[brow][bcol+9]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/span")).click();
  					//1st asst
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/span/div/input")).sendKeys(b[brow][bcol+10]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/span")).click();
  					//2nd asst
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(b[brow][bcol+11]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/span")).click();
  					//1st aneasthetist
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/span/div/input")).sendKeys(b[brow][bcol+12]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/span")).click();
  					//2nd aneasthetist
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[10]/td[2]/span/div/input")).sendKeys(b[brow][bcol+13]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td/table/tbody/tr[10]/td[2]/span")).click();
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[3]/a")).click();
  					//Anaesthetis st time
  					driver.findElement(By.id("anathetist_start_time")).clear();
  					driver.findElement(By.id("anathetist_start_time")).sendKeys(b[brow][bcol+14]);
  					//Anaesthetist end time
  					driver.findElement(By.id("anathetist_end_time")).clear();
  					driver.findElement(By.id("anathetist_end_time")).sendKeys(b[brow][bcol+15]);
  					//Surgery st time
  					driver.findElement(By.id("surgery_start_time")).clear();
  					driver.findElement(By.id("surgery_start_time")).sendKeys(b[brow][bcol+16]);
  					//Surgery end time
  					driver.findElement(By.id("surgery_end_time")).clear();
  					driver.findElement(By.id("surgery_end_time")).sendKeys(b[brow][bcol+17]);
  					//Antibiotics
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+18]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span")).click();
  					//Dose
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]/span/div/input")).sendKeys(b[brow][bcol+19]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[4]/span")).click();
  					//Patient position
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/span/div/input")).sendKeys(b[brow][bcol+20]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/span")).click();
  					//Surgical Approach
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td/table/tbody/tr/td[4]/span/div/input")).sendKeys(b[brow][bcol+21]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td/table/tbody/tr/td[4]/span")).click();
  					//Reduction
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+22]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/span")).click();
  					//Patient catheterised
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+23]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/span")).click();
  					//Findings
  					driver.findElement(By.id("findings_desc")).sendKeys(b[brow][bcol+24]);
  					driver.findElement(By.id("preop_blood_loss")).sendKeys(b[brow][bcol+25]);
  					driver.findElement(By.id("postop_blood_loss")).sendKeys(b[brow][bcol+26]);
  					Select perop = new Select(driver.findElement(By.id("perop_units")));
					perop.selectByVisibleText(b[brow][bcol+27]);
					Select postop = new Select(driver.findElement(By.id("postop_units")));
					postop.selectByVisibleText(b[brow][bcol+28]);  
  					driver.findElement(By.id("preop_hb")).sendKeys(b[brow][bcol+29]);
  					driver.findElement(By.id("postop_hb")).sendKeys(b[brow][bcol+30]);
					
					//Deep layer
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr/td[2]/span/div/input")).sendKeys(b[brow][bcol+31]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr/td[2]/span")).click();
  					//Fascia lata
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr/td[4]/span/div/input")).sendKeys(b[brow][bcol+32]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr/td[4]/span")).click();
  					//Skin
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+33]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr[2]/td[2]/span")).click();
  					//Suture
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr[2]/td[4]/span/div/input")).sendKeys(b[brow][bcol+34]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr[2]/td[4]/span")).click();
  					//Subcutaneous fat
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+35]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr[3]/td[2]/span")).click();
  					//Noofdrains
  					Select ndrains = new Select(driver.findElement(By.id("no_of_drains")));
  					ndrains.selectByVisibleText(b[brow][bcol+36]);
  					//Dressings
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(b[brow][bcol+37]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td/table/tbody/tr[4]/td[2]/span")).click();
  					//Mobilise
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr/td[2]/span/div/input")).sendKeys(b[brow][bcol+38]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr/td[2]/span")).click();
  					//Check x-rays
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+39]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[2]/td[2]/span")).click();
  					//Remove sutures
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+40]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[3]/td[2]/span")).click();
  					//Thrombo name
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[5]/td[2]/span/div/input")).sendKeys(b[brow][bcol+41]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[5]/td[2]/span")).click();
  					//Thrombo dose
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[5]/td[3]/span/div/input")).sendKeys(b[brow][bcol+42]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[5]/td[3]/span")).click();
  					//Thrombo freq
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[5]/td[4]/span/div/input")).sendKeys(b[brow][bcol+43]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[5]/td[4]/span")).click();
  					//Thrombo duration
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[5]/td[5]/span/div/input")).sendKeys(b[brow][bcol+44]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[5]/td[5]/span")).click();
  					//Antibiotics Name
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(b[brow][bcol+45]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[6]/td[2]/span")).click();
  					//Antibiotics dose
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[6]/td[3]/span/div/input")).sendKeys(b[brow][bcol+46]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[6]/td[3]/span")).click();
  					//Antibiotics freq
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[6]/td[4]/span/div/input")).sendKeys(b[brow][bcol+47]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[6]/td[4]/span")).click();
  					//Antibiotics duration
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[6]/td[5]/span/div/input")).sendKeys(b[brow][bcol+48]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td/table/tbody/tr[6]/td[5]/span")).click();
  					//Implants
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[4]/a")).click();
  					//Acetabular condition
  					driver.findElement(By.id("acetabular_condition")).sendKeys(b[brow][bcol+49]);
  					//Acetaular reemed to
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(b[brow][bcol+50]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/span")).click();
  					//Component Type
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(b[brow][bcol+51]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/span")).click();
  					//screws
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/span/div/input")).sendKeys(b[brow][bcol+52]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[2]/span")).click();
  					//Bearing diameter
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(b[brow][bcol+53]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[8]/td[2]/span")).click();
  					//Drill holes
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/span/div/input")).sendKeys(b[brow][bcol+54]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]/span")).click();
  					//Graft
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+55]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/span")).click();
  					//Acetabular Fixation
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[4]/span/div/input")).sendKeys(b[brow][bcol+56]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[4]/td[4]/span")).click();
  					//Implant Manufacturer 
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[4]/span/div/input")).sendKeys(b[brow][bcol+57]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[5]/td[4]/span")).click();
  				    //Outer diameter
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[4]/span/div/input")).sendKeys(b[brow][bcol+58]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[4]/span")).click();
  				    //Bearing 
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[4]/span/div/input")).sendKeys(b[brow][bcol+59]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[7]/td[4]/span")).click();
  					//Cage or mesh
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[8]/td[4]/span/div/input")).sendKeys(b[brow][bcol+60]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td/table/tbody/tr[8]/td[4]/span")).click();
  					 //Notes
  					driver.findElement(By.id("acetabular_preparation")).sendKeys(b[brow][bcol+61]);
  					//Femoral condition
  					driver.findElement(By.id("femoral_condition")).sendKeys(b[brow][bcol+62]);
  					//Gt tronchater
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr/td[4]/span/div/input")).sendKeys(b[brow][bcol+63]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr/td[4]/span")).click();
  					//Femoral fixation
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(b[brow][bcol+64]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/span")).click();
  				    //No.of circlage cables
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[4]/td[4]/span/div/input")).sendKeys(b[brow][bcol+65]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[4]/td[4]/span")).click();
  					//Femoral Grafting
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[5]/td[2]/span/div/input")).sendKeys(b[brow][bcol+66]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[5]/td[2]/span")).click();
  					//Head Manufacturer
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[5]/td[4]/span/div/input")).sendKeys(b[brow][bcol+67]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[5]/td[4]/span")).click();
  				    //Modularity
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(b[brow][bcol+68]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[6]/td[2]/span")).click();
  				    //Head material
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[6]/td[4]/span/div/input")).sendKeys(b[brow][bcol+69]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[6]/td[4]/span")).click();
  					//Femoral stem type
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[7]/td[2]/span/div/input")).sendKeys(b[brow][bcol+70]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[7]/td[2]/span")).click();
  					//Head Diameter
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[7]/td[4]/span/div/input")).sendKeys(b[brow][bcol+71]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[7]/td[4]/span")).click();
  				//Stem Manufacturer
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(b[brow][bcol+72]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[8]/td[2]/span")).click();
  					//Femoral neck type
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[8]/td[4]/span/div/input")).sendKeys(b[brow][bcol+73]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[8]/td[4]/span")).click();
  					//Stem size
  					
  					Select ssize = new Select(driver.findElement(By.id("stem_size")));
  					ssize.selectByVisibleText(b[brow][bcol+74]);
  					//Head length
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[9]/td[4]/span/div/input")).sendKeys(b[brow][bcol+75]);
  					driver.findElement(By.xpath("/html/body/div[66]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td/table/tbody/tr[9]/td[4]/span")).click();
  					//Notes
  					driver.findElement(By.id("acetabular_implantation")).sendKeys(b[brow][bcol+76]);
  					//driver.findElement(By.id("operation_data_save")).click();
  					
 					 
  					break;
				    	 }
			    	 k++;
		    	   	 
				}//end of review list FOR loop
				 break;
				
		  	 }//end of treatment list IF loop*/
		    	j++;
				}//end of treatment list FOR loop
		    	 
		    	 break;
		    	 }//end of patient if loop
		    	  i++;
		}//end of patient list for loop
				    	 }
}


  



