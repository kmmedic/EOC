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

public class GeneralComplication {
	
	DataProviderAdd datap = new DataProviderAdd();
	
	private WebDriver driver = new FirefoxDriver();
	
    @BeforeTest
    
    public void setup()
    {
    	driver.get("http://192.168.1.246/main");
    	driver.manage().window().maximize();
    }
    
    
    @Test
    public void add() throws Exception,InterruptedException, BiffException, IOException  {
  	
  	  String a[][]= datap.getTableArray("C:\\QA\\PatTrmtList.xls",0);
	  	
  	 //try{
  		 
  	 
  	  	driver.findElement(By.id("username")).clear();
  	  	driver.findElement(By.id("username")).sendKeys("admin");
  	  	driver.findElement(By.id("password")).clear();
  	  	driver.findElement(By.id("password")).sendKeys("a");
  	  	driver.findElement(By.id("btLogin")).click();
  	  	//Selecting Patients
  	  	//driver.findElement(By.className("StudyText")).click();
  	  	driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/div[2]")).click();
  	  	WebDriverWait wait = new WebDriverWait(driver,05);
  	  	wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_header_patient")));
  	  	driver.findElement(By.className("cls_header_patient")).click();
  	  	Thread.sleep(500);
  	  	driver.findElement(By.id("SearchBox")).click();
  	  	driver.findElement(By.id("SearchBox")).sendKeys("Mel");
  	  	driver.findElement(By.className("btnStudySearch")).click();
  	  	Thread.sleep(500);
  	  	
  	  	WebElement table = driver.findElement(By.className("flex_patient"));
  	  	List<WebElement> tagname1 = table.findElements(By.tagName("tr"));
  	  	
  	  	
  		Reporter.log("size of the list "+tagname1.size(),true);
  		int i =1; 
  		int row=3;
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
  			    	 
  			    	 if(rname.equals("Index Operation"))
  			    	 {
  			    		 String colort=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
  			    		 Reporter.log("Color="+colort,true);
  			    		 //assertEquals(colort,"rgb(255, 0, 0)");
  			    		 Action doubleClick2 = action2.doubleClick(element2).build();
  				    	 doubleClick2.perform();// After performing double click Map will load
  				    	 Thread.sleep(3000);
  				    	 
  				    	String euroq = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Complications')]";
				    	 WebElement euroyes = driver.findElement(By.xpath(euroq));
						  euroyes.click();
  				    	
  				    	String b[][]= datap.getTableArray("C:\\QA\\InpatientComp.xls",1);
  				    	int loop=datap.rowcolumn("C:\\QA\\InpatientComp.xls",1);
  				    	Reporter.log("Row No="+loop,true);
  				    	 int brow=1;
  				      int bcol=0;
  				      Thread.sleep(2000);
  				    // for (int brow=1;brow<=loop;brow++)
  				    // {	 
  				    	driver.findElement(By.id("evaluation_date")).click();
  				    	driver.findElement(By.id("evaluation_date")).sendKeys("05032014");
  				    	driver.findElement(By.id("discharge_date")).click();
  				    	driver.findElement(By.id("discharge_date")).sendKeys("05032014");
  				    	String comyes = "//input[contains(@id, 'complications') and contains(@value, '1')]";
				    	 WebElement cyes = driver.findElement(By.xpath(comyes));
						  cyes.click();
						 				    	
  				    	driver.findElement(By.id("leakage_date")).click();
  				    	driver.findElement(By.id("leakage_date")).sendKeys("05032014");
  				    	driver.findElement(By.id("noted_by")).sendKeys("05032014");
  				    	driver.findElement(By.id("initials_day1")).sendKeys("22");
  				    	driver.findElement(By.id("initials_day2")).sendKeys("22");
  				    	driver.findElement(By.id("initials_day3")).sendKeys("22");
  				    	driver.findElement(By.id("initials_day4")).sendKeys("22");
  				    	driver.findElement(By.id("initials_day5")).sendKeys("22");
  				    	driver.findElement(By.id("initials_day6")).sendKeys("22");
  				    	driver.findElement(By.id("initials_day7")).sendKeys("22");
  				    	driver.findElement(By.id("initials_day8")).sendKeys("22");
  				    	//Clinical complications
  				    	if(driver.findElement(By.xpath(comyes)).isSelected())
  				    		
  				    	{
  				    	driver.findElement(By.xpath("/html/body/div[17]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[2]/a")).click();
  				    	
  				    	driver.findElement(By.id("dislocation")).click();
  				    	driver.findElement(By.id("dislocation_date")).click();
  				    	driver.findElement(By.id("dislocation_date")).sendKeys("05032013");
  				    	driver.findElement(By.id("dislocation_gp_surppress")).click();
  				    	driver.findElement(By.id("dislocation_hospital_name")).sendKeys("aaa");
  				    	dropdownselect("dislocation_antibiotics_dose","5mg");
  				    	dropdownselect("dislocation_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("dislocation_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("dislocation_comments")).sendKeys("22");

  				    	driver.findElement(By.id("periprosthetic_fracture")).click();
  				    	driver.findElement(By.id("periprosthetic_fracture_date")).click();
  				    	driver.findElement(By.id("periprosthetic_fracture_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("periprosthetic_fracture_gp_surppress")).click();
  				    	driver.findElement(By.id("periprosthetic_fracture_hospital_name")).sendKeys("bbb");
  				    	dropdownselect("periprosthetic_fracture_antibiotics_dose","5mg");
  				    	dropdownselect("periprosthetic_fracture_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("periprosthetic_fracture_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("periprosthetic_fracture_comments")).sendKeys("33");

  				    	driver.findElement(By.id("joint_infec")).click();
  				    	driver.findElement(By.id("joint_infec_date")).click();
  				    	driver.findElement(By.id("joint_infec_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("joint_infec_gp_surppress")).click();
  				    	driver.findElement(By.id("joint_infec_hospital_name")).sendKeys("ddd");
  				    	dropdownselect("joint_infec_antibiotics_dose","5mg");
  				    	dropdownselect("joint_infec_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("joint_infec_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("joint_infec_comments")).sendKeys("eee");
  				    	
  				    	driver.findElement(By.id("heart_attack")).click();
  				    	driver.findElement(By.id("heart_attack_date")).click();
  				    	driver.findElement(By.id("heart_attack_date")).sendKeys("07032014");
  				    	driver.findElement(By.id("heart_attack_gp_surppress")).click();
  				    	driver.findElement(By.id("heart_attack_hospital_name")).sendKeys("fff");
  				    	dropdownselect("heart_attack_antibiotics_dose","5mg");
  				    	dropdownselect("heart_attack_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("heart_attack_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("heart_attack_comments")).sendKeys("tester");
  				    	
  				    	
  				    	driver.findElement(By.id("pneumonia")).click();
  				    	driver.findElement(By.id("pneumonia_date")).click();
  				    	driver.findElement(By.id("pneumonia_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("pneumonia_gp_surppress")).click();
  				    	driver.findElement(By.id("pneumonia_hospital_name")).sendKeys("ggg");
  				    	dropdownselect("pneumonia_antibiotics_dose","5mg");
  				    	dropdownselect("pneumonia_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("pneumonia_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("pneumonia_comments")).sendKeys("hhh");

  				    	driver.findElement(By.id("stroke")).click();
  				    	driver.findElement(By.id("stroke_date")).click();
  				    	driver.findElement(By.id("stroke_date")).sendKeys("07032014");
  				    	driver.findElement(By.id("stroke_gp_surppress")).click();
  				    	driver.findElement(By.id("stroke_hospital_name")).sendKeys("iii");
  				    	dropdownselect("stroke_antibiotics_dose","5mg");
  				    	dropdownselect("stroke_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("stroke_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("stroke_comments")).sendKeys("tester");
  				    	
  				    	driver.findElement(By.id("wound_infec_super_deep")).click();
  				    	driver.findElement(By.id("wound_infec_super_deep_date")).click();
  				    	driver.findElement(By.id("wound_infec_super_deep_date")).sendKeys("05032014");
  				    	driver.findElement(By.id("wound_infec_super_deep_gp_surppress")).click();
  				    	driver.findElement(By.id("wound_infec_super_deep_hospital_name")).sendKeys("jjj");
  				    	dropdownselect("wound_infec_super_deep_antibiotics_dose","5mg");
  				    	dropdownselect("wound_infec_super_deep_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("wound_infec_super_deep_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("wound_infec_super_deep_comments")).sendKeys("testing");
  				    	
  				    	driver.findElement(By.id("wound_deep_infection")).click();
  				    	driver.findElement(By.id("wound_deep_infection_date")).click();
  				    	driver.findElement(By.id("wound_deep_infection_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("wound_deep_infection_gp_surppress")).click();
  				    	driver.findElement(By.id("wound_deep_infection_hospital_name")).sendKeys("kkk");
  				    	dropdownselect("wound_deep_infection_antibiotics_dose","5mg");
  				    	dropdownselect("wound_deep_infection_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("wound_deep_infection_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("wound_deep_infection_comments")).sendKeys("test test");
  				    	
  				    	driver.findElement(By.id("wound_delayed_infection")).click();
  				    	driver.findElement(By.id("wound_delayed_infection_date")).click();
  				    	driver.findElement(By.id("wound_delayed_infection_date")).sendKeys("05032014");
  				    	driver.findElement(By.id("wound_delayed_infection_gp_surppress")).click();
  				    	driver.findElement(By.id("wound_delayed_infection_hospital_name")).sendKeys("lll");
  				    	dropdownselect("wound_delayed_infection_antibiotics_dose","5mg");
  				    	dropdownselect("wound_delayed_infection_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("wound_delayed_infection_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("wound_delayed_infection_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("wound_dehiscene_infection")).click();
  				    	driver.findElement(By.id("wound_dehiscene_infection_date")).click();
  				    	driver.findElement(By.id("wound_dehiscene_infection_date")).sendKeys("04032014");
  				    	driver.findElement(By.id("wound_dehiscene_infection_gp_surppress")).click();
  				    	driver.findElement(By.id("wound_dehiscene_infection_hospital_name")).sendKeys("fsdf");
  				    	dropdownselect("wound_dehiscene_infection_antibiotics_dose","5mg");
  				    	dropdownselect("wound_dehiscene_infection_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("wound_dehiscene_infection_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("wound_dehiscene_infection_comments")).sendKeys("test");
  				    	
  				    	driver.findElement(By.id("deep_vein")).click();
  				    	driver.findElement(By.id("deep_vein_date")).click();
  				    	driver.findElement(By.id("deep_vein_date")).sendKeys("04032014");
  				    	driver.findElement(By.id("deep_vein_gp_surppress")).click();
  				    	driver.findElement(By.id("deep_vein_hospital_name")).sendKeys("ere");
  				    	dropdownselect("deep_vein_antibiotics_dose","5mg");
  				    	dropdownselect("deep_vein_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("deep_vein_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("deep_vein_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("pulmonary_embolism")).click();
  				    	driver.findElement(By.id("pulmonary_embolism_date")).click();
  				    	driver.findElement(By.id("pulmonary_embolism_date")).sendKeys("07032014");
  				    	driver.findElement(By.id("pulmonary_embolism_gp_surppress")).click();
  				    	driver.findElement(By.id("pulmonary_embolism_hospital_name")).sendKeys("dgdfg");
  				    	dropdownselect("pulmonary_embolism_antibiotics_dose","5mg");
  				    	dropdownselect("pulmonary_embolism_antibiotics_name","Cefuroxime");
			    	   	driver.findElement(By.id("pulmonary_embolism_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("pulmonary_embolism_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("myocardial_infrac")).click();
  				    	driver.findElement(By.id("myocardial_infrac_date")).click();
  				    	driver.findElement(By.id("myocardial_infrac_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("myocardial_infrac_gp_surppress")).click();
  				    	driver.findElement(By.id("myocardial_infrac_hospital_name")).sendKeys("fgdfg");
  				    	dropdownselect("myocardial_infrac_antibiotics_dose","5mg");
  				    	dropdownselect("myocardial_infrac_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("myocardial_infrac_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("myocardial_infrac_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("nerve_palsy")).click();
  				    	driver.findElement(By.id("nerve_palsy_date")).click();
  				    	driver.findElement(By.id("nerve_palsy_date")).sendKeys("04032014");
  				    	driver.findElement(By.id("nerve_palsy_gp_surppress")).click();
  				    	driver.findElement(By.id("nerve_palsy_hospital_name")).sendKeys("fdgds");
  				    	dropdownselect("nerve_palsy_antibiotics_dose","5mg");
  				    	dropdownselect("nerve_palsy_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("nerve_palsy_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("nerve_palsy_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("urine_water_doctor")).click();
  				    	driver.findElement(By.id("urine_water_doctor_date")).click();
  				    	driver.findElement(By.id("urine_water_doctor_date")).sendKeys("05032014");
  				    	driver.findElement(By.id("urine_water_doctor_gp_surppress")).click();
  				    	driver.findElement(By.id("urine_water_doctor_hospital_name")).sendKeys("dgdgd");
  				    	dropdownselect("urine_water_doctor_antibiotics_dose","5mg");
  				    	dropdownselect("urine_water_doctor_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("urine_water_doctor_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("urine_water_doctor_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("wound_harmatoma")).click();
  				    	driver.findElement(By.id("wound_harmatoma_date")).click();
  				    	driver.findElement(By.id("wound_harmatoma_date")).sendKeys("04032014");
  				    	driver.findElement(By.id("wound_harmatoma_gp_surppress")).click();
  				    	driver.findElement(By.id("wound_harmatoma_hospital_name")).sendKeys("dfgdjg");
  				    	dropdownselect("wound_harmatoma_antibiotics_dose","5mg");
  				    	dropdownselect("wound_harmatoma_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("wound_harmatoma_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("wound_harmatoma_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("infections")).click();
  				    	driver.findElement(By.id("infections_date")).click();
  				    	driver.findElement(By.id("infections_date")).sendKeys("05032014");
  				    	driver.findElement(By.id("infections_gp_surppress")).click();
  				    	driver.findElement(By.id("infections_hospital_name")).sendKeys("dfdfd");
  				    	dropdownselect("infections_antibiotics_dose","5mg");
  				    	dropdownselect("infections_antibiotics_name","Cefuroxime");
  				      	driver.findElement(By.id("infections_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("infections_comments")).sendKeys("test");
  				    	
  				    	driver.findElement(By.id("joint_other_complications")).click();
  				    	driver.findElement(By.id("joint_other_complications_date")).click();
  				    	driver.findElement(By.id("joint_other_complications_date")).sendKeys("gdgjdfg");
  				    	driver.findElement(By.id("joint_other_complications_gp_surppress")).click();
  				    	driver.findElement(By.id("joint_other_complications_hospital_name")).sendKeys("were");
  				    	dropdownselect("joint_other_complications_antibiotics_dose","5mg");
  				    	dropdownselect("joint_other_complications_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("joint_other_complications_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("joint_other_complications_comments")).sendKeys("ghgdf");
  				    	
  				    	driver.findElement(By.id("medical_other_complications")).click();
  				    	driver.findElement(By.id("medical_other_complications_date")).click();
  				    	driver.findElement(By.id("medical_other_complications_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("medical_other_complications_gp_surppress")).click();
  				    	driver.findElement(By.id("medical_other_complications_hospital_name")).sendKeys("dgfkfsdfj");
  				    	dropdownselect("medical_other_complications_antibiotics_dose","5mg");
  				    	dropdownselect("medical_other_complications_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("medical_other_complications_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("medical_other_complications_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("patella_subluxation")).click();
  				    	driver.findElement(By.id("patella_subluxation_date")).click();
  				    	driver.findElement(By.id("patella_subluxation_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("patella_subluxation_gp_surppress")).click();
  				    	driver.findElement(By.id("patella_subluxation_hospital_name")).sendKeys("sdfsdf");
  				    	dropdownselect("patella_subluxation_antibiotics_dose","5mg");
  				    	dropdownselect("patella_subluxation_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("patella_subluxation_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("patella_subluxation_comments")).sendKeys("dgdfg");
  				    	
  				    	driver.findElement(By.id("retropatellar_pain_patella")).click();
  				    	driver.findElement(By.id("retropatellar_pain_patella_date")).click();
  				    	driver.findElement(By.id("retropatellar_pain_patella_date")).sendKeys("05032014");
  				    	driver.findElement(By.id("retropatellar_pain_patella_gp_surppress")).click();
  				    	driver.findElement(By.id("retropatellar_pain_patella_hospital_name")).sendKeys("gfsdgfd");
  				    	dropdownselect("retropatellar_pain_patella_antibiotics_dose","5mg");
  				    	dropdownselect("retropatellar_pain_patella_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("retropatellar_pain_patella_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("retropatellar_pain_patella_comments")).sendKeys("sfsfx");
  				    	
  				    	driver.findElement(By.id("clinical_complication_other")).click();
  				    	driver.findElement(By.id("clinical_complication_other_date")).click();
  				    	driver.findElement(By.id("clinical_complication_other_date")).sendKeys("07032014");
  				    	driver.findElement(By.id("clinical_complication_other_gp_surppress")).click();
  				    	driver.findElement(By.id("clinical_complication_other_hospital_name")).sendKeys("gdfgfdg");
  				    	dropdownselect("clinical_complication_other_antibiotics_dose","5mg");
  				    	dropdownselect("clinical_complication_other_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("clinical_complication_other_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("clinical_complication_other_comments")).sendKeys();
  				    	
  				    	//driver.findElement(By.id("//Device related complications
  				    	driver.findElement(By.xpath("/html/body/div[17]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[3]/a")).click();
  				    	
  				    	driver.findElement(By.id("device_subluxation_dislocation")).click();
  				    	driver.findElement(By.id("device_subluxation_dislocation_date")).click();
  				    	driver.findElement(By.id("device_subluxation_dislocation_date")).sendKeys("08032014");
  				    	driver.findElement(By.id("device_subluxation_dislocation_gp_surppress")).click();
  				    	driver.findElement(By.id("device_subluxation_dislocation_hospital_name")).sendKeys("gdsgfsdg");
  				    	dropdownselect("device_subluxation_dislocation_antibiotics_dose","5mg");
  				    	dropdownselect("device_subluxation_dislocation_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_subluxation_dislocation_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_subluxation_dislocation_comments")).sendKeys("sdsdf");
  				    	
  				    	driver.findElement(By.id("device_acetabular_complication")).click();
  				    	driver.findElement(By.id("device_acetabular_complication_date")).click();
  				    	driver.findElement(By.id("device_acetabular_complication_date")).sendKeys("05032014");
  				    	driver.findElement(By.id("device_acetabular_complication_gp_surppress")).click();
  				    	driver.findElement(By.id("device_acetabular_complication_hospital_name")).sendKeys("gdgd");
  				    	dropdownselect("device_acetabular_complication_antibiotics_dose","5mg");
  				    	dropdownselect("device_acetabular_complication_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_acetabular_complication_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_acetabular_complication_comments")).sendKeys("trrgtr");
  				    	
  				    	driver.findElement(By.id("device_femoral_fracture")).click();
  				    	driver.findElement(By.id("device_femoral_fracture_date")).click();
  				    	driver.findElement(By.id("device_femoral_fracture_date")).sendKeys("07032014");
  				    	driver.findElement(By.id("device_femoral_fracture_gp_surppress")).click();
  				    	driver.findElement(By.id("device_femoral_fracture_hospital_name")).sendKeys("fsfsf");
  				    	dropdownselect("device_femoral_fracture_antibiotics_dose","5mg");
  				    	dropdownselect("device_femoral_fracture_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_femoral_fracture_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_femoral_fracture_comments")).sendKeys("tester");
  				    	
  				    	driver.findElement(By.id("device_acetabular_comp_losing")).click();
  				    	driver.findElement(By.id("device_acetabular_comp_losing_date")).click();
  				    	driver.findElement(By.id("device_acetabular_comp_losing_date")).sendKeys("04032014");
  				    	driver.findElement(By.id("device_acetabular_comp_losing_gp_surppress")).click();
  				    	driver.findElement(By.id("device_acetabular_comp_losing_hospital_name")).sendKeys("dtdstd");
  				    	dropdownselect("device_acetabular_comp_losing_antibiotics_dose","5mg");
  				    	dropdownselect("device_acetabular_comp_losing_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_acetabular_comp_losing_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_acetabular_comp_losing_comments")).sendKeys("sdfsdf");
  				    	
  				    	driver.findElement(By.id("device_famoral_comp_failure")).click();
  				    	driver.findElement(By.id("device_famoral_comp_failure_date")).click();
  				    	driver.findElement(By.id("device_famoral_comp_failure_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("device_famoral_comp_failure_gp_surppress")).click();
  				    	driver.findElement(By.id("device_famoral_comp_failure_hospital_name")).sendKeys("fsdfsd");
  				    	dropdownselect("device_famoral_comp_failure_antibiotics_dose","5mg");
  				    	dropdownselect("device_famoral_comp_failure_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_famoral_comp_failure_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_famoral_comp_failure_comments")).sendKeys("ffsfsf");
  				    	
  				    	/*driver.findElement(By.id("device_famoral_comp_failure")).click();
  				    	driver.findElement(By.id("device_famoral_comp_failure_date")).click();
  				    	driver.findElement(By.id("device_famoral_comp_failure_date")).sendKeys("04032014");
  				    	driver.findElement(By.id("device_famoral_comp_failure_gp_surppress")).click();
  				    	driver.findElement(By.id("device_famoral_comp_failure_hospital_name")).sendKeys("dsfsdf");
  				    	dropdownselect("device_famoral_comp_failure_antibiotics_dose","5mg");
  				    	dropdownselect("device_famoral_comp_failure_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_famoral_comp_failure_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_famoral_comp_failure_comments")).sendKeys();*/
  				    	
  				    	driver.findElement(By.id("device_trauma_operative")).click();
  				    	driver.findElement(By.id("device_trauma_operative_date")).click();
  				    	driver.findElement(By.id("device_trauma_operative_date")).sendKeys("07032014");
  				    	driver.findElement(By.id("device_trauma_operative_gp_surppress")).click();
  				    	driver.findElement(By.id("device_trauma_operative_hospital_name")).sendKeys("fsdfsf");
  				    	dropdownselect("device_trauma_operative_antibiotics_dose","5mg");
  				    	dropdownselect("device_trauma_operative_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_trauma_operative_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_trauma_operative_comments")).sendKeys();
  				    	
  				    	driver.findElement(By.id("device_femoral_comp_losing")).click();
  				    	driver.findElement(By.id("device_femoral_comp_losing_date")).click();
  				    	driver.findElement(By.id("device_femoral_comp_losing_date")).sendKeys("06032014");
  				    	driver.findElement(By.id("device_femoral_comp_losing_gp_surppress")).click();
  				    	driver.findElement(By.id("device_femoral_comp_losing_hospital_name")).sendKeys("sfsdf");
  				    	dropdownselect("device_femoral_comp_losing_antibiotics_dose","5mg");
  				    	dropdownselect("device_femoral_comp_losing_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_femoral_comp_losing_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_femoral_comp_losing_comments")).sendKeys("dfgfdfsdfg");
  				    	
  				    	driver.findElement(By.id("device_preop_femoral_fracture")).click();
  				    	driver.findElement(By.id("device_preop_femoral_fracture_date")).click();
  				    	driver.findElement(By.id("device_preop_femoral_fracture_date")).sendKeys("07032014");
  				    	driver.findElement(By.id("device_preop_femoral_fracture_gp_surppress")).click();
  				    	driver.findElement(By.id("device_preop_femoral_fracture_hospital_name")).sendKeys("fsfsf");
  				    	dropdownselect("device_preop_femoral_fracture_antibiotics_dose","5mg");
  				    	dropdownselect("device_preop_femoral_fracture_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_preop_femoral_fracture_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_preop_femoral_fracture_comments")).sendKeys("sfsfs");
  				    	
  				    	driver.findElement(By.id("device_other_specify")).click();
  				    	driver.findElement(By.id("device_other_specify_date")).click();
  				    	driver.findElement(By.id("device_other_specify_date")).sendKeys("08032014");
  				    	driver.findElement(By.id("device_other_specify_gp_surppress")).click();
  				    	driver.findElement(By.id("device_other_specify_hospital_name")).sendKeys("fhwjsd");
  				    	dropdownselect("device_other_specify_antibiotics_dose","5mg");
  				    	dropdownselect("device_other_specify_antibiotics_name","Cefuroxime");
  				    	driver.findElement(By.id("device_other_specify_cc_nature_treament1")).click();
  				    	driver.findElement(By.id("device_other_specify_comments")).sendKeys("fsfsfhsf");
  				    	
  				    	//Device removal
  				    	driver.findElement(By.xpath("/html/body/div[17]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[4]/a")).click();
  				    	driver.findElement(By.id("revision_date")).click();
  				    	driver.findElement(By.id("revision_date")).sendKeys("04032014");
  				    	driver.findElement(By.id("devremoval_total_knee")).click();
  				    	driver.findElement(By.id("devremoval_femoral_component")).click();
  				    	driver.findElement(By.id("devremoval_tibial_component")).click();
  				    	driver.findElement(By.id("devremoval_tibial_insert")).click();
  				    	driver.findElement(By.id("devremoval_patellar_component")).click();
  				    	driver.findElement(By.id("devremoval_implant_reason")).click();
  				    	
  				    	//Termination
  				    	driver.findElement(By.xpath("/html/body/div[17]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[5]/a")).click();
  				    	dropdownselect("termination","None");
  				    	
  				    	driver.findElement(By.id("date_assessment")).click();
  				    	driver.findElement(By.id("date_assessment")).sendKeys("06032014");
  				    	driver.findElement(By.id("date_termination")).click();
  				    	driver.findElement(By.id("date_termination")).sendKeys("06032014");
  				    	//SAE & comments
  				    	driver.findElement(By.xpath("/html/body/div[17]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[6]/a")).click();
  				    	driver.findElement(By.id("sae")).click();
  				    	driver.findElement(By.id("susar")).click();
  				    	driver.findElement(By.id("sponser")).click();
  				    	driver.findElement(By.id("sponser")).sendKeys("03032014");
  				    	driver.findElement(By.id("sponser_initial")).sendKeys("aa");
  				    	driver.findElement(By.id("investigating_centre")).click();
  				    	driver.findElement(By.id("investigating_centre")).sendKeys("04032014");
  				    	driver.findElement(By.id("investigating_centre_initial")).sendKeys("bb");
  				    	driver.findElement(By.id("ethics")).click();
  				    	driver.findElement(By.id("ethics")).sendKeys("06032014");
  				    	driver.findElement(By.id("ethics_initial")).sendKeys("ccc");
  				    	
  				    	driver.findElement(By.id("comments")).sendKeys("Testing comments");
  				    	driver.findElement(By.id("service_satisfy")).sendKeys("55");
  				    	driver.findElement(By.id("outcome_satisfy")).sendKeys("66");
  				    	}//end of Complication Yes IF loop		

			    	 
  				    	 
  				    	 
				      
  				     //}//end of loop For repeated recors from excel
  				 					
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
    public void dropdownselect(String a,String b)
    {
    	Select ostatus = new Select(driver.findElement(By.id(a)));
	  	ostatus.selectByVisibleText(b);
    }
}


  





