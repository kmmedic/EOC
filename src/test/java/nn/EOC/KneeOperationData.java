
package nn.EOC;

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

public class KneeOperationData {
	
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
  		int row=2;
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
  				    	 
  				    	String euroq = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Knee Operation Data')]";
				    	 WebElement euroyes = driver.findElement(By.xpath(euroq));
						  euroyes.click();
  				    	
  				    	String b[][]= datap.getTableArray("C:\\QA\\HipOperationData.xls",1);
  				      int brow=1;
  				      int bcol=0;
  				      Thread.sleep(2000);
  				        					  
                    //Evaluation Date
  				    driver.findElement(By.id("evaluation_date")).click();
  				      driver.findElement(By.id("evaluation_date")).sendKeys(b[brow][bcol]);
  				     driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li/a")).click(); 
  				     //Operation desc 
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+1]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[2]/td[2]/span")).click();
  					
		            //Code
  					driver.findElement(By.id("op_code")).sendKeys(b[brow][bcol+2]);
  					//Op indication
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(b[brow][bcol+3]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[4]/td[2]/span")).click();
  					//Patient Position
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(b[brow][bcol+4]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[6]/td[2]/span")).click();
  					//Knee position
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[7]/td[2]/span/div/input")).sendKeys(b[brow][bcol+5]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[7]/td[2]/span")).click();
  					//Admission date
  					driver.findElement(By.id("admission_date")).click();
  					driver.findElement(By.id("admission_date")).sendKeys(b[brow][bcol+6]);
  					//Discharge date
  					driver.findElement(By.id("discharge_date")).click();
  					driver.findElement(By.id("discharge_date")).sendKeys(b[brow][bcol+7]);
  					
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[2]/a")).click();
  					//Hospital
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+8]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td[2]/span")).click();
  				    //Lead Surgeon
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+9]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[3]/td[2]/span")).click();
  					//Lead grade
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(b[brow][bcol+10]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[4]/td[2]/span")).click();
  					//2nd lead
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[5]/td[2]/span/div/input")).sendKeys(b[brow][bcol+11]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[5]/td[2]/span")).click();
  					//2nd grade
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(b[brow][bcol+12]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[6]/td[2]/span")).click();
  					//1st asst
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(b[brow][bcol+13]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[8]/td[2]/span")).click();
  					//2nd asst
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[9]/td[2]/span/div/input")).sendKeys(b[brow][bcol+14]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[9]/td[2]/span")).click();
  					//1st aneasthetist
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[10]/td[2]/span/div/input")).sendKeys(b[brow][bcol+15]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[10]/td[2]/span")).click();
  					//2nd aneasthetist
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[11]/td[2]/span/div/input")).sendKeys(b[brow][bcol+16]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[11]/td[2]/span")).click();
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[3]/a")).click();
  					//Pre-op antibiotics
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+17]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td[2]/span")).click();
  					//Dose
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td[4]/span/div/input")).sendKeys(b[brow][bcol+18]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td[4]/span")).click();
  					driver.findElement(By.id("tourniquet_time")).sendKeys(b[brow][bcol+19]);
 					//Surgical Approach
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(b[brow][bcol+20]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td[2]/span")).click();
  					//Patella preparation
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td[4]/span/div/input")).sendKeys(b[brow][bcol+21]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td[4]/span")).click();
  					//Fat pad
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[5]/td[2]/span/div/input")).sendKeys(b[brow][bcol+22]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[5]/td[2]/span")).click();
  					//Reduction
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[5]/td[4]/span/div/input")).sendKeys(b[brow][bcol+23]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[5]/td[4]/span")).click();
  					//Reduction
  					driver.findElement(By.id("findings")).sendKeys(b[brow][bcol+24]);
  					//Condition of synovium
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[7]/td[3]/span/div/input")).sendKeys(b[brow][bcol+25]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[7]/td[3]/span")).click();
  					//Condition of patello-femoral joint
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(b[brow][bcol+26]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td[2]/span")).click();
  					//Condition of PCL
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td[4]/span/div/input")).sendKeys(b[brow][bcol+27]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td[4]/span")).click();
  					//Condition of medial tib-fem joint
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[9]/td[2]/span/div/input")).sendKeys(b[brow][bcol+28]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[9]/td[2]/span")).click();
  					//Condition of ACL
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[9]/td[4]/span/div/input")).sendKeys(b[brow][bcol+29]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[9]/td[4]/span")).click();
  					//Condition of lateral tib-fem joint
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td[2]/span/div/input")).sendKeys(b[brow][bcol+30]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td[2]/span")).click();
  					//preop_blood
  					driver.findElement(By.id("preop_blood")).sendKeys(b[brow][bcol+31]);
  					driver.findElement(By.id("postop_blood")).sendKeys(b[brow][bcol+32]);
  					Select perop = new Select(driver.findElement(By.id("perop_units")));
					perop.selectByVisibleText(b[brow][bcol+33]);
					Select postop = new Select(driver.findElement(By.id("postop_units")));
					postop.selectByVisibleText(b[brow][bcol+34]);  
  					driver.findElement(By.id("preop_hb")).sendKeys(b[brow][bcol+35]);
  					driver.findElement(By.id("postop_hb")).sendKeys(b[brow][bcol+36]);
  					//Deep layer
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[16]/td[2]/span/div/input")).sendKeys(b[brow][bcol+37]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[16]/td[2]/span")).click();
  					//Suture
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[16]/td[4]/span/div/input")).sendKeys(b[brow][bcol+38]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[16]/td[4]/span")).click();
  					//Subcutaneous fat
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[17]/td[2]/span/div/input")).sendKeys(b[brow][bcol+39]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[17]/td[2]/span")).click();
  				//Noofdrains
  					Select ndrains = new Select(driver.findElement(By.id("no_of_drains")));
  					ndrains.selectByVisibleText(b[brow][bcol+40]);
  					//Skin
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[18]/td[2]/span/div/input")).sendKeys(b[brow][bcol+41]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[18]/td[2]/span")).click();
  					//Dressings
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[18]/td[4]/span/div/input")).sendKeys(b[brow][bcol+42]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[18]/td[4]/span")).click();
  					//Patient catherised
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[19]/td[3]/span/div/input")).sendKeys(b[brow][bcol+43]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[19]/td[3]/span")).click();
  					//Mobilise
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[20]/td[2]/span/div/input")).sendKeys(b[brow][bcol+44]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[20]/td[2]/span")).click();
  					//Check x-rays
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[21]/td[2]/span/div/input")).sendKeys(b[brow][bcol+45]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[21]/td[2]/span")).click();
  					//Remove sutures
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[22]/td[2]/span/div/input")).sendKeys(b[brow][bcol+46]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[22]/td[2]/span")).click();
  					//Thrombo name
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+47]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[2]/span")).click();
  					//Thrombo dose
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[3]/span/div/input")).sendKeys(b[brow][bcol+48]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[3]/span")).click();
  					//Thrombo freq
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[4]/span/div/input")).sendKeys(b[brow][bcol+49]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[4]/span")).click();
  					//Thrombo duration
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[5]/span/div/input")).sendKeys(b[brow][bcol+50]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[5]/span")).click();
  					//Antibioctics name
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+51]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[2]/span")).click();
  					//Antibioctics dose
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[3]/span/div/input")).sendKeys(b[brow][bcol+52]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[3]/span")).click();
  					
  					
  					//Antibiotics freq
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[4]/span/div/input")).sendKeys(b[brow][bcol+53]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[4]/span")).click();
  					//Antibiotics duration
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[5]/span/div/input")).sendKeys(b[brow][bcol+54]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[5]/span")).click();
  					
  					//Implants tab
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[4]/a")).click();
  					//Knee replacement type
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(b[brow][bcol+55]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td[2]/span")).click();
  					//Manufacturer
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td[4]/span/div/input")).sendKeys(b[brow][bcol+56]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td[4]/span")).click();
  					//Femoral component size
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(b[brow][bcol+57]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[3]/td[2]/span")).click();
  					//Femoral stem
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[3]/td[4]/span/div/input")).sendKeys(b[brow][bcol+58]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[3]/td[4]/span")).click();
  					//Femoral fixation
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(b[brow][bcol+59]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td[2]/span")).click();
  					//Femoral stem diameter
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td[4]/span/div/input")).sendKeys(b[brow][bcol+60]);
                  	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td[4]/span")).click();
  					//femoral stem length
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[5]/td[3]/span/div/input")).sendKeys(b[brow][bcol+61]);
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[5]/td[3]/span")).click();
  					//Femoral plug type
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(b[brow][bcol+62]);
  					//Femoral plug size
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[6]/td[4]/span/div/input")).sendKeys(b[brow][bcol+63]);
  					//Tibial com size
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(b[brow][bcol+64]);
  					//Tibial stem
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[8]/td[4]/span/div/input")).sendKeys(b[brow][bcol+65]);
  					//Tibial fixation
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[9]/td[2]/span/div/input")).sendKeys(b[brow][bcol+66]);
  					//Tibial stem diameter
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[9]/td[4]/span/div/input")).sendKeys(b[brow][bcol+67]);
  					//Tibial plug type
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[10]/td[2]/span/div/input")).sendKeys(b[brow][bcol+68]);
  					//Tibial plug size
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[10]/td[4]/span/div/input")).sendKeys(b[brow][bcol+69]);
  					//Tibial insert
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[11]/td[2]/span/div/input")).sendKeys(b[brow][bcol+70]);
  					//Tibial Stem Length
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[11]/td[4]/span/div/input")).sendKeys(b[brow][bcol+71]);
  					//tibial screws
  					Select tscrews = new Select(driver.findElement(By.id("tibial_screws_no")));
  					tscrews.selectByVisibleText(b[brow][bcol+72]);
  					//Patella surfaced
  					driver.findElement(By.id("patella_resurfaced")).click();
  					//Patella component thickness
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[14]/td[4]/span/div/input")).sendKeys(b[brow][bcol+74]);
  					//Pat component size
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[15]/td[2]/span/div/input")).sendKeys(b[brow][bcol+75]);
  					//Patella fixation
  					driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[16]/td[2]/span/div/input")).sendKeys(b[brow][bcol+76]);
  					//Notes on TKR Preparation/implantation
  					driver.findElement(By.id("tkr_preparation")).sendKeys(b[brow][bcol+77]);
  					
  					driver.findElement(By.id("knee_operation_save")).click();
  				 					
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


  



