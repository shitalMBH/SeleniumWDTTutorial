package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
// How to read String, Numeric, date values form excel

		/*
		 * String ExcelPath = "C:\\Users\\Admin\\Desktop\\NameOfPandav.xlsx";
		 * FileInputStream file = new FileInputStream(ExcelPath); Workbook book =
		 * WorkbookFactory.create(file); String value =
		 * book.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
		 * System.out.println(value); double age =
		 * book.getSheet("Sheet1").getRow(2).getCell(2).getNumericCellValue();
		 * System.out.println(age); Date bdate =
		 * book.getSheet("Sheet1").getRow(2).getCell(3).getDateCellValue();
		 * System.out.println(bdate);
		 */
// How to read from excel and use in test script

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com");
		driver.manage().window().maximize();
		WebElement signIn = driver.findElement(By.xpath("//a[text()='Sign In']"));
		signIn.click();
		WebElement signUp = driver.findElement(By.xpath("//a[text()=' Sign Up']"));
		signUp.click();

		// Sign Up
		String ExcelPath = "C:\\Users\\Admin\\Desktop\\NameOfPandav.xlsx";
		FileInputStream file = new FileInputStream(ExcelPath);
		Workbook book = WorkbookFactory.create(file);
		String a = book.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys(a);
		String b = book.getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue();
		WebElement lastName = driver.findElement(By.id("last_name"));
		lastName.sendKeys(b);
		String c = book.getSheet("Sheet2").getRow(1).getCell(2).getStringCellValue();
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys(c);
		String d = book.getSheet("Sheet2").getRow(1).getCell(3).getStringCellValue();
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys(d);
		WebElement confirmPassword = driver.findElement(By.id("password_confirmation"));
		confirmPassword.sendKeys(d);

		WebElement iframe1 = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
		driver.switchTo().frame(iframe1);
		/*
		 * WebElement IAmNotRobot = driver.findElement(By.xpath(
		 * "(//div[@class='recaptcha-checkbox-checkmark'])[1]")); IAmNotRobot.click();
		 */ // This method is not working for this checkbox available on iframe henceforth
			// there is need of Actions class
		Actions actions = new Actions(driver); // Initialize Actions
		WebElement recaptchaElement = driver.findElement(By.xpath("(//div[@class='recaptcha-checkbox-border'])[1]")); // Locate
																														// the
																														// recaptcha
																														// element
		actions.moveToElement(recaptchaElement).click().perform(); // Perform a click action

		// Print the cell data from excel
		System.out.println("name -" + a);
		System.out.println("lastName -" + b);
		System.out.println("email -" + c);
		System.out.println("password -" + d);

	}
}
