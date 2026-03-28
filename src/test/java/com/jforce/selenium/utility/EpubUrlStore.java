package com.jforce.selenium.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class EpubUrlStore {

//	public static void appendUrl(String fileName, String sheetName, String urlValue, String assertionStatus) {
//
//	    String folderPath = System.getProperty("user.dir") + "/test-data/";
//	    String filePath = folderPath + fileName;
//
//	    try {
//	        // Ensure folder exists
//	        File folder = new File(folderPath);
//	        if (!folder.exists()) {
//	            folder.mkdirs();
//	        }
//
//	        File file = new File(filePath);
//	        XSSFWorkbook workbook;
//	        XSSFSheet sheet;
//
//	        // Load or create workbook
//	        if (file.exists() && file.length() > 0) {
//	            try (FileInputStream fis = new FileInputStream(file)) {
//	                workbook = new XSSFWorkbook(fis);
//	            }
//	        } else {
//	            workbook = new XSSFWorkbook();
//	        }
//
//	        // Load or create sheet
//	        sheet = workbook.getSheet(sheetName);
//	        if (sheet == null) {
//	            sheet = workbook.createSheet(sheetName);
//
//	            // Create header row
//	            Row header = sheet.createRow(0);
//	            header.createCell(0).setCellValue("EPUB URL");
//	            header.createCell(1).setCellValue("Assertion Status");
//	        }
//
//	        // Append next row
//	        int nextRow = sheet.getPhysicalNumberOfRows();
//	        Row row = sheet.createRow(nextRow);
//
//	        row.createCell(0).setCellValue(urlValue);
//	        row.createCell(1).setCellValue(assertionStatus);
//
//	        // Write Excel
//	        try (FileOutputStream fos = new FileOutputStream(filePath)) {
//	            workbook.write(fos);
//	        }
//
//	        workbook.close();
//
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	}

	public static void appendUrl(String fileName, String sheetName, String readerUrl, String epubCheck,
			String readerLoad, String content, String navigation) {

		String path = System.getProperty("user.dir") + "/test-data/" + fileName;

		try (XSSFWorkbook workbook = new XSSFWorkbook()) {

			XSSFSheet sheet = workbook.createSheet(sheetName);

			Row header = sheet.createRow(0);
			header.createCell(0).setCellValue("Reader URL");
			header.createCell(1).setCellValue("EPUB Check");
			header.createCell(2).setCellValue("Reader Loaded");
			header.createCell(3).setCellValue("Content Visible");
			header.createCell(4).setCellValue("Navigation");

			Row row = sheet.createRow(1);
			row.createCell(0).setCellValue(readerUrl);
			row.createCell(1).setCellValue(epubCheck);
			row.createCell(2).setCellValue(readerLoad);
			row.createCell(3).setCellValue(content);
			row.createCell(4).setCellValue(navigation);

			try (FileOutputStream fos = new FileOutputStream(path)) {
				workbook.write(fos);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
