package com.excel.app.service;

import com.excel.app.util.ExcelUtil;

public class ExcelServiceImpl implements ExcelService {

    @Override
    public void createSheet(String dirPath, String fileName) {
        ExcelUtil.createExcel(dirPath, fileName);
       // System.out.println("Excel file created successfully.");
    }

        

    @Override
    public void readFullSheet(String path) {
        ExcelUtil.readEntireSheet(path);
    }

    @Override
    public void readCell(String path, int row, int col) {
        ExcelUtil.readSingleCell(path, row, col);
    }

    @Override
    public void writeCell(String path, int row, int col, String value) {
        ExcelUtil.writeToCell(path, row, col, value);
        System.out.println("Data written successfully.");
    }

    @Override
    public void copySheet(String sourcePath, String destPath) {
        ExcelUtil.copyExcel(sourcePath, destPath);
        System.out.println("Excel file copied successfully.");
    }
}
