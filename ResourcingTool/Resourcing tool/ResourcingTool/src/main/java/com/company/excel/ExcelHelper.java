package com.company.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.yodlee.model.Training;

public class ExcelHelper {

	/*public static void main(String[] args) throws IOException{
		ExcelHelper ex=new ExcelHelper();
		String excelFilePath="D:/Trainings/Training Calendar 2017.xlsx";
		ex.readBooksFromExcelFile(excelFilePath);
	}*/
	
	
	public List<Training> readBooksFromExcelFile(String excelFilePath) throws IOException {
		System.out.println("path::"+excelFilePath);
		List<Training> trainingList = new ArrayList<>();
		try(FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
				Workbook workbook = new XSSFWorkbook(inputStream)){

			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = firstSheet.iterator();

			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if(nextRow.getRowNum() ==0 ){
					System.out.println("First Row");
					continue;
				}
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				Training training=new Training();

				while (cellIterator.hasNext()) {
					Cell nextCell = cellIterator.next();
					int columnIndex = nextCell.getColumnIndex();
					System.out.println("index::"+columnIndex);
					switch (columnIndex) {
					case 0:
						String sr=String.valueOf(getCellValue(nextCell));
						System.out.println("sr :"+sr);
						break;
					case 1:
						String dates=String.valueOf(getCellValue(nextCell));
						System.out.println("dates::"+dates);
						ArrayList dateList=new ArrayList<>();
						dateList.add(dates);
						training.setDates(dateList);
						break;
					case 2:
						String month=String.valueOf(getCellValue(nextCell));
						System.out.println("month::"+month);
						training.setMonth(month);
						break;
					case 3:
						String quarter=String.valueOf(getCellValue(nextCell));
						System.out.println("quarter::"+quarter);
						training.setQuarter(quarter);
						break;
					case 4:
						String type=String.valueOf(getCellValue(nextCell));
						System.out.println("type::"+type);
						training.setType(type);
						break;
					case 5:
						String program=String.valueOf(getCellValue(nextCell));
						System.out.println("program:"+program);
						training.setProgramName(program);
						break;
					}
				}
				trainingList.add(training);
			}
		}
		return trainingList;
	}
	
	private Object getCellValue(Cell cell) {
		if(cell.getCellTypeEnum()==CellType.STRING) {
			System.out.println("inside string");
			return cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum()==CellType.BOOLEAN) {
			System.out.println("inside boolean");
			return cell.getBooleanCellValue();

		} else if(cell.getCellTypeEnum()==CellType.NUMERIC){
			System.out.println("numeric");
			return cell.getNumericCellValue();
		}
		return null;
	}
		
}
