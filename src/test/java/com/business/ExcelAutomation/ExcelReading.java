package com.business.ExcelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ExcelReading {

    @Test
    public void readExcel() throws Exception {
        String path = "./src/test/resources/Countries.xlsx";
        FileInputStream fis = new FileInputStream(path);
        //Open the Workbook interface -  We don't have to mention XSSF, HSSF or any type pf WorkBook
        Workbook workbook = WorkbookFactory.create(fis);
        // Go to the 1st WorkSheet (1st sheet in excel file)
        Sheet worksheet = workbook.getSheetAt(0);
        // Go to 1st Row
//        Row row = worksheet.getRow(0);
//        //Go to 1st Cell
//        Cell cell = row.getCell(0);


        /* Read cells of row certain using method chaining */
        String country1 = worksheet.getRow(1).getCell(0).toString();
        String capital1 = worksheet.getRow(1).getCell(1).toString();
        System.out.println("Country1 -> " + country1 + " | " + "Capital1 -> " + capital1);
        System.out.println(workbook.getSheetAt(0).getRow(2).getCell(0).toString() + " | "
                + workbook.getSheetAt(0).getRow(2).getCell(1).toString());

        /* Read all values of the Excel file */
        // 1. Find total count of rows in worksheet
        int rowsCount = worksheet.getLastRowNum();
        // 2. Use for loop to read all rows and their cells //
        for (int i = 1; i <= rowsCount; i++) {
              System.out.println("Country ==> " + worksheet.getRow(i).getCell(0) +
                              " | Capital ==> " + worksheet.getRow(i).getCell(1) +
                              " | Continent ==>"+ worksheet.getRow(i).getCell(2));
        }


        /*Close workbook and stream */
        workbook.close();
        fis.close();
    }


}






