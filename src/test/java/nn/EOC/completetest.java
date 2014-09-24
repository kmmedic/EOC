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

public class completetest {
  
  
	  WebDriver driver = new FirefoxDriver();
	  DataProviderAdd datap = new DataProviderAdd();
	  WebDriverWait wait = new WebDriverWait(driver,05);
	  @Test
    public void add() throws InterruptedException, BiffException, IOException {
	  
	   FileInputStream fi=new FileInputStream("C:\\QA\\TrmtDetails.xls");
	   Workbook w=Workbook.getWorkbook(fi);
	   Sheet s=w.getSheet(0);
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

	  	driver.get("http://192.168.1.246/main");
	  	driver.manage().window().maximize();
	  	driver.findElement(By.id("username")).clear();
	  	driver.findElement(By.id("username")).sendKeys("admin");
	  	driver.findElement(By.id("password")).clear();
	  	driver.findElement(By.id("password")).sendKeys("a");
	  	driver.findElement(By.id("btLogin")).click();
	  	//Selecting Patients
	  	//driver.findElement(By.className("StudyText")).click();
	  	//Selecting MRK study
	  	driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]")).click();
	  	Thread.sleep(3000);
	  	driver.findElement(By.className("cls_header_patient")).click();
	  	Thread.sleep(2000);
	  	driver.findElement(By.id("SearchBox")).click();
	  	driver.findElement(By.id("SearchBox")).sendKeys(a[1][0]);
	  	Thread.sleep(2000);
	  	driver.findElement(By.className("btnStudySearch")).click();
	  	Thread.sleep(500);
	  	
	  	WebElement table = driver.findElement(By.className("flex_patient"));
	  	List<WebElement> tagname1 = table.findElements(By.tagName("tr"));
	  	
	  		Thread.sleep(3000);
				 Actions action = new Actions(driver);
		    	 WebElement element = table.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr/td/div"));
		    	 String sd=table.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr/td/div")).getText();
		    	 Reporter.log("SD="+sd+"-------------",true);
		    	 	 if(sd.matches("Matthew"))
		    	 {
		    		 Reporter.log("SD="+sd,true);
		    	  Action doubleClick = action.doubleClick(element).build();
		    	 doubleClick.perform();// After performing double click Map will load
		    	 
		    	 wait.until(ExpectedConditions.elementToBeClickable(By.className("clsapp_pat_treatment")));		    	 
		    	 driver.findElement(By.className("clsapp_pat_treatment")).click();
		    	 
		    	 Thread.sleep(3000);
		 	  	driver.findElement(By.className("add")).click();
		 	  	Thread.sleep(3000);
	  	
	  	Select centre = new Select(driver.findElement(By.id("center_ref")));
	  	centre.selectByVisibleText(a[1][1]);
	  	driver.findElement(By.id("center_ref_text")).sendKeys(a[1][2]);
	  	Select bpart = new Select(driver.findElement(By.id("body_part")));
	  	bpart.selectByVisibleText(a[1][4]);
	  	Select bside = new Select(driver.findElement(By.id("side")));
	  	bside.selectByVisibleText(a[1][3]);
	  	Select trmt1 = new Select(driver.findElement(By.id("treatment")));
	  	trmt1.selectByVisibleText(a[1][5]);
	  	driver.findElement(By.id("start_date")).click();
	  	driver.findElement(By.id("start_date")).sendKeys(a[1][6]);
	  	/*Select prev = new Select(driver.findElement(By.id("primary_revision")));
	  	prev.selectByVisibleText(a[0][7]);
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
	  	driver.findElement(By.id("comments")).sendKeys(a[0][21]);*/
	  	driver.findElement(By.id("cmd_treatment_save")).click();
	  	Thread.sleep(2000); 
		    	 }
	  	}
  @Test(dependsOnMethods = "add")
  public void euroadd()  throws Exception
  {
	  String a[][]= datap.getTableArray("C:\\QA\\PatTrmtList.xls",0);
	  int i =1; 
		int row=1;
		int col=0;
	//Getting list of treatment under treatment tab
   	 Thread.sleep(3000);
   	driver.findElement(By.className("clsapp_pat_treatment")).click();
   	Thread.sleep(3000);
   	 WebElement trmtlist = driver.findElement(By.className("flex_treatment"));
	  	List<WebElement> tagname2 = trmtlist.findElements(By.tagName("tr"));
	  	Reporter.log("size of the treatment list "+tagname2.size(),true);
	  	 
	  int j =2;    
	  
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
    	 
    	//if(tdate.matches(a[row][col+2]) && tname.matches(a[row][col+1]))
    	 if( tname.matches("Left Knee Replacement"))
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
	    	 
	    	 if(rname.equals("6 month review"))
	    	 {
	    		 String colort=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getCssValue("Color");
	    		 Reporter.log("Color="+colort,true);
	    		 assertEquals(colort,"rgb(255, 0, 0)");
	    		 Action doubleClick2 = action2.doubleClick(element2).build();
		    	 doubleClick2.perform();// After performing double click Map will load
		    	 Thread.sleep(3000);
		    	 
		    	String euroq = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Euro QOL EQ5D')]";
		    	 WebElement euroyes = driver.findElement(By.xpath(euroq));
				  euroyes.click();
		    	
		    	String b[][]= datap.getTableArray("C:\\QA\\BaselineHip.xls",1);
		      int brow=1;
		      int bcol=18;
		      Thread.sleep(2000);
		        					  
			  driver.findElement(By.id("mobility"+b[brow][bcol])).click();
			  String pain_discomfort = "//input[contains(@id, 'pain_discomfort') and contains(@value,"+b[brow][bcol+1]+" )]";
			  WebElement painyes = driver.findElement(By.xpath(pain_discomfort));
			  painyes.click();
			  String selfcare = "//input[contains(@id, 'self_care') and contains(@value, "+b[brow][bcol+2]+")]";
			  WebElement selfyes = driver.findElement(By.xpath(selfcare));
			  selfyes.click();
			  String anxiety = "//input[contains(@id, 'anxiety_depression') and contains(@value, "+b[brow][bcol+3]+")]";
			  WebElement anxietyyes = driver.findElement(By.xpath(anxiety));
			  anxietyyes.click();
			  String usuala = "//input[contains(@id, 'usual_activities') and contains(@value, "+b[brow][bcol+4]+")]";
			  WebElement usualyes = driver.findElement(By.xpath(usuala));
			  usualyes.click();
			  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/table/tbody/tr[8]/td[2]")).click();
			  Thread.sleep(3500);
			  int b1=Integer.parseInt(b[brow][bcol]);
			  int b2=Integer.parseInt(b[brow][bcol+1]);
			  int b3=Integer.parseInt(b[brow][bcol+2]);
			  int b4=Integer.parseInt(b[brow][bcol+3]);
			  int b5=Integer.parseInt(b[brow][bcol+4]);
			  
			  
			  if(b1>0 && b2>0 && b3>0 && b4>0 && b5>0)
			  {
				  //int st=Integer.parseInt(driver.findElement(By.id("txt_eq5d")).getAttribute("Value"));
				 // assertTrue(st!=0);
				  
			  }
			  driver.findElement(By.id("health_state")).sendKeys(b[brow][bcol+5]);
			  driver.findElement(By.id("comments")).sendKeys(b[brow][bcol+6]);
			  driver.findElement(By.id("cmd_eq5d_save")).click();
			 
			  
			 
			break;
		    	 }
	    	 k++;
  	   	 
		}//end of review list FOR loop
		 break;
		
	 }//end of treatment list IF loop*/
  	j++;
		}//end of treatment list FOR loop
  }
  
  
}


