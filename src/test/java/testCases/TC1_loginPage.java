package testCases;

import baseClass.driverInstance;
import org.testng.annotations.Test;
import utilities.commonMethods;

import java.io.IOException;

public class TC1_loginPage extends driverInstance {
    @Test(priority = 1)
    public void validateLogin() throws IOException {
        commonMethods cm = new commonMethods(driver);
        cm.loginactions("Ädmin", "admin123");

   /* @Test(priority = 2)
    public void toadminsection() throws IOException, InterruptedException
    {
        validateLogin();
        adminPage ap = new adminPage(driver);
        ap.adminpage_usrmgm();
        ap.enternewUsername("Mathayi Mapilery");
        ap.enternewpassword("Abcd@1234");
        ap.enterconfirmpassword("Abcd@1234");
        ap.tosavenewuser();
        Thread.sleep(3000);
        ap.searchcreateduser("Mathayi Mapilery");
    }*/

    }
}
