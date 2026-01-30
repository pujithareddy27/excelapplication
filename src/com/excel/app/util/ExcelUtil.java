package com.excel.app.util;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static void createExcel(String dirPath, String fileName) {
	    try {
	        File dir = new File(dirPath);
	        if (!dir.exists()) {
	            dir.mkdirs(); // create directory if not exists
	        }

	        String fullPath = dirPath + File.separator + fileName;

	        XSSFWorkbook workbook = new XSSFWorkbook();
	        workbook.createSheet("Sheet1");

	        FileOutputStream fos = new FileOutputStream(fullPath);
	        workbook.write(fos);

	        fos.close();
	        workbook.close();

	        System.out.println("Excel file created successfully.");

	    } catch (Exception e) {
	        System.out.println("Error creating Excel file.");
	        e.printStackTrace();
	    }
	}


    public static void readEntireSheet(String path) {
        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheetAt(0);

            System.out.println("\n===== SHEET DATA =====");

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                if (row == null) {
                    System.out.println();
                    continue;
                }

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);

                    if (cell == null) {
                        System.out.print(" \t");
                    } else {
                        System.out.print(cell.toString() + "\t");
                    }
                }
                System.out.println();
            }

            System.out.println("======================");

        } catch (Exception e) {
            System.out.println("Error reading Excel file.");
            e.printStackTrace();
        }
    }

    public static void readSingleCell(String path, int rowIndex, int colIndex) {
        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(rowIndex);

            if (row == null) {
                System.out.println("Row does not exist.");
                return;
            }

            Cell cell = row.getCell(colIndex);

            if (cell == null) {
                System.out.println("Cell is empty.");
            } else {
                System.out.println("Cell Value: " + cell.toString());
            }

        } catch (Exception e) {
            System.out.println("Error reading cell.");
            e.printStackTrace();
        }
    }

    public static void writeToCell(String path, int rowIndex, int colIndex, String value) {
        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = new XSSFWorkbook(fis)) {

            Sheet sheet = wb.getSheetAt(0);
            Row row = sheet.getRow(rowIndex);
            if (row == null) row = sheet.createRow(rowIndex);

            Cell cell = row.getCell(colIndex);
            if (cell == null) cell = row.createCell(colIndex);

            cell.setCellValue(value);

            try (FileOutputStream fos = new FileOutputStream(path)) {
                wb.write(fos);
            }

            System.out.println("Data written successfully.");

        } catch (Exception e) {
            System.out.println("Error writing to Excel.");
            e.printStackTrace();
        }
    }

    public static void copyExcel(String source, String dest) {
        try (FileInputStream fis = new FileInputStream(source);
             Workbook wb = new XSSFWorkbook(fis);
             FileOutputStream fos = new FileOutputStream(dest)) {

            wb.write(fos);
            System.out.println("Excel copied successfully.");

        } catch (Exception e) {
            System.out.println("Error copying Excel file.");
            e.printStackTrace();
        }
    }
}
