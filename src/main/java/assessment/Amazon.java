package assessment;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		 String path="./data/twitterexcel.xls";
		 ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();// maximize the window
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		WebElement mainmenu=driver.findElementByXPath("//span[text()='Shop by']");
		Actions act = new Actions(driver);
		act.moveToElement(mainmenu).build().perform();
		
		WebElement submenu=driver.findElementByXPath("//span[text()='Books']");
		act.moveToElement(submenu).build().perform();
		driver.findElementByXPath("//span[text()='School Textbooks']").click();
		
		driver.findElementByClassName("aok-align-center").click();
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows.size());
		ArrayList<String> allHandles = new ArrayList<String>(); 
		allHandles.addAll(allWindows);
		String secondWindow = allHandles.get(1);
		driver.switchTo().window(secondWindow);
		
		driver.findElementById("add-to-cart-button").click();
			
	}

}