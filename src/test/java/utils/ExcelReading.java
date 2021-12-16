package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReading {

    static Workbook workbook;
    static Sheet sheet;

    //to open Excel book
    public static void openExcel(String filePath){
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //to open sheet
    public static void getSheet(String sheetName){
        sheet = (Sheet) workbook.getSheet(sheetName);
    }

    //to get total rows
    public static int getRowCount(){
      return sheet.getPhysicalNumberOfRows();
    }

    //to get total columns
    public static int getColsCount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    public static String getCellData(int rowIndex, int colIndex){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

    public static List<Map<String, String>> excelIntoListMap(String filePath, String sheetName){
        openExcel(filePath);
        getSheet(sheetName);
        List<Map<String,String>> listData = new ArrayList<>();
        for (int row = 1; row < getRowCount(); row++) {
            Map<String, String> map = new LinkedHashMap<>(); //map for every row
            for (int column = 0; column < getColsCount(row); column++) { //loop thruogh the values of all the cell
                map.put(getCellData(0,column),getCellData(row,column)); //rowindex is teh start point for each loop
            }
            listData.add(map); // adding the map to the list
        }
        return listData;
    }
}
