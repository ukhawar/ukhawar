package Assignment;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import resources.base;

public class Home extends base {
    public WebDriver driver;
	@BeforeTest
	public void intialize() throws IOException
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
	    driver.get(prop.getProperty("urlgraph"));
	  
	}
	
	@Test
	public  void dashboardTest() throws IOException, InterruptedException 
	{
		Thread.sleep(5000);
		shadowDom();
		Thread.sleep(5000);
		DashboardPage dp = new DashboardPage(driver);
		String question1=dp.graphOne().getText();
		String bValueGraph1=getValue(question1);
		int q1b = Integer.parseInt(bValueGraph1);
		String question2=dp.graphTwo().getText();
		String bValueGraph2=getValue(question2);
		int q2b = Integer.parseInt(bValueGraph2);
		String question3=dp.graphThree().getText();
		String bValueGraph3=getValue(question3);
		int q3b = Integer.parseInt(bValueGraph3);
		driver.close();
		surveyComplete();
		intialize();
		Thread.sleep(5000);
		shadowDom();
		Thread.sleep(5000);
		DashboardPage dpa = new DashboardPage(driver);
		String qAfterSurvey1=dpa.graphOne().getText();
		String aValueGraph1=getValue(qAfterSurvey1);
		int q1a = Integer.parseInt(aValueGraph1);
		String qAfterSurvey2=dpa.graphTwo().getText();
		String aValueGraph2=getValue(qAfterSurvey2);
		int q2a = Integer.parseInt(aValueGraph2);
		String qAfterSurvey3=dpa.graphThree().getText();
		String aValueGraph3=getValue(qAfterSurvey3);
		int q3a = Integer.parseInt(aValueGraph3);
	    
		System.out.println("Survey Response Question#1 Graph");
		System.out.println("Total Count Before Survey for Question#1"+"  "+q1b);
		System.out.println("Total Count After Survey for Question#1"+"  "+q1a);
		System.out.println("Survey Response Question#2 Graph");
		System.out.println("Total Count Before Survey for Question#2"+"  "+q2b);
		System.out.println("Total Count After Survey for Question#2"+"  "+q2a);
		System.out.println("Survey Response Question#3 Graph");
		System.out.println("Total Count Before Survey for Question#3"+"  "+q3b);
		System.out.println("Total Count After Survey for Question#3"+"  "+q3a);
		assertTrue(q1b<q1a);
		assertTrue(q2b<q2a);
		assertTrue(q3b<q3a);
		System.out.println("Survey Responses saved successfully to their respected Graphs");
		driver.close();
 }
	@Test
	public  void quickResponeTest() throws IOException, InterruptedException 
	{
		intialize();
		Thread.sleep(5000);
		shadowDom();
		Thread.sleep(5000);
		DashboardPage dp = new DashboardPage(driver);
		String question1p=dp.graphOne().getText();
		String bValueGraph1p=getValue(question1p);
		int q1bp = Integer.parseInt(bValueGraph1p);
		driver.close();
		quickPartial();
		intialize();
		Thread.sleep(5000);
		shadowDom();
		Thread.sleep(5000);
		DashboardPage dpa = new DashboardPage(driver);
		String qAfterSurvey1p=dpa.graphOne().getText();
		String aValueGraph1p=getValue(qAfterSurvey1p);
		int q1ap = Integer.parseInt(aValueGraph1p);
		System.out.println("Survey Response Question#1 Graph");
		System.out.println("Total Count Before Survey for Question#1"+"  "+q1bp);
		System.out.println("Total Count After Survey for Question#1"+"  "+q1ap);
		assertTrue(q1bp<q1ap);
		System.out.println("Survey Responses not saved to their respected Graphs when Partial survey filled");
	    driver.close();
	}  
	
	@Test
	public  void partialResponeTest() throws IOException, InterruptedException 
	{
		intialize();
		Thread.sleep(5000);
		shadowDom();
		Thread.sleep(5000);
		DashboardPage dp = new DashboardPage(driver);
		String question1p=dp.graphOne().getText();
		String bValueGraph1p=getValue(question1p);
		int q1bp = Integer.parseInt(bValueGraph1p);
		driver.close();
		surveyPartial();
		intialize();
		Thread.sleep(5000);
		shadowDom();
		Thread.sleep(5000);
		DashboardPage dpa = new DashboardPage(driver);
		String qAfterSurvey1p=dpa.graphOne().getText();
		String aValueGraph1p=getValue(qAfterSurvey1p);
		int q1ap = Integer.parseInt(aValueGraph1p);
		System.out.println("Survey Response Question#1 Graph");
		System.out.println("Total Count Before Survey for Question#1"+"  "+q1bp);
		System.out.println("Total Count After Survey for Question#1"+"  "+q1ap);
		assertTrue(q1bp<q1ap);
		System.out.println("Survey Responses not saved to their respected Graphs when Partial survey filled");
	    driver.close();
	}
	public void shadowDom() throws InterruptedException
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        String str="return document.querySelector('#usercentrics-root').shadowRoot.querySelector('#uc-center-container > div.sc-ikJyIC.jegfVy > div > div.sc-dlVxhl.bEDIID > div > button')";
			
		WebElement shadowdom = (WebElement)jsExecutor.executeScript(str);
		Thread.sleep(8000);
		shadowdom.click();
		
	}
	
   @AfterTest
	public void teardown()
	{
		driver.close();
	}
}
