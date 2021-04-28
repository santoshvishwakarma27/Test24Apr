package TestMavenProject_Mavenproject;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class AppTest {

  //@Test
  public void f() throws IOException {
	  
	  System.out.println("santosh");
	  System.out.println(System.getProperty("user.dir"));
	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
	  WebDriver driver=new FirefoxDriver();
	  driver.get("https://www.google.com/");
	  System.out.println(driver.getTitle());
	  File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(f,new File("D:\\test.png"));
  }
  
  
  
  //@Test
  public void windows() throws IOException {
	  
	  System.out.println("santosh");
	  System.out.println(System.getProperty("user.dir"));
	  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
	  WebDriver driver=new FirefoxDriver();
	  driver.get("https://accounts.google.com/ServiceLogin/signinchooser?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%26ogbl%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	  String parent=driver.getWindowHandle();
	  
	  WebElement terms=driver.findElement(By.partialLinkText("Terms"));
	  terms.click();
	  
	  driver.switchTo().window(parent);
	  
	  WebElement help=driver.findElement(By.partialLinkText("Help"));
	  help.click();
	  
	  Set<String> handles=driver.getWindowHandles();
	  System.out.println("set val"+handles);
	  
	  for(String handle:handles)
	  {
		 driver.switchTo().window(handle);
		 System.out.println(driver.getTitle());
		 System.out.println(handle);
		 
		 // if(!driver.getTitle().equalsIgnoreCase("Gmail"))
		  //{
			//  driver.switchTo().window(handle);
			  //driver.switchTo().window(parent);
			  //System.out.println("landed on gmail page");
			  
		  //}
	  }
	  
	  
	  
  }
	  
	
	@Test(priority=-1)
	public void p()
	{
		System.out.println("P=-2");
	}
	
	@Test(priority=-2)
	public void a()
	{
		System.out.println("P=-1");
	}
	
	@Test(priority=0)
	public void p0()
	{
		System.out.println("P=0");
	}
	
	@Test
	@Parameters("url")
	public void testparam(String url) throws IOException {
		  
		  System.out.println("santosh");
		  System.out.println(System.getProperty("user.dir"));
		  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
		  WebDriver driver=new FirefoxDriver();
		  driver.get(url);
		  System.out.println("URL:"+url);
		  //System.out.println("Site name"+sitename);
		  
	  }

	
	
}
