package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SurveyPage {
	
	public WebDriver driver;
	
	By click =By.id("startSurvey");
	By question1=By.xpath("//p[text()='Yellow']");
	By pageOneNext=By.id("nextPage");
	By question2= By.xpath("//input[@type='text']");
	By pageTwoNext=By.id("nextPage");
	By question3= By.xpath("//div[@class='qRadioDisplay']");
	By pageThreeNext=By.id("nextPage");
    By surveyComp = By.xpath("//div[@class='endPageText clearFloat']");
	
	public SurveyPage(WebDriver driver) {
		
		this.driver=driver;
		
	}

	public WebElement startsurvey()
	{
		return driver.findElement(click);
	}
	public WebElement questionOne()
	{
		return driver.findElement(question1);
	}
	public WebElement pageOneNext()
	{
		return driver.findElement(pageOneNext);
	}
	public WebElement questionTwo()
	{
		return driver.findElement(question2);
	}
	public WebElement pageTwoNext()
	{
		return driver.findElement(pageTwoNext);
	}
	public WebElement questionThree()
	{
		
		return driver.findElement(question3);
	}
	public WebElement pageThreeNext()
	{
		
		return driver.findElement(pageThreeNext);
	}
	public WebElement surveyComp()
	{
		
		return driver.findElement(surveyComp);
	}
}
