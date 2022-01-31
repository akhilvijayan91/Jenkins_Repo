package page;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.extentReportUtility;
import utilities.utilityFecthProperty;

import java.io.IOException;
import java.util.List;

public class adminPage {
    WebDriver driver;

    public adminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void adminpage_usrmgm() throws IOException, InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("goto_adminpage_section_ursmgm"))).click();
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_addusr_btn"))).click();
    }

    public void enternewUsername(String newusername) throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_ursmgm_employername_fld"))).sendKeys("Orange Test");
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_ursmgm_new_username_fld"))).sendKeys(newusername);
        extentReportUtility.loger.log(Status.INFO, "Succesfully entered your new username");
    }

    public void enternewpassword(String newpassword) throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_ursmgm_new_password_fld"))).sendKeys(newpassword);
        extentReportUtility.loger.log(Status.INFO, "Succesfully entered new Password");
    }

    public void enterconfirmpassword(String cfmpassword) throws IOException, InterruptedException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_ursmgm_cfm_password_fld"))).sendKeys(cfmpassword);
        extentReportUtility.loger.log(Status.INFO, "Succesfully confirmed your new Password");
    }

    public void tosavenewuser() throws IOException, InterruptedException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_savenewuser_btn"))).click();
        Thread.sleep(3000);
        List<WebElement> ele = driver.findElements(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_systemnusers_lbl")));
        //for (int i=0;ele.size()<=1;i++)
        if(ele.size()<=1)
        {
            driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_savenewuser_btn"))).click();

        }
        extentReportUtility.loger.log(Status.INFO, "Succesfully saved new user");

    }

    public void searchcreateduser(String newusername) throws InterruptedException, IOException {
        Thread.sleep(3000);
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_search_username_fld"))).sendKeys(newusername);
        extentReportUtility.loger.log(Status.INFO, "Succesfully entered new user to search");
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_search_empolyername_fld"))).sendKeys("Orange Test");
        Thread.sleep(3000);
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("adminpage_searchnewuser_btn"))).click();
        extentReportUtility.loger.log(Status.INFO, "Searched new user");
        Thread.sleep(3000);
    }
}
