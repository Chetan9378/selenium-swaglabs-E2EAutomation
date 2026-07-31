package practiceWebsite1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Swaglabs {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--guest");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
		driver.findElement(By.className("checkout_button")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
		firstname.sendKeys("Test");
		driver.findElement(By.id("last-name")).sendKeys("Name");
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("487952");
		driver.findElement(By.name("continue")).click();
		driver.findElement(By.className("cart_button")).click();
		WebElement message =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Thank you for your order!']")));
		System.out.println(message.getText());
		driver.findElement(By.id("generate-pdf-order")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("react-burger-menu-btn"))).click();
		driver.findElement(By.id("logout_sidebar_link")).click();

	}

}
