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

public class BaselineAssessmentkneeAdd {
	
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
  			    	 
  			    	 if(rname.equals("Pre-operative Assessment"))
  			    	 {
  			    		 String colort=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
  			    		 Reporter.log("Color="+colort,true);
  			    		 assertEquals(colort,"rgb(255, 0, 0)");
  			    		 Action doubleClick2 = action2.doubleClick(element2).build();
  				    	 doubleClick2.perform();// After performing double click Map will load
  				    	 Thread.sleep(3000);
  				    	
  				    	String b[][]= datap.getTableArray("C:\\QA\\BaselineHip.xls",1);
  				      int brow=1;
  				      int bcol=0;
  				      Thread.sleep(2000);
  				      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/div/div/div/div/li[2]/ul/li/a/span/input")).click();
  					  //driver.findElement(By.id("app_baseline_hip_assessment")).click();
  					  Thread.sleep(1000);
  					  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li/a")).click();
  					  driver.findElement(By.id("pre_help_fill_questionnaire"+b[brow][bcol])).click();
  					  if(driver.findElement(By.id("pre_help_fill_questionnaire"+b[brow][bcol])).isSelected())
  					  {
  					  Select helpyes = new Select(driver.findElement(By.id("pre_yeshelp_fill_questionnaire")));
  					  helpyes.selectByVisibleText(b[brow][bcol+1]);
  					  }
  					  Select larg = new Select(driver.findElement(By.id("living_arragements")));
  					  larg.selectByVisibleText(b[brow][bcol+2]);
  					  Select pprob = new Select(driver.findElement(By.id("pre_how_long_knee_pbm")));
  					  pprob.selectByVisibleText(b[brow][bcol+3]);
  					  driver.findElement(By.id("pre_prevoius_joint_replacement"+b[brow][bcol+4])).click();
  					  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[2]/a")).click();
  					  Select oks1 = new Select(driver.findElement(By.id("oks_pain_usually")));
  					  oks1.selectByVisibleText(b[brow][bcol+5]);
  					  Select oks2 = new Select(driver.findElement(By.id("oks_washing_drying")));
  					  oks2.selectByVisibleText(b[brow][bcol+6]);
  					  Select oks3 = new Select(driver.findElement(By.id("oks_public_transport")));
  					  oks3.selectByVisibleText(b[brow][bcol+7]);
  					Select oks6 = new Select(driver.findElement(By.id("oks_able_towalk")));
					  oks6.selectByVisibleText(b[brow][bcol+8]);
					  Select oks8 = new Select(driver.findElement(By.id("oks_standup_chair")));
  					  oks8.selectByVisibleText(b[brow][bcol+9]);
  					  Select oks4 = new Select(driver.findElement(By.id("oks_limping_walking")));
  					  oks4.selectByVisibleText(b[brow][bcol+10]);
  					  Select oks5 = new Select(driver.findElement(By.id("oks_kneel_down")));
  					  oks5.selectByVisibleText(b[brow][bcol+11]);
  					  
  					  Select oks7 = new Select(driver.findElement(By.id("oks_bed_night")));
  					  oks7.selectByVisibleText(b[brow][bcol+12]);
  					  
  					  Select oks9 = new Select(driver.findElement(By.id("oks_usual_work")));
  					  oks9.selectByVisibleText(b[brow][bcol+13]);
  					  Select oks10 = new Select(driver.findElement(By.id("oks_might_suddenly")));
  					  oks10.selectByVisibleText(b[brow][bcol+14]);
  					  Select oks11 = new Select(driver.findElement(By.id("oks_household_shopping")));
  					  oks11.selectByVisibleText(b[brow][bcol+15]);
  					  Select oks12 = new Select(driver.findElement(By.id("oks_climb_flight")));
  					  oks12.selectByVisibleText(b[brow][bcol+16]);
  					  driver.findElement(By.id("oks_comments")).sendKeys(b[brow][bcol+17]);
  					   driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[3]/a")).click();
  					  driver.findElement(By.id("mobility"+b[brow][bcol+18])).click();
  					  String pain_discomfort = "//input[contains(@id, 'pain_discomfort') and contains(@value,"+b[brow][bcol+19]+" )]";
  					  WebElement painyes = driver.findElement(By.xpath(pain_discomfort));
  					  painyes.click();
  					  String selfcare = "//input[contains(@id, 'self_care') and contains(@value, "+b[brow][bcol+20]+")]";
					  WebElement selfyes = driver.findElement(By.xpath(selfcare));
					  selfyes.click();
					  String anxiety = "//input[contains(@id, 'anxiety_depression') and contains(@value, "+b[brow][bcol+21]+")]";
  					  WebElement anxietyyes = driver.findElement(By.xpath(anxiety));
  					  anxietyyes.click();
  					  String usuala = "//input[contains(@id, 'usual_activities') and contains(@value, "+b[brow][bcol+22]+")]";
					  WebElement usualyes = driver.findElement(By.xpath(usuala));
					  usualyes.click();
					  
					  //driver.findElement(By.id("self_care"+b[brow][bcol+20])).click();
  					  //driver.findElement(By.id("anxiety_depression"+b[brow][bcol+21])).click();
  					  //driver.findElement(By.id("usual_activities"+b[brow][bcol+22])).click();
  					  driver.findElement(By.id("health_state")).sendKeys(b[brow][bcol+23]);
  					  driver.findElement(By.id("comments")).sendKeys(b[brow][bcol+24]);
  					  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[4]/a")).click();
  					  Thread.sleep(1500);
  					  driver.findElement(By.id("pre_pat_height")).sendKeys(b[brow][bcol+25]);
  					  //int hgt=Integer.parseInt(driver.findElement(By.id("pre_pat_height")).getText());
  					  //Reporter.log("Height="+hgt);
  					  driver.findElement(By.id("pre_pat_weight")).sendKeys(b[brow][bcol+26]);
  					  //int wgt=Integer.parseInt(driver.findElement(By.id("pre_pat_weight")).getText());
					  //Reporter.log("Height="+wgt);
  					  driver.findElement(By.id("pre_pat_asa")).sendKeys(b[brow][bcol+27]);
  					  driver.findElement(By.id("pre_doctor_told_pbm"+b[brow][bcol+28])).click();
  					  driver.findElement(By.id("today_date")).click();
  					  driver.findElement(By.id("today_date")).sendKeys(b[brow][bcol+29]);
  					  driver.findElement(By.id("pre_pat_disability"+b[brow][bcol+30])).click();
  					  driver.findElement(By.id("pre_pat_influenced_pbm"+b[brow][bcol+31])).click();
  					  driver.findElement(By.id("pre_medical_conditions")).sendKeys(b[brow][bcol+32]);
  					  driver.findElement(By.id("baseline_data_save")).click();
  					  Thread.sleep(2000);
  					  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/div/div/div/div/li/div/span")).click();
  					
  					  Thread.sleep(4000);
  					driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).click();
  					String colory=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
			    		 Reporter.log("Color="+colory,true);
			    		 assertEquals(colory,"rgb(0, 0, 0)");
  					  break;
  					
  									    		   		 
  			    	 }//end of review IF loop
  			    	/*rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).click();
  			    	String colorty=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
			    	 Reporter.log("Color="+colorty,true);*/
  			    	 
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

  



