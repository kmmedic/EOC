
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

public class InpatientCompAdd {
	
	DataProviderAdd datap = new DataProviderAdd();
	
	private WebDriver driver = new FirefoxDriver();
	
    @BeforeTest
    public void setup()
    {
    	//driver.get("http://192.168.1.240:8800/indira_p/eoc");
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
  			    	 //Matching the review name to get in
  			    	 if(rname.equals("Inpatient Stay"))
  			    	 {
  			    		 String colort=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
  			    		 Reporter.log("Color="+colort,true);
  			    		 assertEquals(colort,"rgb(255, 0, 0)");
  			    		 Action doubleClick2 = action2.doubleClick(element2).build();
  				    	 doubleClick2.perform();// After performing double click Map will load
  				    	 Thread.sleep(3000);
  				    	 
  				    	//Matching for Inpatient Complication
  				    	
  				    	 int frmcnt=1;
  				    	 
		    	                             
  				    	//String fname= driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/div/div/div/div/li[2]/ul/li["+frmcnt+"]/a/span/input")).getText();
  				    	 String selfcare = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Inpatient Complications')]";
  				    	 WebElement selfyes = driver.findElement(By.xpath(selfcare));
  						  selfyes.click();
  				    	  				    	
  				    	//if(fname.matches("Inpatient Complications"))
  				    	//{	
  				    	String b[][]= datap.getTableArray("C:\\QA\\InpatientComp.xls",0);
  				      int brow=1;
  				      int bcol=0;
  				      Thread.sleep(2000);
  				      
  				      							   
  				      							   
  					  //driver.findElement(By.id("app_baseline_hip_assessment")).click();
  					  Thread.sleep(1000);
  					  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li/a")).click();
  					  driver.findElement(By.id("leakage_date")).click();
  					  driver.findElement(By.id("leakage_date")).sendKeys(b[row][col]);
  					  driver.findElement(By.id("noted_by")).sendKeys(b[row][col+1]);
  					  driver.findElement(By.id("death_date")).click();
  					  driver.findElement(By.id("death_date")).sendKeys(b[row][col+2]);
  					  driver.findElement(By.id("death_causes")).sendKeys(b[row][col+3]);
  					  driver.findElement(By.id("discharge_date")).click();
  					  driver.findElement(By.id("discharge_date")).sendKeys(b[row][col+4]);
  					 String complicat = "//input[contains(@id, 'complications') and contains(@value, "+b[row][col+5]+")]";
					  WebElement compyes = driver.findElement(By.xpath(complicat));
					  compyes.click();
					  
					  //Overall If Loop 
					  if(b[row][col+5].equals("1"))
 					  {
						  Reporter.log("Entered into loop",true);
  					 // driver.findElement(By.id("complications"+b[row][col+5])).click();
  					 //Complications Related to joint 
  					  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[2]/a")).click();
  					  driver.findElement(By.id("preoperative_comp"+b[row][col+6])).click();
  					  if(driver.findElement(By.id("preoperative_comp1")).isSelected()==true)
  					  {
  					  driver.findElement(By.id("preoperative_comp_date")).click();
  					  driver.findElement(By.id("preoperative_comp_date")).sendKeys(b[row][col+7]);
  					  driver.findElement(By.id("preoperative_comp_comments")).sendKeys(b[row][col+8]);
  					  }  					 
  				      driver.findElement(By.id("dislocation"+b[row][col+9])).click();
  				    if(driver.findElement(By.id("dislocation1")).isSelected()==true)
					  {
  					  driver.findElement(By.id("dislocation_date")).click();
  					  driver.findElement(By.id("dislocation_date")).sendKeys(b[row][col+10]);
  					  driver.findElement(By.id("dislocation_comments")).sendKeys(b[row][col+11]);
					  }
  				      driver.findElement(By.id("periprosthetic_fracture"+b[row][col+12])).click();
  				    if(driver.findElement(By.id("periprosthetic_fracture1")).isSelected()==true)
					  {
  					  driver.findElement(By.id("periprosthetic_fracture_date")).click();
  					  driver.findElement(By.id("periprosthetic_fracture_date")).sendKeys(b[row][col+13]);
  					  driver.findElement(By.id("periprosthetic_fracture_comments")).sendKeys(b[row][col+14]);
					  }
  				      if(driver.findElement(By.id("nerve_palsy1")).isSelected()==true)
				      {
  					  driver.findElement(By.id("nerve_palsy"+b[row][col+15])).click();
  					  driver.findElement(By.id("nerve_palsy_date")).click();
  					  driver.findElement(By.id("nerve_palsy_date")).sendKeys(b[row][col+16]);
				      driver.findElement(By.id("nerve_palsy_comments")).sendKeys(b[row][col+17]);
				      }
  				    if(driver.findElement(By.id("wound_infections1")).isSelected()==true)
				      {
  					  driver.findElement(By.id("wound_infections"+b[row][col+18])).click();
  					  driver.findElement(By.id("wound_infections_date")).click();
  					  driver.findElement(By.id("wound_infections_date")).sendKeys(b[row][col+19]);
  					  driver.findElement(By.id("wound_infec_super_deep"+b[row][col+20])).click();
  					  //driver.findElement(By.id("wound_infec_super_deep2")
  					 driver.findElement(By.id("wound_infection_duration")).sendKeys(b[row][col+21]);
  					 driver.findElement(By.id("wound_infection_antibiotics")).sendKeys(b[row][col+22]);
  					 driver.findElement(By.id("wound_infection_culture_sensi")).sendKeys(b[row][col+23]);
				      }
  					 driver.findElement(By.id("joint_other_complications"+b[row][col+24])).click();
  					if(driver.findElement(By.id("joint_other_complications1")).isSelected()==true)
				      {
  					 driver.findElement(By.id("clinical_complication_other_date")).click();
  					 driver.findElement(By.id("clinical_complication_other_date")).sendKeys(b[row][col+25]);
  					 driver.findElement(By.id("clinical_complication_other_comments")).sendKeys(b[row][col+26]);
				      }
  					
  					driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[3]/a")).click();
  					Thread.sleep(2000);
  					  //Medical Complications
  					driver.findElement(By.id("deep_vein"+b[row][col+27])).click();
  					if(driver.findElement(By.id("deep_vein1")).isSelected()==true)
				      {
  					driver.findElement(By.id("deep_vein_date")).click();
  					driver.findElement(By.id("deep_vein_date")).sendKeys(b[row][col+28]);
				      }
  					driver.findElement(By.id("pulmonary_embolism"+b[row][col+29])).click();
  					if(driver.findElement(By.id("pulmonary_embolism1")).isSelected()==true)
				      {
  					driver.findElement(By.id("pulmonary_embolism_date")).click();
  					driver.findElement(By.id("pulmonary_embolism_date")).sendKeys(b[row][col+30]);
				      }
  					driver.findElement(By.id("stroke"+b[row][col+31])).click();
  					if(driver.findElement(By.id("stroke1")).isSelected()==true)
				      {
  					driver.findElement(By.id("stroke_date")).click();
  					driver.findElement(By.id("stroke_date")).sendKeys(b[row][col+32]);
				      }
  					driver.findElement(By.id("myocardial_infrac"+b[row][col+33])).click();
  					 if(driver.findElement(By.id("myocardial_infrac1")).isSelected()==true)
 					  {
  					driver.findElement(By.id("myocardial_infrac_date")).click();
  					driver.findElement(By.id("myocardial_infrac_date")).sendKeys(b[row][col+34]);
 					  }
  					driver.findElement(By.id("infections"+b[row][col+35])).click();
  					if(driver.findElement(By.id("infections1")).isSelected()==true)
					  {
  					driver.findElement(By.id("infections_date")).click();
  					driver.findElement(By.id("infections_date")).sendKeys(b[row][col+36]);
  					driver.findElement(By.id("infections_site")).sendKeys(b[row][col+37]);
  					driver.findElement(By.id("infections_duration")).sendKeys(b[row][col+38]);
  					driver.findElement(By.id("infections_antibiotics")).sendKeys(b[row][col+39]);
  					driver.findElement(By.id("infection_culture_sens")).sendKeys(b[row][col+40]);
					  }
  					driver.findElement(By.id("clinical_complication_other"+b[row][col+41])).click();
  					if(driver.findElement(By.id("clinical_complication_other1")).isSelected()==true)
					  {
  					driver.findElement(By.id("medical_other_complications_date")).click();
  					driver.findElement(By.id("medical_other_complications_date")).sendKeys(b[row][col+42]);
  					driver.findElement(By.id("medical_other_complications_comments")).sendKeys(b[row][col+43]);
					  }
  							driver.findElement(By.id("cmd_eoc_omplications_save")).click();
  				    	//}//End of Inpatient stay IF loop
  				    	frmcnt++;
  				    	 				    	
  					
  							Thread.sleep(2000);
  					  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div/div/div/div/div/li/div/span")).click();
  					
  					  Thread.sleep(4000);
  					driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).click();
  					String colory=driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
			    		 Reporter.log("Color="+colory,true);
			    		 Reporter.log("K="+k,true);
			    		 //assertEquals(colory,"rgb(0, 0, 0)");
  					  break;
 					  }//End of COmplication Yes IF loop
  									    		   		 
  			    	 }//end of review IF loop
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


  



