package com.Testlink;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;




public class AutomatedTest {

	public static String DEVKEY="0edca1a5f68bd4655d674a8c69b48565";
	public static String URL="http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";

	public static void reportResult(String TestProject,String TestPlan,String Testcase,String Build,String Notes,String Result) throws TestLinkAPIException{
	TestLinkAPIClient api=new TestLinkAPIClient(DEVKEY, URL);
	api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build, Notes, Result);
	}

	@Test
	public void Test1()throws Exception
	{
		AutomatedTest a=new AutomatedTest();
		System.setProperty("webdriver.chrome.driver", "X:\\Gerty\\Web Drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver, 600);
	String testProject="TestProject";
	String testPlan="TestPlan";
	String testCase="TestCase";
	String build="TestBuild";
	String notes=null;
	String result=null;
	try{
	driver.manage().window().maximize();
	driver.get("https://getgopay-uat.unionbankph.com/login/email");
	Thread.sleep(2000);
	driver.findElement(By.id("email")).sendKeys("(003)gopinath.rajaram@unionbankph.com");
	result= TestLinkAPIResults.TEST_PASSED;
	notes="Executed successfully";
	System.out.println(notes);
	}
	catch(Exception e){
	result=TestLinkAPIResults.TEST_FAILED;
	notes="Execution failed";
	}
	finally{

		AutomatedTest.reportResult(testProject, testPlan, testCase, build, notes, result);
	driver.quit();
	}
	}
}
