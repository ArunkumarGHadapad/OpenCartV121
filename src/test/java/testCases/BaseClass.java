package testCases;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	
	public static WebDriver driver;
	public Logger logger; //log4j class
	public Properties p;
	  String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); //Timestap
	
	@SuppressWarnings("deprecation")
	@Parameters({"os" , "browser"})
	@BeforeClass(groups={"Regression","Master","Sanity"})
	public void Setup(String os,String br) throws IOException {
		
		//Loading Confg.file
		FileReader fr=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(fr);
		
		logger=LogManager.getLogger(this.getClass());
		if(p.getProperty("excution_Env").equalsIgnoreCase("remote")) {
			
			DesiredCapabilities dc=new DesiredCapabilities();
			//OS
			if(os.equalsIgnoreCase("windows")) {
				dc.setPlatform(Platform.WIN10);
			}
			else if(os.equalsIgnoreCase("mac")) {
				dc.setPlatform(Platform.MAC);
			}
			else {
				System.out.print("No Matching OS");return;
			}
			
			//browser
			switch(br.toLowerCase()) {
			case "chrome":dc.setBrowserName("chrome"); break;
			case "edge":dc.setBrowserName("Microsoftedge");break;
			case "firefox":dc.setBrowserName("firefox");;break;
			default : System.out.println("Invalid Browser name......");return;
			}
			
			 driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
		}
		
		
		if(p.getProperty("excution_Env").equalsIgnoreCase("local")) {
		
		switch(br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver(); break;
		case "edge":driver=new EdgeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default : System.out.println("Invalid Browser name......");return;
		}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	
		
	
	
	@AfterClass(groups={"Regression","Master","Sanity"})
	public void tearDown() {
		driver.close();
	}
	
	public String randomeString() {
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
}

	public String randomNumeric() {
	String generatedString=RandomStringUtils.randomNumeric(10);
	return generatedString;
	}
	
	public String captureScreen(String tname) {
		
		TakesScreenshot tss= (TakesScreenshot) driver;
		File SrcFile= tss.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timeStamp;
		File targetPath=new File(targetFilePath);
		SrcFile.renameTo(targetPath);
		return targetFilePath;
		
	}
	
	public String randomAlphNumeric() {
	String generatedString=RandomStringUtils.randomNumeric(10);
	String generatedString1=RandomStringUtils.randomAlphabetic(5);
	return (generatedString+"@"+generatedString1);
	}
	
	
}
