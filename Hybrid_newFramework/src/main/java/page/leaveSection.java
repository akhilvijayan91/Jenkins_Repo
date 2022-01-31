package page;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.extentReportUtility;
import utilities.utilityFecthProperty;

import java.io.IOException;
import java.util.List;

public class leaveSection
{
    WebDriver driver;
    public leaveSection(WebDriver driver)
    {
        this.driver = driver;
    }
    public void hoverOnleavesection() throws InterruptedException, IOException {
        Actions act= new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leave_main_tab")))).build().perform();
         Thread.sleep(3000);
    }



    public void selectleavesection() throws InterruptedException, IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("lavepage_leavelist_section"))).click();
        Thread.sleep(3000);
    }
    public void selectfromdate(String fdat, String fmonth) throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_fromdate_pickericon"))).click();
        extentReportUtility.loger.log(Status.INFO, "Succesfully click on From date picker");
        Select indro = new Select((driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_fromdate_pickermonth")))));
        indro.selectByVisibleText("fmonth");
        extentReportUtility.loger.log(Status.INFO, "Succesfully selected the From month");
        List<WebElement> jam = driver.findElements(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_fromdate_dateselection")));
        for (WebElement dat: jam) {
            if (dat.getText().equalsIgnoreCase("fdat")) {
                dat.click();
                break;
            }
        }
        extentReportUtility.loger.log(Status.INFO, "Succesfully selected the From date");
    }
    public void selecttodate(String tdat, String tmonth)throws IOException
    {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_todate_pickericon"))).click();
        Select map = new Select((driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_todate_pickermonth")))));
        map.selectByVisibleText(tmonth);
        List <WebElement> jem = driver.findElements(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_todate_dateselection")));
        for (WebElement ner:jem)
        {
            if (ner.getText().equalsIgnoreCase("tdat"))
            {
                ner.click();
                break;
            }
        }
        extentReportUtility.loger.log(Status.INFO, "Succesfully selected the To date");
    }
    public void testngdropdown(String droval) throws IOException {
        Select dropdown = new Select(( driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_dropdown_fld")))));
        dropdown.selectByVisibleText(droval);
        extentReportUtility.loger.log(Status.INFO, "Succesfully selected the Sub Unit value");
    }
    public void selectcheckbox() throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_allcheckbox"))).click();
        extentReportUtility.loger.log(Status.INFO, "Succesfully selected checkbox of \"Show leave with Status\"");

    }
    public void pastemployeecb() throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_pastemployee_checkbox"))).click();
        extentReportUtility.loger.log(Status.INFO, "Succesfully selected the check box of Include Past Employee");
    }
    public void tosearchleavepage() throws IOException {
        driver.findElement(By.xpath(utilityFecthProperty.fetchLocaterValue("leavepage_search_btn"))).click();
        extentReportUtility.loger.log(Status.INFO, "Succesfully selected search button");
    }
}
