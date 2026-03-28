package com.jforce.selenium.utility;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.jforce.selenium.pageObject.AdminDashboardPageObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ValidationFromExcel {
	
	
	
	public static List<String> readSubjectListInExcel(String filepath, String sheetName){
		
		
		List<String> list = new ArrayList<>();
		
		try{
			
			FileInputStream file = new FileInputStream(filepath);
			Workbook workBook = new XSSFWorkbook(file);
			
			Sheet sheet = workBook.getSheet(sheetName);
			Iterator<Row> rows = sheet.iterator();
			
            for(int i=1; i<=sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				
				if(row!=null) {
					
					Cell cell =row.getCell(0);
					if(cell != null) {
						
						list.add(cell.getStringCellValue().trim());
                      }
                   }
				
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		return list;
		
	}
	
	
	
	public static void compareLists(List<String> expectedList, List<String> actualList, String contextMessage) {

        // Trim and convert to sets
        Set<String> expectedSet = expectedList.stream().map(String::trim).collect(Collectors.toSet());
        Set<String> actualSet = actualList.stream().map(String::trim).collect(Collectors.toSet());

        // Find missing and unexpected
        Set<String> missing = new HashSet<>(expectedSet);
        missing.removeAll(actualSet);

        Set<String> unexpected = new HashSet<>(actualSet);
        unexpected.removeAll(expectedSet);

        // Log differences
        if (!missing.isEmpty() || !unexpected.isEmpty()) {
            log.error("{} - Discrepancy detected. Missing: {}, Unexpected: {}", contextMessage, missing, unexpected);
        } else {
            log.info("{} - All items matched as expected.", contextMessage);
        }

        // Duplicate check (actual duplicates only)
        if (new HashSet<>(actualList).size() != actualList.size()) {
            log.error("{} - Duplicate values found in Actual List: {}", contextMessage, actualList);
            Assert.fail("Duplicate values found in Actual list.");
        }

        // Count validation
        if (expectedSet.size() != actualSet.size()) {
            log.error("{} - Count mismatch. Expected: {}, Actual: {}", contextMessage, expectedSet.size(), actualSet.size());
            Assert.assertEquals(
            		            actualSet.size(),
            		            expectedSet.size(),
                                contextMessage + "\nMissing from expected: " + missing + "\nUnexpected in actual: " + unexpected);
        }

        // Final content validation
        Assert.assertEquals(
                actualSet,
                expectedSet,
                contextMessage + "\nMissing from expected: " + missing + "\nUnexpected in actual: " + unexpected
        );

        log.info("{} - Validation PASSED. Expected: {}, Actual: {}", contextMessage, expectedList, actualList);
    }
	
	
	
	
}
