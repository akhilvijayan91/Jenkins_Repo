package page;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.extentReportUtility;
import utilities.utilityFecthProperty;

import java.io.IOException;
import java.util.List;

public class assignLeave {
    WebDriver driver;

    public assignLeave() {
        this.driver = driver;
    }

    public void assignleavepage() throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_assignleave_section"))).click();
        extentReportUtility.loger.log(Status.INFO, "Succesfully click assign leave section");
    }

    public void enteremployename() throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_employeename_fld"))).sendKeys("Orange Test");
        extentReportUtility.loger.log(Status.INFO, "Succesfully entered employee name");
    }

    public void enterleavetype() throws IOException {
        Select dropdown = new Select(driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_leavetype_drodow"))));
        dropdown.selectByVisibleText("US -FMLA");
        extentReportUtility.loger.log(Status.INFO, "Succesfully added dropdown value");
    }

    public void enterfromdate(String fromdate, String frommonth) throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_fromdatepicker_icon"))).click();
        Select pic = new Select(driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_fromdatepicker_month"))));
        pic.selectByVisibleText(frommonth);
        List<WebElement> fromdat = driver.findElements(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_fromdate_dateselection")));
        for (WebElement nar : fromdat) {
            if (nar.getText().equalsIgnoreCase(fromdate)) {
                nar.click();
                break;
            }
        }
        extentReportUtility.loger.log(Status.INFO, "Succesfully added from date");
    }

    public void entertodate(String todate, String tomonth) throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_todatepicker_icon"))).click();
        Select pic = new Select(driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_todatepicker_month"))));
        pic.selectByVisibleText(tomonth);
        List<WebElement> fromdat = driver.findElements(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_todate_dateselection")));
        for (WebElement nar : fromdat) {
            if (nar.getText().equalsIgnoreCase(todate)) {
                nar.click();
                break;
            }
        }
        extentReportUtility.loger.log(Status.INFO, "Succesfully added to date");
    }

    public void enterduration(String duration) throws IOException {
        Select durdrop = new Select(driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_duration_drodow"))));
        durdrop.selectByVisibleText(duration);
        extentReportUtility.loger.log(Status.INFO, "Succesfully added duration");
        if (duration.equalsIgnoreCase("Half Day")) {
            Select subdurdrop = new Select(driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_duration_subdrodow"))));
            subdurdrop.selectByVisibleText("Afternoon");
        }
    }

    public void entercomment(String comment) throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_comment"))).sendKeys(comment);
        extentReportUtility.loger.log(Status.INFO, "Succesfully added Comment");
    }

    public void clickonassignbutton() throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("assignleave_assign_btn"))).click();
        extentReportUtility.loger.log(Status.INFO, "Succesfully clicked on assign button");
    }//Half Day
}
