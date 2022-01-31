package testCases;

import baseClass.driverInstance;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.leaveSection;
import utilities.commonMethods;
import utilities.excelUtility;

import java.io.IOException;

public class TC3_leaveList extends driverInstance
{
    @Test(dataProvider = "LeaveList")
    public void leavedates (String username, String password, String newusername, String newpassword,String FromDate,
    String ToDate,String FromMonth,String ToMonth) throws IOException, InterruptedException {
        commonMethods cm = new commonMethods(driver);
        cm.loginactions(username,password);
        leaveSection ls = new leaveSection(driver);
        ls.hoverOnleavesection();
        ls.selectleavesection();
        ls.selectfromdate(FromDate,FromMonth);
        ls.selecttodate(ToDate, ToMonth);
        ls.testngdropdown("Finance");
        ls.selectcheckbox();
        ls.pastemployeecb();
        ls.tosearchleavepage();
    }
    @DataProvider(name="LeaveList")
    public  Object[][] adduser() throws IOException {
        excelUtility.setExcelfile("./src/test/resources/testData/Testdata.xlsx", "dataSheet");
        System.out.println("ed");
        String testcaseName=this.getClass().getSimpleName();
        int startingTestcaseRow = excelUtility.getrowcontains(testcaseName,0);
        Object[][] tablearray = excelUtility.getTableData(startingTestcaseRow);

        return (tablearray);
    }
}
