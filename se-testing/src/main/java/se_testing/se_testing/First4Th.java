package se_testing.se_testing;

import java.io.BufferedReader;
import java.io.FileReader;
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
public class First4Th {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        try {
        	
        	
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        	
        	driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        	
        	BufferedReader reader;
        	reader = new BufferedReader(new FileReader("user.txt"));
        	String line = reader.readLine();
        	reader.close();
        	
        	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(line);
        	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("kjadh@uhweH153");
        	
        	driver.findElement(By.xpath("//input[@value='Log in']")).click();
        	
        	driver.findElement(By.xpath("//a[@href='/digital-downloads']")).click();
        	
        	
        	BufferedReader reader2;
        	
        	reader2 = new BufferedReader(new FileReader("data1.txt"));
        	String line2 = reader2.readLine();
        	String request = null;
        	
        	while(line2!=null) {
        		request = "//a[text()='" + line2 + "']/following::input[@value='Add to cart']";
        		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(request))).click();
        		Thread.sleep(500);
        		line2 = reader2.readLine();
        		request=null;
        	}
        	
        	///System.out.println(request+line+"/following::input[@value='Add to cart']");
        	reader2.close();
        	
        	///wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='3rd Album']/following::input[@value='Add to cart']"))).click();
        	///driver.findElement(By.xpath("//a[text()='3rd Album']/following::input[@value='Add to cart']")).click();

        	driver.findElement(By.className("ico-cart")).click();
        	driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
        	driver.findElement(By.xpath("//button[@id='checkout']")).click();

        	if(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")).isDisplayed()) {
        		Select selectNumber = new Select(driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']")));
            	selectNumber.selectByValue("1");
            	
            	driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("arhawrna");
            	driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("abcsfbasba");
            	driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("abcfnzsfn");
            	driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("abchsrhwsrn");
        	} else {
            	///Select selectNumber1 = new Select(driver.findElement(By.xpath("//select[@name='billing_address_id']")));
            	///selectNumber1.selectByValue("2749636");
        	}
        	
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Continue']"))).click();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@value='Continue']")));

        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 payment-method-next-step-button']"))).click();
        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 payment-info-next-step-button']"))).click();

        	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"))).click();

        	if(driver.findElement(By.xpath("//div[@class='page checkout-page']")).isDisplayed()) {
        		System.out.println("Success");
        	} else {
        		System.out.println("Failure");
        	}
        	
        	
        	///Thread.sleep(5000);
        	
        	
        	        	
        } catch (Exception e) {
        	System.out.println(e);
        } finally {
        	driver.quit();
        }

	}

}
