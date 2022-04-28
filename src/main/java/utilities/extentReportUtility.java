package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class    extentReportUtility
{
    public static ExtentReports reporter;
    public static ExtentTest loger;
    public static void createExtentReportInstance (String className)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_SSS");
        Date now = new Date();
        String timeStamp = sdf.format(now);
        ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/"+className+timeStamp+".html");
        spark.config().setDocumentTitle("For testing Doc title name");
        spark.config().setReportName("For Testing Report Title name");
        spark.config().setTheme(Theme.DARK);
        reporter = new ExtentReports();
        reporter.attachReporter(spark);
        loger = reporter.createTest(className);
    }
    public static void printReport (ITestResult Result, WebDriver driver) throws IOException {
        if (Result.getStatus()==ITestResult.SUCCESS){
            loger.log(Status.PASS, MarkupHelper.createLabel(Result.getName()+"Test has passed", ExtentColor.GREEN));
        }
        else if (Result.getStatus()==ITestResult.FAILURE){
            loger.log(Status.FAIL, MarkupHelper.createLabel(Result.getName()+"Test has Failed", ExtentColor.RED));
            loger.fail(Result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(scrnShotUtility.getscrnshotasbase64(driver)).build());
        }
        else {
            loger.log(Status.SKIP, MarkupHelper.createLabel(Result.getName()+"Test Skiped", ExtentColor.YELLOW));
        }
        reporter.flush();

    }
}
