package se_testing.se_testing;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Duration;
import java.util.*;
 
public class Test4Lab {
    static ChromeDriver driver = new ChromeDriver();
    static String email = getSaltString()+"@gmail.com";
    static String data;
 
    @BeforeClass
    public static void Register() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));        
        try {
        	driver.get("https://demowebshop.tricentis.com");
        	driver.findElement(By.className("ico-login")).click();
        	driver.findElement(By.xpath("//input[@value='Register']")).click();
        
        	driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("agurkas");
        	driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("bulve");
        	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("kjadh@uhweH153");
        	driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("kjadh@uhweH153");
        
        	driver.findElement(By.xpath("//input[@name='register-button']")).click();
        	driver.findElement(By.xpath("//input[@value='Continue']")).click();
        } catch (Exception e) {
        	System.out.println(e);
        } finally {
        	driver.close();
        }
    }
 
    @Before
    public void Login() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    	driver.get("https://demowebshop.tricentis.com/");
        try {
        	driver.findElement(By.xpath("//a[@href='/login']")).click();
        	driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
        	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("kjadh@uhweH153");
        	driver.findElement(By.xpath("//input[@value='Log in']")).click();
        } catch (Exception e) {
        	System.out.println(e);
        	///driver.quit();
        }
    }
 
    @Test
    public void test1() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.findElement(By.xpath("//a[@href='/digital-downloads']")).click();
        try {
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

        	assertTrue(driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']")).isDisplayed());
        } catch (Exception e) {
        	System.out.println(e);
        } finally {
        	driver.quit();
        }
    }
 
    @Test
    public void test2() throws InterruptedException {
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            driver.findElement(By.xpath("//a[@href='/digital-downloads']")).click();
        	
        	BufferedReader reader2;
        	
        	reader2 = new BufferedReader(new FileReader("data2.txt"));
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

        	assertTrue(driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']")).isDisplayed());
        } catch (Exception e) {
        	System.out.println(e);
        } finally {
        	driver.quit();
        }
    	
    }

	protected static String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}