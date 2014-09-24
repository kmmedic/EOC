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

public class ComplicationSatisfactionAdd {
	
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
  			    	 
  			    	 if(rname.equals("6 week review"))
  			    	 {
  			    		 String colort=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
  			    		 Reporter.log("Color="+colort,true);
  			    		 //assertEquals(colort,"rgb(255, 0, 0)");
  			    		 Action doubleClick2 = action2.doubleClick(element2).build();
  				    	 doubleClick2.perform();// After performing double click Map will load
  				    	 Thread.sleep(3000);
  				    	 
  				    	String euroq = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Complications & Patient  Satisfaction')]";
				    	 WebElement euroyes = driver.findElement(By.xpath(euroq));
						  euroyes.click();
  				    	
  				    	String b[][]= datap.getTableArray("C:\\QA\\InpatientComp.xls",1);
  				    	int loop=datap.rowcolumn("C:\\QA\\InpatientComp.xls",1);
  				    	Reporter.log("Row No="+loop,true);
  				    	 //int brow=1;
  				      int bcol=0;
  				      Thread.sleep(2000);
  				     for (int brow=1;brow<=loop;brow++)
  				     {	 
  				    	int joint_infec=0;
                    //Complication Yes
  				    driver.findElement(By.id("complications"+b[brow][bcol])).click();
				      
				      if(driver.findElement(By.id("complications1")).isSelected())
				      {
				    	  //Dislocation
				    	  driver.findElement(By.id("dislocation"+b[brow][bcol+1])).click();
				    	  if(driver.findElement(By.id("dislocation1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("dislocation_date")).click();
				    		  driver.findElement(By.id("dislocation_date")).sendKeys(b[brow][bcol+2]);
				    		  driver.findElement(By.id("dislocation_hospital_name")).sendKeys(b[brow][bcol+3]);
				    		  if(b[brow][bcol+4].equals("1")){   driver.findElement(By.id("dislocation_gp_surppress")).click();}
				    	  }
				    	//Fracture
				    	  driver.findElement(By.id("periprosthetic_fracture"+b[brow][bcol+5])).click();
				    	  if(driver.findElement(By.id("periprosthetic_fracture1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("periprosthetic_fracture_date")).click();
				    		  driver.findElement(By.id("periprosthetic_fracture_date")).sendKeys(b[brow][bcol+6]);
				    		  driver.findElement(By.id("periprosthetic_fracture_hospital_name")).sendKeys(b[brow][bcol+7]);
				    		  if(b[brow][bcol+8].equals("1")){   driver.findElement(By.id("periprosthetic_fracture_gp_surppress")).click();}
				    	  }
				    	// Joint Infection
				    	  driver.findElement(By.id("joint_infec"+b[brow][bcol+9])).click();
				    	  if(driver.findElement(By.id("joint_infec1")).isSelected())
				    	  {
				    		  joint_infec=1;
				    		  driver.findElement(By.id("joint_infec_date")).click();
				    		  driver.findElement(By.id("joint_infec_date")).sendKeys(b[brow][bcol+10]);
				    		  driver.findElement(By.id("joint_infec_hospital_name")).sendKeys(b[brow][bcol+11]);
				    		  if(b[brow][bcol+12].equals("1")){   driver.findElement(By.id("joint_infec_gp_surppress")).click();}
				    	  }
				    	
				    	// Pulmonary Embolism
				    	  driver.findElement(By.id("pulmonary_embolism"+b[brow][bcol+13])).click();
				    	  if(driver.findElement(By.id("pulmonary_embolism1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("pulmonary_embolism_date")).click();
				    		  driver.findElement(By.id("pulmonary_embolism_date")).sendKeys(b[brow][bcol+14]);
				    		  driver.findElement(By.id("pulmonary_embolism_hospital_name")).sendKeys(b[brow][bcol+15]);
				    		  if(b[brow][bcol+16].equals("1")){   driver.findElement(By.id("pulmonary_embolism_gp_surppress")).click();}
				    	  }
				    	  
				    	//Heart attack
				    	  driver.findElement(By.id("heart_attack"+b[brow][bcol+17])).click();
				    	  if(driver.findElement(By.id("heart_attack1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("heart_attack_date")).click();
				    		  driver.findElement(By.id("heart_attack_date")).sendKeys(b[brow][bcol+18]);
				    		  driver.findElement(By.id("heart_attack_hospital_name")).sendKeys(b[brow][bcol+19]);
				    		  if(b[brow][bcol+20].equals("1")){   driver.findElement(By.id("heart_attack_gp_surppress")).click();}
				    	  }
				    	  
				    	
				    	//Pneumonia
				    	  driver.findElement(By.id("pneumonia"+b[brow][bcol+21])).click();
				    	  if(driver.findElement(By.id("pneumonia1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("pneumonia_date")).click();
				    		  driver.findElement(By.id("pneumonia_date")).sendKeys(b[brow][bcol+22]);
				    		  driver.findElement(By.id("heart_attack_hospital_name")).sendKeys(b[brow][bcol+23]);
				    		  
				    	  }
				    	
				    	//Stroke
				    	  driver.findElement(By.id("stroke"+b[brow][bcol+24])).click();
				    	  if(driver.findElement(By.id("stroke1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("stroke_date")).click();
				    		  driver.findElement(By.id("stroke_date")).sendKeys(b[brow][bcol+25]);
				    		  driver.findElement(By.id("stroke_hospital_name")).sendKeys(b[brow][bcol+26]);
				    		  if(b[brow][bcol+27].equals("1")){   driver.findElement(By.id("stroke_gp_surppress")).click();}
				    		  
				    	  }
				    	
				    	//Other Surgery to joint 
				    	  driver.findElement(By.id("surgery_joint"+b[brow][bcol+28])).click();
				    	  if(driver.findElement(By.id("surgery_joint1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("joint_other_complications_date")).click();
				    		  driver.findElement(By.id("joint_other_complications_date")).sendKeys(b[brow][bcol+29]);
				    		  driver.findElement(By.id("joint_other_complications_hospital_name")).sendKeys(b[brow][bcol+30]);
				    		  if(b[brow][bcol+31].equals("1")){   driver.findElement(By.id("joint_other_complications_gp_surppress")).click();}
				    		  
				    	  }
				    	
				    	//Other
				    	  driver.findElement(By.id("complication_other"+b[brow][bcol+32])).click();
				    	  if(driver.findElement(By.id("complication_other1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("clinical_complication_other_date")).click();
				    		  driver.findElement(By.id("clinical_complication_other_date")).sendKeys(b[brow][bcol+33]);
				    		  driver.findElement(By.id("clinical_complication_other_hospital_name")).sendKeys(b[brow][bcol+34]);
				    		  if(b[brow][bcol+35].equals("1")){   driver.findElement(By.id("clinical_complication_other_gp_surppress")).click();}
				    		  driver.findElement(By.id("complication_others_specify")).sendKeys(b[brow][bcol+36]);
				    	  }
				    	
				    	  //Treated by a doctor
				    	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/ul/li[2]/a")).click();
				    	// Urine/Water Infection 
				    	  driver.findElement(By.id("urine_water_doctor"+b[brow][bcol+37])).click();
				    	  if(driver.findElement(By.id("urine_water_doctor1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("urine_water_doctor_date")).click();
				    		  driver.findElement(By.id("urine_water_doctor_date")).sendKeys(b[brow][bcol+38]);
				    		 
				    	  }
				    	
				    	//Deep vein
				    	String deepvein = "//input[contains(@id, 'deep_vein') and contains(@value, "+b[brow][bcol+39]+")]";
				    	 WebElement selfyes = driver.findElement(By.xpath(deepvein));
						  selfyes.click();
				    	if(selfyes.isSelected())
				    	{
				    		driver.findElement(By.id("deep_vein_date")).click();
				    		driver.findElement(By.id("deep_vein_date")).sendKeys(b[brow][bcol+40]);		
				    		if(b[brow][bcol+41].equals("1")){driver.findElement(By.id("deep_vein_gp_surppress")).click();}
				    	}
				    	//Wound infection
				    	 if(driver.findElement(By.id("joint_infec1")).isSelected())
				    	 {
				    		 assertTrue(driver.findElement(By.id("wound_infections1")).isEnabled()==false);
				    	 }
				    	 else
				    	 {
				    		 assertEquals(joint_infec,0);
				    	driver.findElement(By.id("wound_infections"+b[brow][bcol+42])).click();
				    	  if(driver.findElement(By.id("wound_infections1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("wound_dehiscene_infection_date")).click();
				    		  driver.findElement(By.id("wound_dehiscene_infection_date")).sendKeys(b[brow][bcol+43]);
				    		  if(b[brow][bcol+44].equals("1")){driver.findElement(By.id("wound_dehiscene_infection_gp_surppress")).click();}
				    	  }
				    	 }
				    	//Nerve palsy
				    	  driver.findElement(By.id("nerve_palsy"+b[brow][bcol+45])).click();
				    	  if(driver.findElement(By.id("nerve_palsy1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("nerve_palsy_date")).click();
				    		  driver.findElement(By.id("nerve_palsy_date")).sendKeys(b[brow][bcol+46]);
				    		  if(b[brow][bcol+47].equals("1")){driver.findElement(By.id("nerve_palsy_gp_surppress")).click();}
				    	  }
				    	
				    	//Diarrhae
				    	  driver.findElement(By.id("diarrhoea_vomiting"+b[brow][bcol+48])).click();
				    	  if(driver.findElement(By.id("diarrhoea_vomiting1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("diarrhoea_vomiting_date")).click();
				    		  driver.findElement(By.id("diarrhoea_vomiting_date")).sendKeys(b[brow][bcol+49]);
				    	  }
				    	
				    	//Other
				    	  driver.findElement(By.id("medical_others"+b[brow][bcol+50])).click();
				    	  if(driver.findElement(By.id("medical_others1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("medical_others_date")).click();
				    		  driver.findElement(By.id("medical_others_date")).sendKeys(b[brow][bcol+51]);
				    		  driver.findElement(By.id("medical_others_specify")).sendKeys(b[brow][bcol+52]);
				    	  }
				    					    	
				    	
				    			    	  
  				    	  
  				      }//end of Complication Yes loop
				      
				    //Notes
				    	driver.findElement(By.id("notes")).sendKeys(b[brow][bcol+53]);
				    	
				    	//Service &outcome specification
				    	driver.findElement(By.id("service_satisfy")).sendKeys(b[brow][bcol+54]);
				    	driver.findElement(By.id("outcome_satisfy")).sendKeys(b[brow][bcol+55]);
				    	
				    	driver.findElement(By.id("cmd_compli_pat_satis_cancel")).click();
				    	Thread.sleep(2000);
				      
				      //driver.findElement(By.id("cmd_compli_pat_satis_save")).click();
  				     }//end of loop For
  				 					
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


  




