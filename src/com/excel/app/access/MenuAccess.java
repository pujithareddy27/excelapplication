package com.excel.app.access;

import java.io.File;
import java.util.Scanner;
import com.excel.app.service.ExcelService;
import com.excel.app.service.ExcelServiceImpl;

public class MenuAccess {

    private final ExcelService excelService = new ExcelServiceImpl();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        int choice;

        do {
            System.out.println("\n====== EXCEL MENU ======");
            System.out.println("1. Create New Excel Sheet");
            System.out.println("2. Read Excel Sheet");
            System.out.println("3. Write Data to Excel");
            System.out.println("4. Copy Excel Sheet");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: createSheet();break;
                case 2: readSheet();break;
                case 3: writeSheet();break;
                case 4: copySheet();break;
                case 5: System.out.println("Exiting application...");break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    private String getFullPath() {
        System.out.print("Enter directory path: ");
        String dir = sc.nextLine();

        System.out.print("Enter file name (example.xlsx): ");
        String file = sc.nextLine();

        return dir + File.separator + file;
    }

    private void createSheet() {
    	System.out.print("Enter directory path: ");
    	String dirPath = sc.nextLine();

    	System.out.print("Enter file name (example.xlsx): ");
    	String fileName = sc.nextLine();

    	excelService.createSheet(dirPath, fileName);
    }

    private void readSheet() {
        String fullPath = getFullPath();

        System.out.print("1. Read Whole Sheet\n2. Read Specific Cell\nChoose option: ");
        int option = sc.nextInt();

        if (option == 1) {
            excelService.readFullSheet(fullPath);
        } else {
            System.out.print("Enter row index: ");
            int row = sc.nextInt();
            System.out.print("Enter column index: ");
            int col = sc.nextInt();
            excelService.readCell(fullPath, row, col);
        }
    }

    private void writeSheet() {
        String fullPath = getFullPath();

        System.out.print("Enter row index: ");
        int row = sc.nextInt();
        System.out.print("Enter column index: ");
        int col = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter value to write: ");
        String value = sc.nextLine();

        excelService.writeCell(fullPath, row, col, value);
    }

    private void copySheet() {
        System.out.println("SOURCE FILE:");
        String source = getFullPath();

        System.out.println("DESTINATION FILE:");
        String destination = getFullPath();

        excelService.copySheet(source, destination);
    }
}
