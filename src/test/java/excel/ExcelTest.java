package excel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExcelTest {

    @Test
    void testReadSampleExcelFile() throws Exception {
        FileInputStream file = new FileInputStream("src/test/resources/sample.xlsx");
        var workbook = new XSSFWorkbook(file);
        var sheet = workbook.getSheetAt(0);
        var cell = sheet.getRow(0).getCell(0);

        assertEquals("aaa", cell.getRichStringCellValue().getString());
    }

}
