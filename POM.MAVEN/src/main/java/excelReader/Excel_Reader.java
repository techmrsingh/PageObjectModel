package excelReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader  {

	public FileOutputStream fileOut=null;
	public String path;
	public FileInputStream fis=null;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	
	public Excel_Reader(String path){
		this.path=path;
		try{
			
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

	public String[][] getDataFromSheet(String SheetName, String ExcelName)
	{
		String dataSets[][]=null;
		try{
		XSSFSheet sheet=workbook.getSheet(SheetName);
		int totalRow=sheet.getLastRowNum()+1;
		int totalColumn=sheet.getRow(0).getLastCellNum();
		dataSets=new String[totalRow-1][totalColumn];
		
		for(int i=1;i<totalRow;i++){		
			XSSFRow rows=sheet.getRow(i);
			
			for(int j=0; j< totalColumn;j++)
			{
				XSSFCell cell=rows.getCell(j);
				if(cell.getCellType()==Cell.CELL_TYPE_STRING){
					dataSets[i-1][j] = cell.getStringCellValue();
				}
				else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
					
					String cellText=String.valueOf(cell.getNumericCellValue());
					dataSets[i-1][j] =cellText;		
					
				}
				else
				{
					dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				}
			}
		
		}
		return dataSets;
		}
		catch(Exception e){
			System.out.println("Error in Reading Excel Sheet");	
		}
		return dataSets;
	}
	
	
	
	public String getCellData(String sheetName,String colName, int rowNum)
	{
		try {
			int col_Num=0;
			int index=workbook.getSheetIndex(sheetName);
			sheet=workbook.getSheetAt(index);
			XSSFRow row=sheet.getRow(0);
			for(int i =0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().equals(colName))
				{
					col_Num=i;
					break;
				}
			}
			
			row=sheet.getRow(rowNum-1);
			
			XSSFCell cell=row.getCell(col_Num);
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			{
				return cell.getStringCellValue();
			}else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			{
				return "";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	
}
