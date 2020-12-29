package Tests;

import PageObject.LoginPage;
import PageObject.UserList;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import testng.listeners.RetryAnalyzer;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CsvExport extends TestBase {


    @Test(priority = 2,
            description = "as User Try Export Csv File",
            retryAnalyzer = RetryAnalyzer.class,
            alwaysRun = true)
    public void asUserTryExportCsvFile() throws AWTException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        userList.clickOnButtonExportToCsv();

        userList.waitForFileDownloaded();

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException ie){
        }
        userList.clickOnButtonExportToCsv();

        ////
   //     userList.verifyDownloadFile("/home/wco/selenium/newfile");

      //  "fileName.csv", 50,"//home//wco//selenium//newfile//"
        }

    }

