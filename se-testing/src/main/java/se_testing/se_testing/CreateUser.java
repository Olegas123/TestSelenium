package se_testing.se_testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("unused")
public class CreateUser {

	///@Before
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        try {
        	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        	driver.findElement(By.className("ico-login")).click();
            driver.findElement(By.xpath("//input[@value='Register']")).click();
            
            driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("agurkas");
            driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("bulve");
            
            String email = getSaltString()+"@gmail.com";
            
            driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);

            driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("kjadh@uhweH153");
            driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("kjadh@uhweH153");
            
            driver.findElement(By.xpath("//input[@name='register-button']")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
        	
            PrintWriter writer = new PrintWriter("user.txt");
            writer.print("");
            writer.close();
            
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("user.txt"));
            writer2.write(email);
            
            writer2.close();
        	
        	        	
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
