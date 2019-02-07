package example.utils;

import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DataInteraction {

	private final static Logger logger = Logger.getLogger(DataInteraction.class);
		
	public static void main(String[] a)	
	{
		readExcel("erp2");
		
	}
	
	
	
	 //public static void main(String[] dd)
	public static String[][] readExcel(String tid)
	  {
		
		logger.info("Read excel is invokded");
		
		  String data[][] = null;
		  
		  try
		  {
			  logger.info("in try block");
				
			  
			  	FileInputStream f1 = new FileInputStream("C:\\Users\\welcome\\Desktop\\selenium_practice1.xls");
				HSSFWorkbook work = new HSSFWorkbook(f1);
				HSSFSheet sheet = work.getSheet("sheet1");

				System.out.println("test1");
				int rc,cc;
				rc = sheet.getPhysicalNumberOfRows();
		
				
				System.out.println("test2");
				cc = sheet.getRow(1).getPhysicalNumberOfCells();
				
				System.out.println("no. of rows "+rc);
				System.out.println("no. of columns "+cc);
				
				data = new String[1][2];
				
				logger.info("before read");
				
				for(int i = 1; i<rc;i++)
				{
					HSSFRow row = sheet.getRow(i);
			
					//System.out.println(row.getCell(0).toString());
					if(row.getCell(0).toString().equals(tid))
					{
						data[0][0] = row.getCell(1, org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue();
						
						//data[i][0]= row.getCell(0).getStringCellValue();
						System.out.println("Printing data values");
						//System.out.println(data[i][0]);
						
						data[0][1] = row.getCell(2,org.apache.poi.ss.usermodel.Row.CREATE_NULL_AS_BLANK).getStringCellValue();
				
						System.out.println(data[0][0]+"\t"+data[0][1]);
						
					}
					
							
				}
				
				logger.info("after read");
				
		  }
		  catch (Exception e) {
			  System.out.println(e);
			  System.out.println("Unable to open excel file");
			  //driver.close();
			  
			  logger.error(e.toString());
				
		}
		  return data;
	  }

	
}
