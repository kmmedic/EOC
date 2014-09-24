package EOC_Auto;

import static org.testng.Assert.assertEquals;

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
import org.openqa.selenium.WebDriverException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaselineAssessmentHip {
	
	DataProviderAdd datap = new DataProviderAdd();
	
	private WebDriver driver = new FirefoxDriver();
	
    @BeforeTest
   public void setup() throws InterruptedException
    {
    	driver.get("http://192.168.1.246/eoc");
    	driver.manage().window().maximize();
    	
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
  	  	driver.findElement(By.id("SearchBox")).sendKeys("testpatienta");
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
  		    	  if(sd.matches("testpatienta"))
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
  		    	 
  		    	if(tdate.matches("28-02-2014") && tname.matches("Left  Hip  Replacement"))
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
    			    		 //assertEquals(colort,"rgb(255, 0, 0)");
    			    		 Action doubleClick2 = action2.doubleClick(element2).build();
    				    	 doubleClick2.perform();// After performing double click Map will load
    				    	 break;
    				    	 }
    			    	 k++;
    			    	 
    				}
  		    	 break;
  		    	 }
  				}
  				break;
  		    	 }
  		}

    }
    
    @DataProvider(name = "data-provider", parallel = false)
	public Object[][] data() throws Exception {
		Object[][] retObjArr=datap.getTableArray("C:\\QAA\\BaselineHip1.xls",0);
        return(retObjArr);
        
	}
    
    @Test(dataProvider="data-provider")    
  	public void baselinehip(String Filling,String Filling_Yes,String Living_arrangement,String how_long,String previous,String pain,String wash_drying,String public_trans,String socks,String house_shop,String severe_pain,String flight_stairs,String after_meal,String limping,String shooting_pain,String usual_work,String bed_night,String oxford_comment,String euro1,String euro2,String euro3,String euro4,String euro5,String health,String euro_comments,String height,String weight,String ASA,String doctor,String today_date,String disability,String influence,String medical) throws Exception,InterruptedException, BiffException, IOException,WebDriverException  {
	
    	WebDriverWait wait = new WebDriverWait(driver,05);
  	  	
      	Thread.sleep(3000);
      	String euroq = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Baseline Assessment Hip')]";
    	WebElement euroyes = driver.findElement(By.xpath(euroq));
    	euroyes.click();
    	Thread.sleep(2000);
    	
      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/div/div/div/div/li[2]/ul/li/a/span/input")).click();
	  //driver.findElement(By.id("app_baseline_hip_assessment")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li/a")).click();
	  driver.findElement(By.id("pre_help_fill_questionnaire"+Filling)).click();
	  if(driver.findElement(By.id("pre_help_fill_questionnaire1")).isSelected())
	  {Select helpyes = new Select(driver.findElement(By.id("pre_yeshelp_fill_questionnaire")));
	  helpyes.selectByVisibleText(Filling_Yes);
	  }
	  Select larg = new Select(driver.findElement(By.id("living_arragements")));
	  larg.selectByVisibleText(Living_arrangement);
	  Select pprob = new Select(driver.findElement(By.id("pre_how_long_knee_pbm")));
	  pprob.selectByVisibleText(how_long);
	  driver.findElement(By.id("pre_prevoius_joint_replacement"+previous)).click();
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[2]/a")).click();
	  Select ohs1 = new Select(driver.findElement(By.id("ohs_pain_usually")));
	  ohs1.selectByVisibleText(pain);
	  Select ohs2 = new Select(driver.findElement(By.id("ohs_washing_drying")));
	  ohs2.selectByVisibleText(wash_drying);
	  Select ohs3 = new Select(driver.findElement(By.id("ohs_public_transport")));
	  ohs3.selectByVisibleText(public_trans);
	  Select ohs4 = new Select(driver.findElement(By.id("ohs_pair_socks")));
	  ohs4.selectByVisibleText(socks);
	  Select ohs5 = new Select(driver.findElement(By.id("ohs_household_shopping")));
	  ohs5.selectByVisibleText(house_shop);
	  Select ohs6 = new Select(driver.findElement(By.id("ohs_able_towalk")));
	  ohs6.selectByVisibleText(severe_pain);
	  Select ohs7 = new Select(driver.findElement(By.id("ohs_climb_flight")));
	  ohs7.selectByVisibleText(flight_stairs);
	  Select ohs8 = new Select(driver.findElement(By.id("ohs_standup_chair")));
	  ohs8.selectByVisibleText(after_meal);
	  Select ohs9 = new Select(driver.findElement(By.id("ohs_limping_walking")));
	  ohs9.selectByVisibleText(limping);
	  Select ohs10 = new Select(driver.findElement(By.id("ohs_affected_hip")));
	  ohs10.selectByVisibleText(shooting_pain);
	  Select ohs11 = new Select(driver.findElement(By.id("ohs_usual_work")));
	  ohs11.selectByVisibleText(usual_work);
	  Select ohs12 = new Select(driver.findElement(By.id("ohs_bed_night")));
	  ohs12.selectByVisibleText(bed_night);
	  driver.findElement(By.id("ohs_comments")).clear();
	  driver.findElement(By.id("ohs_comments")).sendKeys(oxford_comment);
	   driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[3]/a")).click();
	  driver.findElement(By.id("mobility"+euro1)).click();
	  driver.findElement(By.id("pain_discomfort")).sendKeys(euro2);
	  driver.findElement(By.id("self_care")).sendKeys(euro3);
	  driver.findElement(By.id("anxiety_depression")).sendKeys(euro4);
	  driver.findElement(By.id("usual_activities")).sendKeys(euro5);
	  driver.findElement(By.id("health_state")).clear();
	  driver.findElement(By.id("health_state")).sendKeys(health);
	  driver.findElement(By.id("comments")).clear();
	  driver.findElement(By.id("comments")).sendKeys(euro_comments);
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[4]/a")).click();
	  driver.findElement(By.id("pre_pat_height")).click();
	  driver.findElement(By.id("pre_pat_height")).sendKeys(height);
	  driver.findElement(By.id("pre_pat_weight")).clear();
	  driver.findElement(By.id("pre_pat_weight")).sendKeys(weight);
	  driver.findElement(By.id("pre_pat_asa")).clear();
	  driver.findElement(By.id("pre_pat_asa")).sendKeys(ASA);
	  driver.findElement(By.id("pre_doctor_told_pbm"+doctor)).click();
	  driver.findElement(By.id("today_date")).click();
	  driver.findElement(By.id("today_date")).sendKeys(today_date);
	  driver.findElement(By.id("pre_pat_disability"+disability)).click();
	  driver.findElement(By.id("pre_pat_influenced_pbm"+influence)).click();
	  driver.findElement(By.id("pre_medical_conditions")).clear();
	  driver.findElement(By.id("pre_medical_conditions")).sendKeys(medical);
	  Thread.sleep(2000);
	  driver.findElement(By.id("baseline_hip_data_save")).click();
	  Thread.sleep(2000);
	   }
	     	
	 
}


