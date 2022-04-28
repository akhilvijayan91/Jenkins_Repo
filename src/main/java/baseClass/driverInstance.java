package baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.eventHandler;
import utilities.extentReportUtility;
import utilities.utilityFecthProperty;

import java.io.IOException;

public class driverInstance
{
   public  String className;
    public WebDriver driver;
    @BeforeMethod
    public void InitiateDriverInstance () throws IOException {
        String browsername = utilityFecthProperty.fetchPropertyValue("browser");
        switch (browsername)
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "deco":
                WebDriverManager.chromedriver().setup();
                WebDriverListener listener = new eventHandler();
                WebDriver driverOrginal = new ChromeDriver();
                driver=new EventFiringDecorator(listener).decorate(driverOrginal);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        className = this.getClass().getSimpleName();
        extentReportUtility.createExtentReportInstance(className);
        driver.get(utilityFecthProperty.fetchPropertyValue("url"));
        driver.manage().window().maximize();


    }
    @AfterMethod
    public void closeInstance(ITestResult Result) throws IOException
    {
        extentReportUtility.printReport(Result,driver);
        driver.quit();
    }
}
