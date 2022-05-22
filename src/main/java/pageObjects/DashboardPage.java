package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
	
	public WebDriver driver;
	
	By graphOne=By.xpath("(//*[@class='highcharts-credits'])[1]");
	By graphTwo=By.xpath("(//*[@class='highcharts-credits'])[2]");
    By graphThree=By.xpath("(//*[@class='highcharts-credits'])[3]");

	
	public DashboardPage(WebDriver driver) {
		
		this.driver=driver;
	}

	/*public DashboardPage() {
		//this.driver = driver;
		
	}*/
	public WebElement graphOne()
	{
		return driver.findElement(graphOne);
	}
	public WebElement graphTwo()
	{
		return driver.findElement(graphTwo);
	}
	public WebElement graphThree()
	{
		return driver.findElement(graphThree);
	}
    



}
