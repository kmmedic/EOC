package EOC_Auto;

import java.io.File;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class DataProviderAdd {
   @DataProvider(name = "data-provider", parallel = false)
public String[][] getTableArray(String xlFilePath,int sheetno) throws Exception{
    String[][] tabArray=null;
    
        Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
        Sheet wrksheet = workbook.getSheet(sheetno);
       
        String[][] tabdata = new String[wrksheet.getRows()][wrksheet.getColumns()];

			System.out.println("Total Rows: " + wrksheet.getRows());
			System.out.println("Total Columns: " + wrksheet.getColumns());
			for (int i = 0; i < wrksheet.getRows(); i++) {

				for (int j = 0; j < wrksheet.getColumns(); j++) {
				tabdata[i][j] = wrksheet.getCell(j, i).getContents();
                System.out.println("Row="+i+"Column="+j+"elemet ---- "+tabdata[i][j]);
             
				}
			}
	        return(tabdata);
			
	}
   
   public int rowcolumn(String xlFilePath,int sheetno) throws Exception{
	    int row=0;
	    int column=0;
	    
	        Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	        Sheet wrksheet = workbook.getSheet(sheetno);
	       
	        String[][] tabdata = new String[wrksheet.getRows()][wrksheet.getColumns()];

				System.out.println("Total Rows: " + wrksheet.getRows());
				int frow=wrksheet.getRows();
				System.out.println("Total Columns: " + wrksheet.getColumns());
				for (int i = 0; i < wrksheet.getRows(); i++) {

					for (int j = 0; j < wrksheet.getColumns(); j++) {
					tabdata[i][j] = wrksheet.getCell(j, i).getContents();
	                System.out.println("Row="+i+"Column="+j+"elemet ---- "+tabdata[i][j]);
	             
					}
				}
		        return(frow);
				
		}

}

/*public class DataProviderAdd {
	   @DataProvider(name = "data-provider", parallel = false)
		public Object[][] data() throws Exception {
			 Object[][] retObjArr=getTableArray("C:\\QA\\inputdata.xls");
	    return(retObjArr);
		}

	public String[][] getTableArray(String xlFilePath) throws Exception{
	    String[][] tabArray=null;
	    
	        Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	        Sheet wrksheet = workbook.getSheet(0);
	       
	        String tabdata[][] = new String[wrksheet.getRows()][wrksheet.getColumns()];

				System.out.println("Total Rows: " + wrksheet.getRows());
				System.out.println("Total Columns: " + wrksheet.getColumns());
				for (int i = 0; i < wrksheet.getRows(); i++) {

					for (int j = 0; j < wrksheet.getColumns(); j++) {
					tabdata[i][j] = wrksheet.getCell(j, i).getContents();
	              System.out.println("elemet ---- "+tabdata[i][j]);			
					}
				}
		        return(tabdata);
		}

	}*/

