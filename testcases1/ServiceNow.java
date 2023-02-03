package testcases1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class ServiceNow {
	/*Url: https://dev62925.service-now.com/
		Username: admin
		Password: GAhMak34tH-^
		Ordering mobile
		============
		1. Launch ServiceNow application
		2. Login with valid credentials
		3. Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		4. Click on  mobiles
		5. Select Apple iPhone 13
		6. Click as No in Is this a replacement for a lost or broken iPhone?
		7. Select Unlimited in  Monthly data allowance
		8. Choose color field as Blue and storage field as 256 GB
		9. Click  Order now option
		10. Verify order is placed and get the request number"
		11. Take a Snapshot
		12. Close the browser*/
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 ChromeDriver driver=new ChromeDriver(option);
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   driver.get("https://dev62925.service-now.com/");
		
           driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		   
	       driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("GAhMak34tH-^");
		   driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
	       Shadow shadow=new Shadow(driver);
	       shadow.setImplicitWait(30);
	       shadow.findElementByXPath("//div[text()='All']").click();
	shadow.setImplicitWait(30);
    shadow.findElementByXPath("//span[text()='Service Catalog']").click();

	WebElement findElementByXPath = shadow.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(findElementByXPath);
	driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
	   
	driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
	driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();  
WebElement findElement = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));

//WebElement unlimited = driver.findElement(By.xpath("//option[text()='Unlimited']"));
	Select drop=new Select(findElement);
	drop.selectByIndex(2);
driver.findElement(By.xpath("//label[text()='Blue']")).click();

driver.findElement(By.xpath("//label[text()='256 GB [add $100.00]']")).click();

driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();

String text = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']")).getText();
System.out.println(text);
String text2 = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
System.out.println(text2); File source = driver.getScreenshotAs(OutputType.FILE);
File dest =new File("./snap/ServiceNow.png");
FileUtils.copyFile(source, dest);



	}	
}
