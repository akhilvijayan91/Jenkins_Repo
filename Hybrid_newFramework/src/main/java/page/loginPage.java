package page;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.extentReportUtility;
import utilities.utilityFecthProperty;

import java.io.IOException;

public class loginPage
{
    WebDriver driver;
    public loginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterUserName(String username) throws IOException
    {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("loginpage_username_fld"))).sendKeys(username);
        extentReportUtility.loger.log(Status.INFO,"Succesfully entered Username: "+username);
    }
    public void enterpassword(String password) throws IOException
    {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("loginpage_password_fld"))).sendKeys(password);
        extentReportUtility.loger.log(Status.INFO,"Succesfully entered Password: "+password);
    }
    public void tosignin() throws IOException
    {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("loginpage_signin_btn"))).click();
        extentReportUtility.loger.log(Status.INFO,"Succesfully signed in");
    }
}
