package excel;

import lombok.SneakyThrows;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.nio.file.Path;

public class ExcelFile {

    private XSSFWorkbook workbook;

    private XSSFSheet sheet;

    public ExcelFile(XSSFWorkbook workbook, XSSFSheet sheet) {
        this.workbook = workbook;
        this.sheet = sheet;
    }

    @SneakyThrows
    public static ExcelFile createExcelFileWithFirstSheet(Path path) {
        var workbook = new XSSFWorkbook(path.toFile());
        var sheet = workbook.getSheetAt(0);
        return new ExcelFile(workbook, sheet);
    }

    public String getStringCellValueAt(int row, int column) {
        return sheet.getRow(row).getCell(column).getRichStringCellValue().getString();
    }

    public void selectSheet(int i) {
        sheet = workbook.getSheetAt(i);
    }


}
