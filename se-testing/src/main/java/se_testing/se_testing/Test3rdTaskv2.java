package se_testing.se_testing;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class Test3rdTaskv2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        try {
        	///JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            
            wait.withTimeout(Duration.ofSeconds(60));
            wait.pollingEvery(Duration.ofMillis(200));
            wait.ignoring(NoSuchElementException.class);
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h5[text()='Elements']")));
            driver.findElement(By.xpath("//h5[text()='Elements']")).click();
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='Web Tables']")));
            driver.findElement(By.xpath("//span[text()='Web Tables']")).click();
            
            ///js.executeScript("window.scrollBy(0,250)");
        	///wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[text()='Elements']"))).click();
            ///driver.findElement(By.xpath("//h5[text()='Elements']")).click();
        	
            ///js.executeScript("window.scrollBy(0,250)");
        	///wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Web Tables']"))).click();
            ///driver.findElement(By.xpath("//span[text()='Web Tables']")).click();
        	
        	///Select selectNumber = new Select(driver.findElement(By.xpath("//select[@aria-label='rows per page']")));
        	///selectNumber.selectByValue("5");
        	
        	Function<WebDriver,Boolean> waitingFunction = new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver arg0) {
                    driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
                    driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Jonas");
                    driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Jonaitis");
                    driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("Jonaitis@gmail.com");
                    driver.findElement(By.xpath("//input[@id='age']")).sendKeys("23");
                    driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("3652");
                    driver.findElement(By.xpath("//input[@id='department']")).sendKeys("kazkur");
                    driver.findElement(By.xpath("//button[@id='submit']")).click();
     
                    if (driver.findElement(By.xpath("//button[text()='Next']")).isEnabled()) {
                        return true;
                    } else {
                        return false;
                    }
                }
            };
     
            wait.until(waitingFunction);
        	
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text()='Next']")));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']")));
            ///driver.findElement(By.xpath("//button[text()='Next']")).click();
        	
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[@title='Delete']")));
            driver.findElement(By.xpath("//span[@title='Delete']")).click();
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@class='-next']")));
            
        	if(driver.findElement(By.xpath("//span[@class='-totalPages']")).getText().equals("1") &&
        			driver.findElement(By.xpath("//div[@class='-next']")).isEnabled()) {
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
