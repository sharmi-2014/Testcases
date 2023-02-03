package testcases1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForce2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		 ChromeDriver driver=new ChromeDriver(option);
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   driver.get("https://login.salesforce.com/");
		
		   driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		   
	       driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
		   
	       driver.findElement(By.xpath("//input[@id='Login']")).click();
		   driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		   
		   Set<String> windowHandles = driver.getWindowHandles();
			
			List<String>lstwindow=new ArrayList<String>(windowHandles);
			driver.switchTo().window(lstwindow.get(1));
			
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			Shadow shadow=new Shadow(driver);
	shadow.findElementByXPath("//span[text()='Learning']").click();
	Thread.sleep(3000);
	Actions builder=new Actions(driver);
	WebElement learningontrailhead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
	builder.moveToElement(learningontrailhead).perform();
	Shadow shadow1=new Shadow(driver);
	WebElement salesforce = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
	driver.executeScript("arguments[0].click();", salesforce);
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
	
	String text = driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']")).getText();
	
   System.out.println(text);
	
   List<WebElement>lst = driver.findElements(By.xpath("//div[@class='credentials-card ']"));
   System.out.println(lst.size());

   for(int i=0;i<lst.size();i++) {
	System.out.println(lst.get(i).getText());
	}
   
	driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
	
	//Set<String> windowHandles1 = driver.getWindowHandles();
	
	//List<String>lstwindow1=new ArrayList<String>(windowHandles1);
	//driver.switchTo().window(lstwindow1.get(1));
	
	List<WebElement> lst1 = driver.findElements(By.xpath("//div[@class='credentials-card ']"));
	//System.out.println(lst1.size());
	
	for(int i=0;i<lst1.size();i++) {
		System.out.println(lst1.get(i).getText());
		}
	
	File source = driver.getScreenshotAs(OutputType.FILE);
    File dest =new File("./snap/salesforce2.png");
    FileUtils.copyFile(source, dest);
    //driver.quit();

	
	
	
	}
}
