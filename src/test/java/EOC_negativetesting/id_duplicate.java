package EOC_negativetesting;

import java.io.BufferedReader;
import java.io.FileReader;

import org.testng.annotations.Test;

public class id_duplicate 
{
	
   public static void main(String[] args) 
   {
	   String[] id_arr=new String[10000];
	   String[] name_gp=new String[10000];
	   String[] value_gp=new String[10000];
   System.out.println("Reading File from Java code");
   //Name of the file
   String fileName="C:\\QAA\\acl_hagosenglish_addedit.php";
   try{

   //Create object of FileReader
   FileReader inputFile = new FileReader(fileName);

   //Instantiate the BufferedReader Class
   BufferedReader bufferReader = new BufferedReader(inputFile);

   //Variable to hold the one line data
   String line;

   // Read file line by line and print on the console
   int i=0;
   int j=0;
      while ((line = bufferReader.readLine()) != null)   {
          
	          //check if the next line contains the key word id
if(line.contains("id="))
{
	String[] id_array = line.split("id=");
	String[] name_array = line.split("name=");
	String[] value_array = line.split("value=");
	int len=id_array.length;
	System.out.println("Array length="+len);
	int len2=id_array[1].length();
         System.out.println("line="+line);
         //System.out.println("length2="+len2);
         String[] st_arr=id_array[1].split(" ");
         if(line.contains("name="))
         {
         String[] name_arr=name_array[1].split(" ");
         name_gp[j]=name_arr[0];
         }
         if(line.contains("value="))
         {
         String[] value_arr=value_array[1].split(" ");
         value_gp[j]=value_arr[0];
         }
         
         id_arr[j]=st_arr[0];
         
         
         System.out.println("id_arr["+j+"]="+id_arr[j]);
         System.out.println("name_gp["+j+"]="+name_gp[j]);
         System.out.println("value_gp["+j+"]="+value_gp[j]);
         j++;
}
	   i++;
   }
      
   
   //Loop check
   for (int a=0;a<=i;a++)
   {
	   for (int b=a+1;b<=i;b++)
	   {
		   
		   if( id_arr[a].equals(id_arr[b])==true)
		   {
			   System.out.println("DDD");
   System.out.println(id_arr[a]+" and "+id_arr[b]+" are duplicate ids");
		   	   
			   if( value_gp[a]== null || value_gp[b]==null)
		   {
			   System.out.println("DDD2"); 
		   }
			   else
			   {
				   if( name_gp[a].equals(name_gp[b])==true  && value_gp[a].equals(value_gp[b])==true )
				   {
					   System.out.println("Name="+name_gp[a]+ " and "+name_gp[b]+" are duplicate entries with value ="+value_gp[a]);
				   }
			   }
		   }
		  		   
	   }
		   
   }
   
   
   
   System.out.println("No of lines="+i);
   //Close the buffer reader
   bufferReader.close();
   }catch(Exception e){
           System.out.println("Error while reading file line by line:" 
           + e.getMessage());                      
   }

   }
 }