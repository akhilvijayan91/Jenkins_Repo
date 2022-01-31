package testCases;

import baseClass.driverInstance;
import page.assignLeave;
import utilities.commonMethods;

import java.io.IOException;

public class TC4_applyLeave extends driverInstance
{
    public void applyleave() throws IOException {
        commonMethods cmm = new commonMethods(driver);
        cmm.loginactions("Admin", "admin123");
        assignLeave al = new assignLeave();
        al.assignleavepage();
        al.enteremployename();
        al.enterleavetype();
        al.enterfromdate("4", "Feb");
        al.entertodate("25", "Dec");
        al.enterduration("Half Day");
        al.entercomment("The new comment");
        al.clickonassignbutton();
    }
}
