package utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.poi.ss.usermodel.Sheet;

public class ReadXLSFile {
    public Object[][] readExcelData(Method m) throws IOException {
        String sheetName = m.getName();
        String filePath = "src/test/resources/testdata/testdata.xlsx";

            try (FileInputStream fileInputStream = new FileInputStream(filePath);
                 Workbook workbook = WorkbookFactory.create(fileInputStream)) {

                Sheet sheet = workbook.getSheet(sheetName);
                int rowCount = sheet.getPhysicalNumberOfRows();
                int colCount = sheet.getRow(0).getLastCellNum();

                Object[][] data = new Object[rowCount - 1][colCount];

                int dataRow = 0;
                for (int i = 1; i < rowCount; i++) {
                    Row row = sheet.getRow(i);
                    if (!isRowEmpty(row)) {
                        for (int j = 0; j < colCount; j++) {
                            Cell cell = row.getCell(j, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                            if (cell != null) {
                                data[dataRow][j] = getCellValue(cell);
                            } else {
                                data[dataRow][j] = null;
                            }
                        }
                        dataRow++;
                    }
                }

                return data;
            }
        }

        public static boolean isRowEmpty(Row row) {
            for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
                Cell cell = row.getCell(i);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    return false;
                }
            }
            return true;
        }

        private Object getCellValue(Cell cell) {
            switch (cell.getCellType()) {
                case NUMERIC:
                    return cell.getNumericCellValue();
                case STRING:
                    return cell.getStringCellValue();
                case BOOLEAN:
                    return cell.getBooleanCellValue();
                default:
                    return null;
            }
        }
    }