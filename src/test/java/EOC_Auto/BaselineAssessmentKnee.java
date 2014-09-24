
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaselineAssessmentKnee {
	
	DataProviderAdd datap = new DataProviderAdd();
	
	private WebDriver driver = new FirefoxDriver();
	
    @BeforeTest
    /*public void setup()
    {
    	driver.get("http://192.168.1.240:8800/indira_p/eoc");
    	driver.manage().window().maximize();
    }
    */
    @Test    
  public void baselineknee() throws Exception {
	
	  String a[][]= datap.getTableArray("C:\\QA\\BaselineHip.xls",0);
      int i=1;
      int j=0;
      Thread.sleep(2000);
      driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/div/div/div/div/li[2]/ul/li/a/span/input")).click();
	  //driver.findElement(By.id("app_baseline_hip_assessment")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li/a")).click();
	  driver.findElement(By.id("pre_help_fill_questionnaire"+a[i][j])).click();
	  Select helpyes = new Select(driver.findElement(By.id("pre_yeshelp_fill_questionnaire")));
	  helpyes.selectByVisibleText(a[i][j+1]);
	  Select larg = new Select(driver.findElement(By.id("living_arragements")));
	  larg.selectByVisibleText(a[i][j+2]);
	  Select pprob = new Select(driver.findElement(By.id("pre_how_long_knee_pbm")));
	  pprob.selectByVisibleText(a[i][j+3]);
	  driver.findElement(By.id("pre_prevoius_joint_replacement"+a[i][j+4])).click();
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[2]/a")).click();
	  Select oks1 = new Select(driver.findElement(By.id("oks_pain_usually")));
	  oks1.selectByVisibleText(a[i][j+5]);
	  Select oks2 = new Select(driver.findElement(By.id("oks_washing_drying")));
	  oks2.selectByVisibleText(a[i][j+6]);
	  Select oks3 = new Select(driver.findElement(By.id("oks_public_transport")));
	  oks3.selectByVisibleText(a[i][j+7]);
	  Select oks4 = new Select(driver.findElement(By.id("oks_pair_socks")));
	  oks4.selectByVisibleText(a[i][j+8]);
	  Select oks5 = new Select(driver.findElement(By.id("oks_household_shopping")));
	  oks5.selectByVisibleText(a[i][j+9]);
	  Select oks6 = new Select(driver.findElement(By.id("oks_able_towalk")));
	  oks6.selectByVisibleText(a[i][j+10]);
	  Select oks7 = new Select(driver.findElement(By.id("oks_climb_flight")));
	  oks7.selectByVisibleText(a[i][j+11]);
	  Select oks8 = new Select(driver.findElement(By.id("oks_standup_chair")));
	  oks8.selectByVisibleText(a[i][j+12]);
	  Select oks9 = new Select(driver.findElement(By.id("oks_limping_walking")));
	  oks9.selectByVisibleText(a[i][j+13]);
	  Select oks10 = new Select(driver.findElement(By.id("oks_affected_hip")));
	  oks10.selectByVisibleText(a[i][j+14]);
	  Select oks11 = new Select(driver.findElement(By.id("oks_usual_work")));
	  oks11.selectByVisibleText(a[i][j+15]);
	  Select oks12 = new Select(driver.findElement(By.id("oks_bed_night")));
	  oks12.selectByVisibleText(a[i][j+16]);
	  driver.findElement(By.id("oks_comments")).sendKeys(a[i][j+17]);
	   driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[3]/a")).click();
	  driver.findElement(By.id("mobility"+a[i][j+18])).click();
	  driver.findElement(By.id("pain_discomfort")).sendKeys(a[i][j+19]);
	  driver.findElement(By.id("self_care")).sendKeys(a[i][j+20]);
	  driver.findElement(By.id("anxiety_depression")).sendKeys(a[i][j+21]);
	  driver.findElement(By.id("usual_activities")).sendKeys(a[i][j+22]);
	  driver.findElement(By.id("health_state")).sendKeys(a[i][j+23]);
	  driver.findElement(By.id("comments")).sendKeys(a[i][j+24]);
	  driver.findElement(By.id("pre_pat_height")).sendKeys(a[i][j+25]);
	  driver.findElement(By.id("pre_pat_weight")).sendKeys(a[i][j+26]);
	  driver.findElement(By.id("pre_pat_asa")).sendKeys(a[i][j+27]);
	  driver.findElement(By.id("pre_doctor_told_pbm"+a[i][j+28])).click();
	  driver.findElement(By.id("today_date")).sendKeys(a[i][j+29]);
	  driver.findElement(By.id("pre_pat_disability2"+a[i][j+30])).click();
	  driver.findElement(By.id("pre_pat_influenced_pbm"+a[i][j+31])).click();
	  driver.findElement(By.id("pre_medical_conditions")).sendKeys(a[i][j+32]);
	  
	  
	  
	  
	  
  }
	     	
	 
}



