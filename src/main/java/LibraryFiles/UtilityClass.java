package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
  {
	//@autherName:Sanjay
	//This method is use to get Test data from excel sheet.
	// need to pass 2 inputs: 1 rowIndex,2 colIndex 
	
	
	public static String getTextData(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException 
   {
	  FileInputStream file =new FileInputStream("D:\\auto notes\\28 Jan 2023.xlsx");  
	  Sheet sh=WorkbookFactory.create(file).getSheet("DDF");
     String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
     return value;
   
   }
  
	public static void CaptureSS(WebDriver driver, int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   // File dest = new File("D:\\auto notes\\SS\\abc.jpg");
		File dest = new File("D:\\auto notes\\SS\\TestCaseID"+TCID+".jpg");
		FileHandler.copy(src, dest);
	
	}
   public static String getPFData(String key) throws IOException
   {
	   FileInputStream file =new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\28 Jan 2023 Selenium\\PropertyFile.properties");  
       
	   Properties p = new Properties();
       p.load(file);
      String value = p.getProperty(key);
      return value;
   
   
   
   }
   
  
  
  }
