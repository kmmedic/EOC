package EOC_Auto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import junit.framework.Assert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PatTreatmentAdd_GS {
  @Test
  public void add() throws InterruptedException, BiffException, IOException {
	  WebDriver driver = new FirefoxDriver();
	   FileInputStream fi=new FileInputStream("C:\\QA\\inputdata.xls");
	   Workbook w=Workbook.getWorkbook(fi);
	   Sheet s=w.getSheet(1);
	   String a[][] = new String[s.getRows()][s.getColumns()];
	   int row=s.getRows();
	 //for all input sheet rows, write to new Results workbook with Result column appended
	   for (int i = 0; i < s.getRows(); i++)
	   {
	   //System.out.println("Current row: " + i + " reading s.getColumns: " + s.getColumns());
	   // for all inputsheet columns
	   for (int j = 0; j < s.getColumns(); j++)
	   {
	   	a[i][j] = s.getCell(j,i).getContents();
	   	  
	   System.out.println("Value Of i is "+i+"Value of j is "+j+"Value of A is "+a[i][j]);
	   }
	   }

	  	driver.get("http://192.168.1.240:8800/indira_p/eoc");
	  	driver.manage().window().maximize();
	  	driver.findElement(By.id("username")).clear();
	  	driver.findElement(By.id("username")).sendKeys("admin");
	  	driver.findElement(By.id("password")).clear();
	  	driver.findElement(By.id("password")).sendKeys("a");
	  	driver.findElement(By.id("btLogin")).click();
	  	//Selecting Patients
	  	driver.findElement(By.className("StudyText")).click();
	  	Thread.sleep(3000);
	  	driver.findElement(By.className("cls_header_patient")).click();
	  	Thread.sleep(2000);
	  	driver.findElement(By.id("SearchBox")).click();
	  	driver.findElement(By.id("SearchBox")).sendKeys(a[0][0]);
	  	Thread.sleep(2000);
	  	driver.findElement(By.id("btn_global_search")).click();
	  	Thread.sleep(3000);
	  	driver.findElement(By.className("clsaddtreatmentcurrentstudy")).click();
	  	Thread.sleep(3000);	  		  	
	  	driver.findElement(By.className("clsapp_pat_treatment")).click();
	  	Thread.sleep(3000);
	  	driver.findElement(By.className("add")).click();
	  	Thread.sleep(3000);
	  	Select bpart = new Select(driver.findElement(By.id("body_part")));
	  	bpart.selectByVisibleText(a[0][1]);
	  	Select bside = new Select(driver.findElement(By.id("side")));
	  	bside.selectByVisibleText(a[0][2]);
	  	Select trmt1 = new Select(driver.findElement(By.id("treatment")));
	  	trmt1.selectByVisibleText(a[0][3]);
	  	driver.findElement(By.id("start_date")).click();
	  	driver.findElement(By.id("start_date")).sendKeys(a[0][4]);;
	  	Select prev = new Select(driver.findElement(By.id("primary_revision")));
	  	prev.selectByVisibleText(a[0][5]);
	  	Select stype = new Select(driver.findElement(By.id("sub_type")));
	  	stype.selectByVisibleText(a[0][6]);
     	driver.findElement(By.id("primary_op_consultant")).sendKeys(a[0][7]);
     	Select cons = new Select(driver.findElement(By.id("consultant")));
	  	cons.selectByVisibleText(a[0][8]);
	  	driver.findElement(By.id("principle_diagonsis")).sendKeys(a[0][9]);
	  	//Select pdiag = new Select(driver.findElement(By.className("dhx_combo_box")));
	  	//pdiag.selectByVisibleText("Left Lateral Meniscal Tear");
	  	driver.findElement(By.id("secondary_diagonsis")).sendKeys(a[0][10]);
	  	//Select sdiag = new Select(driver.findElement(By.className("dhx_combo_box")));
	  	//sdiag.selectByVisibleText("Right Lateral Menical Cyst");
	  	driver.findElement(By.id("teritiary_diagnosis")).sendKeys(a[0][11]);
	  	//Select tdiag = new Select(driver.findElement(By.className("dhx_combo_box")));
	  	//tdiag.selectByVisibleText("Torn Right Anterior Cruciate Ligament");
	  	Select ostatus = new Select(driver.findElement(By.id("outcome_status")));
	  	ostatus.selectByVisibleText(a[0][12]);
	  	driver.findElement(By.id("status_date")).click();
	  	driver.findElement(By.id("status_date")).sendKeys(a[0][13]);
	  	Select oreason = new Select(driver.findElement(By.id("op_rev_reason")));
	  	oreason.selectByVisibleText(a[0][14]);
	  	Select lcomp = new Select(driver.findElement(By.id("looser_component")));
	  	lcomp.selectByVisibleText(a[0][15]);
	  	
	  	driver.findElement(By.id("odep_study")).sendKeys(a[0][16]);
	  	driver.findElement(By.id("other_studies")).sendKeys(a[0][17]);
	  	driver.findElement(By.id("ex_sys_id")).sendKeys(a[0][18]);
	  	driver.findElement(By.id("consent_taken")).click();
	  	driver.findElement(By.id("consent_taken")).sendKeys(a[0][19]);;
	  	driver.findElement(By.id("consent_by")).sendKeys(a[0][20]);
	  	driver.findElement(By.id("comments")).sendKeys(a[0][21]);
	  	driver.findElement(By.id("cmd_treatment_save")).click();
	  	      
	   }
}

