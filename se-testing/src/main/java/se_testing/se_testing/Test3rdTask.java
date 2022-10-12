package se_testing.se_testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test3rdTask {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        
        try {
            ///JavascriptExecutor js = (JavascriptExecutor) driver;
            
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[text()='Widgets']")));
            driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='Progress Bar']")));
            driver.findElement(By.xpath("//span[text()='Progress Bar']")).click();
            
            ///js.executeScript("window.scrollBy(0,250)");
        	///wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Widgets']"))).click();
        	///driver.findElement(By.xpath("//h5[text()='Widgets']")).click();
        	
        	
        	///js.executeScript("window.scrollBy(0,250)");
        	///wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Progress Bar']"))).click();
        	
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='startStopButton']"))).click();
        	
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-valuenow='100']")));
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='resetButton']"))).click();

        	if(driver.findElement(By.xpath("//div[@role='progressbar']")).getAttribute("aria-valuenow").toString().equals("0")) {
        		System.out.println("Success");
        	} else {
        		System.out.println("Failure");
        	}        	

        } catch (Exception e) {
        	System.out.println(e);
        } finally {
        	driver.quit();
        }		
	}
}
