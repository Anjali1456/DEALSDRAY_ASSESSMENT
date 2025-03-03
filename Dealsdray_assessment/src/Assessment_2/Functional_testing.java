package Assessment_2;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class Functional_testing 
{
	public static void main(String[] args) throws Throwable
	{
		
		WebDriver driver = new FirefoxDriver();
	    Thread.sleep(2000);
		driver.manage().window().maximize();
		TakesScreenshot ts = (TakesScreenshot)driver;
		driver.get("https://demo.dealsdray.com");
		WebElement usn = driver.findElement(By.xpath("//input[@name='username']"));
		usn.sendKeys("prexo.mis@dealsdray.com");
		Thread.sleep(1000);
		WebElement psw = driver.findElement(By.xpath("//input[@name='password']"));
		psw.sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root has-submenu compactNavItem css-46up3a\"]")).click();
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();	
		Thread.sleep(2000);
		WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
		chooseFile.sendKeys("C:\\Users\\name\\Desktop\\PERSONAAL\\dealsdray\\demo-data.xlsx");
	    driver.findElement(By.xpath("//button[text()='Import']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement ele = driver.findElement(By.xpath("//button[text()='Previous']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",ele);
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("./Testcase2/Image.png");
		FileHandler.copy(temp, perm);
		driver.quit();
		
	}
}
