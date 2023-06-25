package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadXLSFile {
    public Object[][] readExcelData(Method m) throws IOException {
        String sheetName = m.getName();
        FileInputStream fileInputStream = new FileInputStream("src/test/resources/testdata/testdata.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum(); // Get the last row index
        int colCount = sheet.getRow(0).getLastCellNum();

        // Count non-empty rows
        int nonEmptyRowCount = 0;
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null && !isRowEmpty(row)) {
                nonEmptyRowCount++;
            }
        }

        Object[][] data = new Object[nonEmptyRowCount][colCount];
        int dataRow = 0;
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            if (row != null && !isRowEmpty(row)) {
                for (int j = 0; j < colCount; j++) {
                    Cell cell = row.getCell(j);
                    if (cell != null) {
                        if (cell.getCellType() == CellType.NUMERIC) {
                            data[dataRow][j] = cell.getNumericCellValue();
                        } else if (cell.getCellType() == CellType.STRING) {
                            data[dataRow][j] = cell.getStringCellValue();
                        } else if (cell.getCellType() == CellType.BOOLEAN) {
                            data[dataRow][j] = cell.getBooleanCellValue();
                        } else if (cell.getCellType() == CellType.BLANK) {
                            data[dataRow][j] = null;
                        }
                    } else {
                        data[dataRow][j] = null;
                    }
                }
                dataRow++;
            }
        }

        workbook.close();
        fileInputStream.close();
        return data;
    }

    private boolean isRowEmpty(Row row) {
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }
}