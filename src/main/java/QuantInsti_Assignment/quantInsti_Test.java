package QuantInsti_Assignment;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class quantInsti_Test {

	WebDriver driver;
	String mainUrl = "https://quantra.quantinsti.com/";

	@BeforeMethod()
	public void launchUrl() {

		System.setProperty("webdriver.chrome.driver",
				"E:\\Ruchi\\JAVA_Coding_Practice\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(mainUrl);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("acceptSslCerts", true);
		capabilities.setCapability("acceptInsecureCerts", true);
	}

	@Test()
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"right-navigation\"]/ul/div[1]/li[4]/button/span/span")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/form/div[2]/div[3]/div[1]/div[1]/input")).sendKeys("ruchisingh771.rs@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/form/div[2]/div[3]/div[1]/div[2]/input")).sendKeys("Tokio@123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/form/div[2]/div[3]/div[3]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"right-navigation\"]/ul/div[1]/li[5]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"right-navigation\"]/ul/div[1]/li[5]/div/div[2]/ul/li[7]")).click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String course = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div[2]/div/div[1]/h1")).getText();
		System.out.println("print the course" + course);
		String price = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div[2]/div/div[2]/div[1]/div[3]/div[2]/span[2]/span")).getText();
		System.out.println("print the price:" + price);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/div/div[1]/div[2]/div/div[2]/div[2]/button")).click();
		// String courseName = driver.findElements(By.className("cart-item").Count());
		System.out.println("Inside cart item");
		WebElement parentElement = driver.findElement(By.className("cart-item-details"));
		List<WebElement> childDivs = parentElement.findElements(By.className("cart-item"));
		int NoOfDivs = childDivs.size();
		System.out.println("get the courseName:" + NoOfDivs);
		String BaseAmount = driver.findElement(By.className("cart-summary-right")).getText();
		System.out.println("Base Amount:" + BaseAmount);
		String AmountPayable = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/div/div/div/div[2]/div[1]/div[7]/div[2]/h5/span")).getText();
		System.out.println("Amount Payable:" + AmountPayable);
		driver.findElement(By.xpath("//*[@href='/course/python-for-trading']")).click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div/a[2]")).click();
		Thread.sleep(2000);
		String delete_message = driver.findElement(By.cssSelector(".toasted.toasted-primary.info")).getText();
		System.out.println("Deleted Message:" + delete_message);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/main/div/div/div/div[2]/div[1]/div[3]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"coupon-modal\"]/div[2]/div/div/form/div[2]/input")).sendKeys("ABC");
		driver.findElement(By.xpath("//*[@id=\"coupon-modal\"]/div[2]/div/div/form/div[3]/button/span/span")).click();
		String couponAlert = driver.findElement(By.className("coupon-alert-box")).getText();
		System.out.println("coupon-alert-box : " + couponAlert);
		driver.findElement(By.className("close")).click();

	}

	@AfterMethod
	public void logOut()  {
		
		 System.out.println("Inside logout"); 
		 driver.findElement(By.xpath("//*[@id=\"right-navigation\"]/ul/div[1]/li[6]/div[1]")).click();
		 
		 //driver.findElement(By.className("profile-pic-initials")).click();
		  System.out.println("Inside logout 2"); driver.findElement(By.xpath(
		  "//*[@id=\"right-navigation\"]/ul/div[1]/li[6]/div[2]/ul/li[5]/a")).click();
		 driver.quit();
		 

	}

}
