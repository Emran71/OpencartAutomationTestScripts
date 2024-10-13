package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;


	@BeforeClass
	@Parameters({"OS","browser"})
	public void setupBrowser(String os, String br) throws IOException
	{   FileReader file = new FileReader(".//src//test/resources//config.properties");
	p= new Properties();
	p.load(file);

	logger = LogManager.getLogger(this.getClass());

	if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		if(os.equalsIgnoreCase("Windows"))
		{
			cap.setPlatform(Platform.WIN10);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			cap.setPlatform(Platform.MAC);
		}
		else 
		{
			System.out.println("No match OS");
		}

		switch(br.toLowerCase())
		{
		case "chrome": cap.setBrowserName("chrome");break;
		case "firefox": cap.setBrowserName("firefox");break;
		case "edge": cap.setBrowserName("edge");break;
		default: System.out.println("Invalid browser"); return;
		}
		
		driver= new RemoteWebDriver(new URL("http://192.168.56.1:4444/wd/hub"),cap);

	}

	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
		switch(br.toLowerCase()) {
		case "chrome": driver= new ChromeDriver();break;
		case "firefox": driver= new FirefoxDriver();break;
		default: System.out.println("Invalid browser"); return;
		}
	}


	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(p.getProperty("appurl"));   // reading data from properties file
	driver.manage().window().maximize();
	}

	@AfterClass
	public void closetest()
	{
		driver.quit();
	}


	public String randomCharacterGenerate() 
	{
		String characters = RandomStringUtils.randomAlphabetic(6);
		return characters;
	}


	public String randomNumberGenerate() 
	{
		String number = RandomStringUtils.randomNumeric(11);
		return number;
	}


	public String randomAlphaNumaricGenerate() 
	{
		String alphanumeric = RandomStringUtils.randomAlphanumeric(10);
		return alphanumeric;
	}

	public String captureScreen (String tname) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png" ;

		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
}
