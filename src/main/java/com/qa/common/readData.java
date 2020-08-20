package com.qa.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.qa.utility.util;

public class readData extends util
{
	public List<String> getExcelTestData(String sheetName,String coloumnName) throws IOException
	{
		    List<String> list=new ArrayList<String>();
		    FileInputStream file = new FileInputStream(new File(resouceExcelTestDataPath));
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        XSSFRow row = sheet.getRow(0);
	        int minColIx = row.getFirstCellNum(); 
	        int maxColIx = row.getLastCellNum(); 
	        int minRowIx=sheet.getFirstRowNum();
	        int maxRowIx=sheet.getLastRowNum();
	        
	        for(int colIx=minColIx; colIx<=maxColIx; colIx++) 
	        { 
	        	   XSSFCell cell = row.getCell(colIx); 
	        	if (cell != null) 
	        	{
	        	   if(cell.getStringCellValue().trim().equals(coloumnName))
	        	   {
	        		   int cellId=cell.getColumnIndex();
					
					 for(int rowIx=minRowIx+1;rowIx<=maxRowIx;rowIx++) 
					 {
						 XSSFCell cell1=sheet.getRow(rowIx).getCell(cellId);
						 list.add(cell1.getStringCellValue());
					  
					 }
					 
					 
	        	   }
	        	}
	        	 
	        }
	        workbook.close();
	        return list;
	}
	
	
	public String getJSONTestData(String key) throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader(resourceJSONTestDataPath);
		Object obj = jsonParser.parse(reader);
		JSONObject jsonObj=(JSONObject)obj;
		return jsonObj.get(key).toString();
		
		
	}
	
	public List<String> getCSVTestData(String coloumnName) throws IOException
	{
		List<String> data=new ArrayList<String>();
		Reader reader = Files.newBufferedReader(Paths.get(resourceCSVTestDataPath));
		CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withTrim());
		Map<String, Integer> header = csvParser.getHeaderMap();
		for (CSVRecord csvRecord : csvParser) 
		{
			for(Map.Entry<String, Integer> entry :header.entrySet())
			{
				if(entry.getKey().contains(coloumnName))
				{
				data.add(csvRecord.get(entry.getValue()));
				}
			}
		}

		return data;
	}
	

}
