package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class excelUtility {
    private static FileInputStream excelfile;
    private static XSSFWorkbook excelworkbook;
    private static XSSFSheet excelsheet;
    private static XSSFCell excelcell;

    public static void setExcelfile(String path, String sheetname) throws IOException {
        try {

            excelfile = new FileInputStream(path);
            excelworkbook = new XSSFWorkbook(excelfile);
            excelsheet = excelworkbook.getSheet(sheetname);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
    public static int getrowcontains(String testcasename, int columnnumber){
        int i=0;
        try {
            int rowcount = excelsheet.getLastRowNum();
            for (i=1;i<=rowcount;i++){
                if(getCellData(i,columnnumber).equalsIgnoreCase(testcasename)){
                    break;
                }
            }
            return i;
        }
        catch (Exception e){
            throw e;
        }

    }
    public static String getCellData(int rownumber, int columnnumber){
        String cellData = null;
        try {
            excelcell= excelsheet.getRow(rownumber).getCell(columnnumber);
        cellData = excelcell.getStringCellValue();
            //cellData = String.valueOf(excelsheet.getRow(rownumber).getCell(columnnumber));
            return cellData;
        }
        catch (Exception e){
            return "";
        }

    }
    public static int nextTestcaseRowCount(int testCaseRow, int totalRowCount){
        int i=0;
        if (testCaseRow==totalRowCount){
            return testCaseRow;
        }
        else {
            for (i=testCaseRow+1; i<totalRowCount;i++){
                if(getCellData(i,0)!=""){
                    break;
                }
            }
            return (i-1);
        }
    }
    public static Object[][] getTableData(int testCaseRow) {
        int numberOfRows=0;
        int rowcount = excelsheet.getLastRowNum();
        int k = nextTestcaseRowCount(testCaseRow, rowcount);
        if(k==rowcount)
        {
            numberOfRows = 1;
        }
        else if(k<rowcount)
        {
            numberOfRows=(rowcount-testCaseRow)+1;
            k=k+1;
        }
        else {
             numberOfRows = (k - testCaseRow);
        }
        int numberOfColumns = (excelsheet.getRow(testCaseRow).getLastCellNum() )- 1;
        String[][] tabArray = new String[numberOfRows][numberOfColumns];

        try {
            int ci = 0;
            while (testCaseRow <= k) {
                int cj = 0;
                for (int j = 1; j <= numberOfColumns; j++, cj++) {
                    tabArray[ci][cj] = getCellData(testCaseRow, j);
                }
                ci++;
                testCaseRow++;
            }
        } catch (Exception e) {
            throw e;
        }
        return tabArray;
    }

}
