package util;

import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
    public static String[][] getDataFromExcel() throws IOException
    {
        FileInputStream file = new FileInputStream("src/main//resources/testData.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(file);
        XSSFSheet sheet=wb.getSheet("Sheet1");
        XSSFRow row;
        XSSFCell cell;
        long currentTimeMillis = System.currentTimeMillis();
        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(1).getLastCellNum();
        String[][] tabArray = new String[totalRows][totalCols];
        for(int r=1, i = 0;r<=totalRows;r++, i++)
        {
            row = (XSSFRow)sheet.getRow(r);
            for(int c=0, j=0;c<totalCols;c++, j++)
            {
                cell = row.getCell(c);
                tabArray[i][j] = cell.getStringCellValue() + currentTimeMillis;
            }
        }
        return tabArray;
    }
    public static WebElement explicitWait(WebDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void sendKeys(WebDriver driver, By locator, String txt)
    {
        WebElement ele = explicitWait(driver,locator);
        ele.clear();
        ele.sendKeys(txt);
    }
    public static String handleAlert(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertTxt = alert.getText().trim();
        alert.accept();
        return alertTxt;
    }

}
