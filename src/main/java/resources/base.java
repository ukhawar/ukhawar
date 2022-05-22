package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.SurveyPage;

public class base {

	public WebDriver driver;
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException 
	{
		prop = new Properties();   // Object of properties setup
	    FileInputStream fis = new FileInputStream ("D:\\Selenium Training\\E2EProject\\src\\main\\java\\resources\\data.properties");
		
	    prop.load(fis);
	    String browserName = prop.getProperty("browser");
	    
	    if (browserName.equals("chrome"))
	    {
	    	System.setProperty("webdriver.chrome.driver", "D:\\Selenium Training\\chromedriver_win32\\chromedriver.exe");
	       driver = new ChromeDriver();
	    	
	    }
	    else if (browserName.equals("firefox"))
	    {
	    	
	    }
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    return driver;
	}
	
	public String getValue (String question)
	{
		String q1 = question.replaceAll("[^0-9]", "");
		return q1;
	}
	
	public void surveyComplete() throws IOException, InterruptedException
	{
	driver = initializeDriver();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("urlsurvey"));
	Thread.sleep(5000);
	SurveyPage sp = new SurveyPage(driver);
	sp.startsurvey().click();
	sp.questionOne().click();
	sp.pageOneNext().click();	
	sp.questionTwo().sendKeys("3");
	sp.pageTwoNext().click();
	sp.questionThree().click();
	sp.pageThreeNext().click();
	sp.driver.close();
	System.out.println("Survey Completed Successfully");
	}
	public void quickPartial() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("urlsurvey"));
		Thread.sleep(5000);
		SurveyPage sp = new SurveyPage(driver);
		sp.startsurvey().click();
		sp.questionOne().click();
		driver.close();
	}
	public void surveyPartial() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("urlsurvey"));
		Thread.sleep(5000);
		SurveyPage sp = new SurveyPage(driver);
		sp.startsurvey().click();
		sp.questionOne().click();
		sp.pageOneNext().click();
		sp.questionTwo().sendKeys("1");
		sp.questionTwo().click();
		driver.close();
	}
	public void getScreenShots(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		
	}

}
