package Tests;

  import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import PageObject.Dialog;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class testPobranieCertyfikatuWCO extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
 UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();

        user.clickOnUserButton();
        user.typeIntoSearchUserField("KarolN");
        user.clickOnSearchButton();
        user.clickIntoCertificateButton();
        user.clickIntoDownloadCertificateButton();

        user.waitForFileDownloaded("123 (1).crt", 10,"C:\Users\User\Downloads");
        user.verifyDownloadFile("123 (1).crt","C:\Users\User\Downloads");

}}