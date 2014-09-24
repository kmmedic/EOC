 package imedortho;


  import java.io.File;

  import jxl.Workbook;

  import jxl.write.WritableSheet;

  import jxl.write.WritableWorkbook;

  import jxl.write.Label;

  import jxl.write.WriteException;



  public class excelwrite1 {


      static Workbook wbook;

      static WritableWorkbook wwbCopy;

      static String ExecutedTestCasesSheet;

      static WritableSheet shSheet;

      

      public void readExcel(String path,int strSheetName,int iColumnNumber,int iRowNumber,String strData)

      {

      try{

      wbook = Workbook.getWorkbook(new File(path));

      wwbCopy = Workbook.createWorkbook(new File(path), wbook);

      shSheet = wwbCopy.getSheet(0);
      
      WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);

      Label labTemp = new Label(iColumnNumber, iRowNumber, strData);
      wshTemp.addCell(labTemp);
      
      wwbCopy.write();

      wwbCopy.close();


      // Closing the original work book

      wbook.close();

      }

      catch(Exception e)

      {

          e.printStackTrace();

      }

      }

           

    }

  