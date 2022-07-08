package excel;

import java.nio.file.Path;

public class ExcelFileMain {

    public static void main(String[] args) {
        var myExcel = ExcelFile.createExcelFileWithFirstSheet(Path.of("src/test/resources/sample.xlsx"));
        System.out.println(myExcel.getStringCellValueAt(0, 0));
    }
}
