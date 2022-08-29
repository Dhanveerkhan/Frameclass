package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.microsoft.schemas.office.visio.x2012.main.CellType;

import dev.failsafe.Call;

public class Excel {
	public static void main(String[] args) throws IOException {
		File file=new File("C:\\Users\\dhanv\\eclipse-workspace\\FrameClass\\Excel\\Book2.xlsx");
		FileInputStream stream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("sheet1");
		
		for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
//				System.out.println(cell);  
				org.apache.poi.ss.usermodel.CellType type = cell.getCellType();
				switch (type) {
				case STRING:
					String value = cell.getStringCellValue();
					System.out.print(value+"\t");
					 
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
						String text = simple.format(date);
						System.out.print(text+"\t");
					
			}else {
					double value2 = cell.getNumericCellValue();
					BigDecimal decimal = BigDecimal.valueOf(value2);
					String number = decimal.toString();
					System.out.print(number+"\t");
					}
					break;
				default:
					break;
				}
					
				
					}
			
				
				
			
		System.out.println();
	     
		}
		
		
	} 

	
}
