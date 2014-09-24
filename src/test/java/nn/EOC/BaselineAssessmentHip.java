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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaselineAssessmentHip {
	
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
  public void baselinehip() throws Exception {
	
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
	  Select ohs1 = new Select(driver.findElement(By.id("ohs_pain_usually")));
	  ohs1.selectByVisibleText(a[i][j+5]);
	  Select ohs2 = new Select(driver.findElement(By.id("ohs_washing_drying")));
	  ohs2.selectByVisibleText(a[i][j+6]);
	  Select ohs3 = new Select(driver.findElement(By.id("ohs_public_transport")));
	  ohs3.selectByVisibleText(a[i][j+7]);
	  Select ohs4 = new Select(driver.findElement(By.id("ohs_pair_socks")));
	  ohs4.selectByVisibleText(a[i][j+8]);
	  Select ohs5 = new Select(driver.findElement(By.id("ohs_household_shopping")));
	  ohs5.selectByVisibleText(a[i][j+9]);
	  Select ohs6 = new Select(driver.findElement(By.id("ohs_able_towalk")));
	  ohs6.selectByVisibleText(a[i][j+10]);
	  Select ohs7 = new Select(driver.findElement(By.id("ohs_climb_flight")));
	  ohs7.selectByVisibleText(a[i][j+11]);
	  Select ohs8 = new Select(driver.findElement(By.id("ohs_standup_chair")));
	  ohs8.selectByVisibleText(a[i][j+12]);
	  Select ohs9 = new Select(driver.findElement(By.id("ohs_limping_walking")));
	  ohs9.selectByVisibleText(a[i][j+13]);
	  Select ohs10 = new Select(driver.findElement(By.id("ohs_affected_hip")));
	  ohs10.selectByVisibleText(a[i][j+14]);
	  Select ohs11 = new Select(driver.findElement(By.id("ohs_usual_work")));
	  ohs11.selectByVisibleText(a[i][j+15]);
	  Select ohs12 = new Select(driver.findElement(By.id("ohs_bed_night")));
	  ohs12.selectByVisibleText(a[i][j+16]);
	  driver.findElement(By.id("ohs_comments")).sendKeys(a[i][j+17]);
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


