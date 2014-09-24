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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ComplicationSatisfactionAdd {
	
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
  	  	driver.findElement(By.className("StudyText")).click();
  	  	WebDriverWait wait = new WebDriverWait(driver,05);
  	  	wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_header_patient")));
  	  	driver.findElement(By.className("cls_header_patient")).click();
  	  	Thread.sleep(500);
  	  	driver.findElement(By.id("SearchBox")).click();
  	  	driver.findElement(By.id("SearchBox")).sendKeys("t");
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
  		    	  if(sd.matches("Thomas"))
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
  		    	 String tname=tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[1]/div[2]/div/div[1]/p[2]")).getText();
  		    	 String tdate=tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[1]/div[2]/div/div[1]/p[1]")).getText();
  		    	 Reporter.log("Treatment Name="+tname+"Treatment date="+tdate,true);
  		    	 String[] tt=tname.split("  ");
  		    	 int len=tt.length;
  		    	 Reporter.log("Length of array="+len,true);
  		    	 
  		    	if(tdate.matches("28-02-2014") && tname.matches("Right  Hip  Replacement"))
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
		Object[][] retObjArr=datap.getTableArray("C:\\QAA\\InpatientComp.xls",2);
        return(retObjArr);
        
	}
    
    @Test(dataProvider="data-provider") 
    public void add(String complication,String disloc,String disloc_date,String disloc_hosp,String disloc_supp,String frac,String frac_date,String frac_hosp,String frac_supp
    ,String joint_inf,String joint_date,String joint_hosp,String joint_supp,String pul_embolism
    ,String pul_date,String pul_hosp,String pul_supp,String heart_attack,String heart_date,String heart_hosp,String heart_supp
    ,String pneumonia,String pneu_date,String pneu_hosp,String stroke,String stroke_date,String stroke_hosp,String stroke_supp
    ,String other_joint,String other_joint_date,String other_joint_hosp,String other_joint_supp,String admit_other,String admit_other_date
    ,String admit_other_hosp,String admit_other_supp,String admit_other_notes,String urine,String urine_hosp,String deep_vein,String deep_date,String deep_supp,String wound_infec,String wound_date,String wound_supp,String nerve,String nerve_date,String nerve_supp,String diarr,String diarr_date
    ,String doctor_other,String doctor_date,String doctor_notes,String notes,String serv_sat,String outcome_sat) throws Exception {
   
    	WebDriverWait wait = new WebDriverWait(driver,05);
  	  	
      	Thread.sleep(3000);
      	String comp = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Complications & Patient  Satisfaction')]";
    	WebElement compyes = driver.findElement(By.xpath(comp));
    	compyes.click();
    	Thread.sleep(2000);
  				    	int joint_infec=0;
                    //Complication Yes
  				    driver.findElement(By.id("complications"+complication)).click();
				      
				      if(driver.findElement(By.id("complications1")).isSelected())
				      {
				    	  //Dislocation
				    	  driver.findElement(By.id("dislocation"+disloc)).click();
				    	  if(driver.findElement(By.id("dislocation1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("dislocation_date")).click();
				    		  driver.findElement(By.id("dislocation_date")).sendKeys(disloc_date);
				    		  driver.findElement(By.id("dislocation_hospital_name")).clear();
				    		  driver.findElement(By.id("dislocation_hospital_name")).sendKeys(disloc_hosp);
				    		  if(disloc_supp.equals("1")){ driver.findElement(By.id("dislocation_gp_surppress")).click();}
				    	  }
				    	//Fracture
				    	  driver.findElement(By.id("periprosthetic_fracture"+frac)).click();
				    	  if(driver.findElement(By.id("periprosthetic_fracture1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("periprosthetic_fracture_date")).click();
				    		  driver.findElement(By.id("periprosthetic_fracture_date")).sendKeys(frac_date);
				    		  driver.findElement(By.id("periprosthetic_fracture_hospital_name")).clear();
				    		  driver.findElement(By.id("periprosthetic_fracture_hospital_name")).sendKeys(frac_hosp);
				    		  if(frac_supp.equals("1")){   driver.findElement(By.id("periprosthetic_fracture_gp_surppress")).click();}
				    	  }
				    	// Joint Infection
				    	  driver.findElement(By.id("joint_infec"+joint_inf)).click();
				    	  if(driver.findElement(By.id("joint_infec1")).isSelected())
				    	  {
				    		  joint_infec=1;
				    		  driver.findElement(By.id("joint_infec_date")).click();
				    		  driver.findElement(By.id("joint_infec_date")).sendKeys(joint_date);
				    		  driver.findElement(By.id("joint_infec_hospital_name")).clear();
				    		  driver.findElement(By.id("joint_infec_hospital_name")).sendKeys(joint_hosp);
				    		  if(joint_supp.equals("1")){   driver.findElement(By.id("joint_infec_gp_surppress")).click();}
				    	  }
				    	
				    	// Pulmonary Embolism
				    	  driver.findElement(By.id("pulmonary_embolism"+pul_embolism)).click();
				    	  if(driver.findElement(By.id("pulmonary_embolism1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("pulmonary_embolism_date")).click();
				    		  driver.findElement(By.id("pulmonary_embolism_date")).sendKeys(pul_date);
				    		  driver.findElement(By.id("pulmonary_embolism_hospital_name")).clear();
				    		  driver.findElement(By.id("pulmonary_embolism_hospital_name")).sendKeys(pul_hosp);
				    		  if(pul_supp.equals("1")){   driver.findElement(By.id("pulmonary_embolism_gp_surppress")).click();}
				    	  }
				    	  
				    	//Heart attack
				    	  driver.findElement(By.id("heart_attack"+heart_attack)).click();
				    	  if(driver.findElement(By.id("heart_attack1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("heart_attack_date")).click();
				    		  driver.findElement(By.id("heart_attack_date")).sendKeys(heart_date);
				    		  driver.findElement(By.id("heart_attack_hospital_name")).clear();
				    		  driver.findElement(By.id("heart_attack_hospital_name")).sendKeys(heart_hosp);
				    		  if(heart_supp.equals("1")){   driver.findElement(By.id("heart_attack_gp_surppress")).click();}
				    	  }
				    	  
				    	
				    	//Pneumonia
				    	  driver.findElement(By.id("pneumonia"+pneumonia)).click();
				    	  if(driver.findElement(By.id("pneumonia1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("pneumonia_date")).click();
				    		  driver.findElement(By.id("pneumonia_date")).sendKeys(pneu_date);
				    		  driver.findElement(By.id("pneumonia_hospital_name")).clear();
				    		  driver.findElement(By.id("pneumonia_hospital_name")).sendKeys(pneu_hosp);
				    		  
				    		  
				    	  }
				    	
				    	//Stroke
				    	  driver.findElement(By.id("stroke"+stroke)).click();
				    	  if(driver.findElement(By.id("stroke1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("stroke_date")).click();
				    		  driver.findElement(By.id("stroke_date")).sendKeys(stroke_date);
				    		  driver.findElement(By.id("stroke_hospital_name")).clear();
				    		  driver.findElement(By.id("stroke_hospital_name")).sendKeys(stroke_hosp);
				    		  if(stroke_supp.equals("1")){driver.findElement(By.id("stroke_gp_surppress")).click();}
				    		  
				    	  }
				    	
				    	//Other Surgery to joint 
				    	  driver.findElement(By.id("surgery_joint"+other_joint)).click();
				    	  if(driver.findElement(By.id("surgery_joint1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("joint_other_complications_date")).click();
				    		  driver.findElement(By.id("joint_other_complications_date")).sendKeys(other_joint_date);
				    		  driver.findElement(By.id("joint_other_complications_hospital_name")).clear();
				    		  driver.findElement(By.id("joint_other_complications_hospital_name")).sendKeys(other_joint_hosp);
				    		  if(other_joint_supp.equals("1")){   driver.findElement(By.id("joint_other_complications_gp_surppress")).click();}
				    		  
				    	  }
				    	
				    	//Other
				    	  driver.findElement(By.id("complication_other"+admit_other)).click();
				    	  if(driver.findElement(By.id("complication_other1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("clinical_complication_other_date")).click();
				    		  driver.findElement(By.id("clinical_complication_other_date")).sendKeys(admit_other_date);
				    		  driver.findElement(By.id("clinical_complication_other_hospital_name")).clear();
				    		  driver.findElement(By.id("clinical_complication_other_hospital_name")).sendKeys(admit_other_hosp);
				    		  if(admit_other_supp.equals("1")){   driver.findElement(By.id("clinical_complication_other_gp_surppress")).click();}
				    		  driver.findElement(By.id("complication_others_specify")).sendKeys(admit_other_notes);
				    	  }
				    	
				    	  //Treated by a doctor
				    	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/ul/li[2]/a")).click();
				    	// Urine/Water Infection 
				    	  driver.findElement(By.id("urine_water_doctor"+urine)).click();
				    	  if(driver.findElement(By.id("urine_water_doctor1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("urine_water_doctor_date")).click();
				    		  driver.findElement(By.id("urine_water_doctor_date")).sendKeys(urine_hosp);
				    		 
				    	  }
				    	
				    	//Deep vein
				    	String deepvein = "//input[contains(@id, 'deep_vein') and contains(@value, "+deep_vein+")]";
				    	 WebElement selfyes = driver.findElement(By.xpath(deepvein));
						  selfyes.click();
				    	if(selfyes.isSelected())
				    	{
				    		driver.findElement(By.id("deep_vein_date")).click();
				    		driver.findElement(By.id("deep_vein_date")).sendKeys(deep_date);		
				    		if(deep_supp.equals("1")){driver.findElement(By.id("deep_vein_gp_surppress")).click();}
				    	}
				    	//Wound infection
				    	 if(driver.findElement(By.id("joint_infec1")).isSelected())
				    	 {
				    		 assertTrue(driver.findElement(By.id("wound_infections1")).isEnabled()==false);
				    	 }
				    	 else
				    	 {
				    		 assertEquals(joint_infec,0);
				    	driver.findElement(By.id("wound_infections"+wound_infec)).click();
				    	  if(driver.findElement(By.id("wound_infections1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("wound_dehiscene_infection_date")).click();
				    		  driver.findElement(By.id("wound_dehiscene_infection_date")).sendKeys(wound_date);
				    		  if(wound_supp.equals("1")){driver.findElement(By.id("wound_dehiscene_infection_gp_surppress")).click();}
				    	  }
				    	 }
				    	//Nerve palsy
				    	  driver.findElement(By.id("nerve_palsy"+nerve)).click();
				    	  if(driver.findElement(By.id("nerve_palsy1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("nerve_palsy_date")).click();
				    		  driver.findElement(By.id("nerve_palsy_date")).sendKeys(nerve_date);
				    		  if(nerve_supp.equals("1")){driver.findElement(By.id("nerve_palsy_gp_surppress")).click();}
				    	  }
				    	
				    	//Diarrhae
				    	  driver.findElement(By.id("diarrhoea_vomiting"+diarr)).click();
				    	  if(driver.findElement(By.id("diarrhoea_vomiting1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("diarrhoea_vomiting_date")).click();
				    		  driver.findElement(By.id("diarrhoea_vomiting_date")).sendKeys(diarr_date);
				    	  }
				    	
				    	//Other
				    	  driver.findElement(By.id("medical_others"+doctor_other)).click();
				    	  if(driver.findElement(By.id("medical_others1")).isSelected())
				    	  {
				    		  driver.findElement(By.id("medical_others_date")).click();
				    		  driver.findElement(By.id("medical_others_date")).sendKeys(doctor_date);
				    		  driver.findElement(By.id("medical_others_specify")).clear();
				    		  driver.findElement(By.id("medical_others_specify")).sendKeys(doctor_notes);
				    	  }
				    					    	
				    	
				    			    	  
  				    	  
  				      }//end of Complication Yes loop
				      
				    //Notes
				      driver.findElement(By.id("notes")).clear();
				      driver.findElement(By.id("notes")).sendKeys(notes);
				    	
				    	//Service &outcome specification
				      driver.findElement(By.id("service_satisfy")).clear();
				      driver.findElement(By.id("service_satisfy")).sendKeys(serv_sat);
				      driver.findElement(By.id("outcome_satisfy")).clear();
				      driver.findElement(By.id("outcome_satisfy")).sendKeys(outcome_sat);
				    	driver.findElement(By.id("cmd_compli_pat_satis_save")).click();
				    	//driver.findElement(By.id("cmd_compli_pat_satis_cancel")).click();
				    	Thread.sleep(2000);
				      
				      //driver.findElement(By.id("cmd_compli_pat_satis_save")).click();
  				    
				    	 }
}



  




