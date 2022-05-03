package testCases;

import baseClass.driverInstance;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.adminPage;
import utilities.Assertion_Check;
import utilities.commonMethods;
import utilities.excelUtility;

import java.io.IOException;


public class TC2_adminPage extends driverInstance
{
    boolean titleresult=false,adminPage=false;

    @Test(dataProvider = "addnewuser")
    public void toadminsection(String username, String password, String newusername, String newpassword) throws IOException, InterruptedException
    {
        commonMethods cm = new commonMethods(driver);
        titleresult=cm.loginactions(username, password);
        Assertion_Check.mark("test-01", titleresult, "Title verification");
        Thread.sleep(2000);
        adminPage ap = new adminPage(driver);
        adminPage=ap.adminpage_navigation();
        Assertion_Check.mark("test-01", adminPage, "Title verification");
        ap.clickAddInAdmin();
        ap.enternewUsername(newusername);
        ap.enternewpassword(newpassword);
        ap.enterconfirmpassword(newpassword);
        ap.tosavenewuser();
        Thread.sleep(2000);
        ap.searchcreateduser(newusername);
    }
    @DataProvider(name="addnewuser")
    public  Object[][] adduser() throws IOException {



        //sample=new Object[][] {{"Admin","admin123","Akhil","Test@1234"},{"Admin","admin123","John","Test"}};
           System.out.println("Ab");
            excelUtility.setExcelfile("./src/test/resources/testData/QATESTDATA_New.xlsx", "dataSheet");
        System.out.println("Ab");
            String testcaseName=this.getClass().getSimpleName();
            int startingTestcaseRow = excelUtility.getrowcontains(testcaseName,0);
        System.out.println("Ab");
            Object[][] tablearray = excelUtility.getTableData(startingTestcaseRow);

        return (tablearray);
    }
}
