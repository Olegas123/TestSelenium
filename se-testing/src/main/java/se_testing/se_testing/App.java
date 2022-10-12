package se_testing.se_testing;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
	public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriver driver = new ChromeDriver(chromeOptions);///JEI ERA JOKIU OPTIONU TJ IR NEREIK

        driver.get("https://demowebshop.tricentis.com/");
        
        try {
        	driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.xpath("//input[@value='Register']")).click();
            
            driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("agurkas");
            driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("bulve");
            driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(getSaltString()+"@gmail.com");

            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("kjadh@uhweH153");
            driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("kjadh@uhweH153");
            
            driver.findElement(By.xpath("//input[@name='register-button']")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            ///driver.findElement(By.xpath("")).click();

            driver.findElement(By.xpath("//a[@href='/computers']")).click();//Clicks computers
            driver.findElement(By.xpath("//img[@alt='Picture for category Desktops']")).click();//Clicks on desktop
            
            driver.findElement(By.xpath("//span[text()>=1500]/following::input[@value='Add to cart']")).click();
            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            
            driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/input[@value='Add to cart']")).click();//Clicks on add to cart
            driver.findElement(By.className("ico-cart")).click();//Clicks on shopping cart
            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));///ONLY ONCE
            
            driver.findElement(By.xpath("//input[@name='removefromcart']")).click();//Clicks on checkbox
            driver.findElement(By.xpath("//input[@name='updatecart']")).click();//Clicks on update shoppign cart
            
            if(driver.findElement(By.className("order-summary-content")).isDisplayed()) {
            	System.out.println("Success!");
            } else {
            	System.out.println("Bruh");
            }
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
////div[@class='item-box']//span[text()>=1500]/ancestor::node()[1]following-sibling::div/input[@value='Add to cart']
