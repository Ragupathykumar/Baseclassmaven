package org.baseclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public static WebDriver driver;
	public static void openbrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}
	public static void loadurl(String url) {
		driver.get(url);

	}
	public static void maximise() {
		driver.manage().window().maximize();

	}
	public static void implicitwait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}
	public static void type(WebElement element,String write) {
		element.sendKeys(write);

	}
	public void click(WebElement element) {
		element.click();

	}
	public WebElement findelementbyid(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;

	}
	public WebElement findelementbyname(String name) {
		WebElement element = driver.findElement(By.id(name));
		return element;
	}
	public WebElement findelementbyxpath(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}

	public List<WebElement> findelements(String xpathExpression) {
		List<WebElement> elements = driver.findElements(By.xpath(xpathExpression));
		return elements;

	}

	public void selectbyindex(WebElement element,int value) {
		Select select =new Select(element);
		select.selectByIndex(value);
	}

	public void selectbyvisibletext(WebElement element,String text) {
		Select select =new Select(element);	
		select.selectByVisibleText(text);
	}
public static void closebrowser() {
	driver.close();

}
public static void quitbrowser() {
	driver.quit();

}

public void getdata(String sheet1,int rownum,int cellnum ) throws IOException {
	File file =new File("C:\\Users\\ragup\\eclipse-workspace\\FrameWorksAll\\src\\library\\Raguexcel.xlsx");
	FileInputStream stream =new FileInputStream(file);
	Workbook workbook =new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheet1);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	CellType cellType = cell.getCellType();
	switch(cellType) {
	case  STRING :
		String string = cell.getStringCellValue();
		System.out.println(string);
		break;
	case NUMERIC:
		if(DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat formate=new SimpleDateFormat("dd-mmm-yy");
			String format = formate.format(dateCellValue);
			
		}else {
		double d = cell.getNumericCellValue();
		BigDecimal bg=BigDecimal.valueOf(d);
		String string2 = bg.toString();
		System.out.println(string2);
		break;
		
	}
	default:
		break;
}
}


public void updatedata(String sheet1,int rownum,int cellnum,String olddata ,String newdata) throws IOException {
	File file =new File("C:\\Users\\ragup\\eclipse-workspace\\FrameWorksAll\\src\\library\\Raguexcel.xlsx");
	FileInputStream stream =new FileInputStream(file);
	Workbook workbook =new XSSFWorkbook(stream);
	Sheet sheet = workbook.getSheet(sheet1);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	String stringCellValue = cell.getStringCellValue();
    if(stringCellValue. equals(olddata)) {
    	cell.setCellValue(newdata);
    }
}
public void writedata(String sheet1,int rownum,int cellnum,String olddata ,String newdata) throws IOException, InvalidFormatException {
	File file =new File("C:\\Users\\ragup\\eclipse-workspace\\FrameWorksAll\\src\\library\\Raguexcel23.xlsx");
	Workbook workbook =new XSSFWorkbook(file);
	Sheet sheet = workbook.createSheet(sheet1);
	Row row = sheet.createRow(rownum);
	Cell cell = row.createCell(cellnum);
     cell.setCellValue(newdata);
FileOutputStream op=new FileOutputStream(file);
workbook.write(op);
}
}
