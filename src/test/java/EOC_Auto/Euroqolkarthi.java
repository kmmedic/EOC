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
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Euroqolkarthi {
	
	DataProv datap = new DataProv();
	
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
  	  	Thread.sleep(2000);
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
  		    	  if(sd.matches("test"))
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
  		    	 
  		    	if(tdate.matches("08-08-2014") && tname.matches("Right  Knee  Replacement"))
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
    			    		// assertEquals(colort,"rgb(255, 0, 0)");
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
		Object[][] retObjArr=datap.getTableArray("C:\\QAA\\BaselineHip1.xls",1);
        return(retObjArr);
        
	}

    
    @Test(dataProvider="data-provider")
    public void add(String Filling,String Filling_Yes,String Living_arrangement,String how_long,String previous,String pain,String wash_drying,String public_trans,String walking,String after_a_meal,String limbing,String kneel_down,String bed_at_night,String usual_work,String give_way,String household_shopping,String flight_of_stairs,String oxford_comment,String euroqol1,String euro2,String euro3,String euro4,String euro5,String health,String euro_comments,String height,String weight,String ASA,String doctor,String today_date,String disability,String influence,String medical) throws Exception,InterruptedException, BiffException, IOException,WebDriverException  {
  	
  	//setup(); 	
  	WebDriverWait wait = new WebDriverWait(driver,05);
	  	  	
  	Thread.sleep(3000);
  				    	String euroq = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Euro QOL EQ5D')]";
				    	 WebElement euroyes = driver.findElement(By.xpath(euroq));
						  euroyes.click();
						  Thread.sleep(2000);
  				    	 
  					  driver.findElement(By.id("mobility"+euroqol1)).click();
  					  String pain_discomfort = "//input[contains(@id, 'pain_discomfort') and contains(@value,"+euro2+" )]";
  					  WebElement painyes = driver.findElement(By.xpath(pain_discomfort));
  					  painyes.click();
  				    
  					  String selfcare = "//input[contains(@id, 'self_care') and contains(@value, "+euro3+")]";
					  WebElement selfyes = driver.findElement(By.xpath(selfcare));
					  selfyes.click();
					  String anxiety = "//input[contains(@id, 'anxiety_depression') and contains(@value, "+euro4+")]";
  					  WebElement anxietyyes = driver.findElement(By.xpath(anxiety));
  					  anxietyyes.click();
  					  String usuala = "//input[contains(@id, 'usual_activities') and contains(@value, "+euro5+")]";
					  WebElement usualyes = driver.findElement(By.xpath(usuala));
					  usualyes.click();
					  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/table/tbody/tr[8]/td[2]")).click();
					  Thread.sleep(3500);
					  			  
					  driver.findElement(By.id("health_state")).clear();
  					  driver.findElement(By.id("health_state")).sendKeys(health);
  					driver.findElement(By.id("comments")).clear();
  					  driver.findElement(By.id("comments")).sendKeys(euro_comments);
  					  driver.findElement(By.id("cmd_eq5d_save")).click();
  					  
  					  Thread.sleep(2000);
  					Alert alert21 = driver.switchTo().alert();
			         String AlertText21 = alert21.getText();
			         System.out.println(AlertText21);
			         Assert.assertEquals("Are you sure you want to copy the score to other treatment?", AlertText21);
			          alert21.accept();
  					  
  					  String scr=driver.findElement(By.id("txt_eq5d")).getAttribute("value");
  					  float scr1=Float.parseFloat(scr);
  					  int eqol1=Integer.parseInt(euroqol1);
  					  int eqol2=Integer.parseInt(euro2);
  					int eqol3=Integer.parseInt(euro3);
  					int eqol4=Integer.parseInt(euro4);
  					int eqol5=Integer.parseInt(euro5);
  					System.out.println("Score="+scr);
  					
  					if(eqol1>0 && eqol2>0 && eqol3>0 && eqol4>0 && eqol5>0 )
  					{
  						Assert.assertTrue(scr1!=0);
  					}
  					wait.until(ExpectedConditions.elementToBeClickable(By.id("cmd_eq5d_delete")));		    	 
  	  		    	 driver.findElement(By.id("cmd_eq5d_delete")).click();
  	  		    	 
  	  		    	
  	  		    	 Thread.sleep(1000);
  	  		    	 driver.findElement(By.id("btn-ok")).click();
  	  		    	 
  	  		    	//driver.findElement(By.xpath("/html/body/div[2]/div")).wait();
  	  		    	 Thread.sleep(1000);
  	  		    
  	  		    	 try{
  			          
  			        Alert alert1 = driver.switchTo().alert();
 			         String AlertText1 = alert1.getText();
 			         System.out.println(AlertText1);
 			         Assert.assertEquals("EuroQol Details deleted successfully", AlertText1);
 			          alert1.accept();
 			          			          
 			          Thread.sleep(1000);
  	  		    	 }catch(WebDriverException we){}
 			          
 					 
  					
    }
    }


  



