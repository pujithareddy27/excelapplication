package com.excel.app.service;

public interface ExcelService {

    void createSheet(String dirPath, String fileName);

    void readFullSheet(String path);

    void readCell(String path, int row, int col);

    void writeCell(String path, int row, int col, String value);

    void copySheet(String sourcePath, String destPath);
}
