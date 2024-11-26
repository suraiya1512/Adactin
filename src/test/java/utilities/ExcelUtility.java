package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility
{

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook wb;
	public XSSFSheet ws;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path;

	public ExcelUtility(String path)
	{
		this.path = path;
	}

	public int getRowCount(String SheetName) throws IOException
	{
		fi = new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(SheetName);
		int rowcount= ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	public int getCellCount(String SheetName, int rownum) throws IOException
	{
		fi = new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(SheetName);
		row=ws.getRow(rownum);
		int cellcount= row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		
	}
	public String getCellData(String SheetName, int rownum, int column) throws IOException
	{
		fi = new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(SheetName);
		row=ws.getRow(rownum);
		if (row == null) return "";
		cell=row.getCell(column);
		if (cell == null) return "";
		
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try
		{
			data = formatter.formatCellValue(cell);
		}
		catch (Exception e)
		{
			data = "";
		}
		wb.close();
		fi.close();
		return data;
		}

	public void setCellData(String SheetName, int rownum, int column, String data) throws IOException
	{
		File xlfile = new File(path);
		if(!xlfile.exists())
		{
			wb = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			wb.write(fo);;
		}
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(SheetName)==-1)  // if sheet not exists then create new sheet
				wb.createSheet(SheetName);
		ws = wb.getSheet(SheetName);
				
		if(ws.getRow(rownum)==null)
			ws.createRow(rownum);
		row=ws.getRow(rownum);
		
		cell = row.createCell(column);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	public void fillGreenColor(String SheetName, int rownum, int column) throws IOException
	{

		fi = new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(SheetName);
		row=ws.getRow(rownum);
		cell=row.getCell(column);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(style);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();
	}
	public void fillRedColor(String SheetName, int rownum, int column) throws IOException
	{

		fi = new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(SheetName);
		row=ws.getRow(rownum);
		cell=row.getCell(column);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	    cell.setCellStyle(style);
	    wb.write(fo);
	    wb.close();
	    fi.close();
	    fo.close();
	}
	}

