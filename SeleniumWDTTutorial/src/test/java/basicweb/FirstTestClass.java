package basicweb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestClass {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.letskodeit.com");
		driver.manage().window().maximize();
		WebElement practice = driver.findElement(By.xpath("//a[@type='button']"));
		practice.click();
		WebElement ecommPractice = driver.findElement(By.xpath("//a[@href='http://ecommercepractice.letskodeit.com/']"));
		ecommPractice.click();
		driver.close();
		driver.quit();
		//driver.navigate().back();
	}

}
