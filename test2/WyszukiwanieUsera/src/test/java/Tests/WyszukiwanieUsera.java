package Tests;

  import PageObject.LoginPage;
import PageObject.UserList;
import PageObject.Dialog;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class WyszukiwanieUsera extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
UserList userList = new UserList(driver);
        userList.clickIntoUserListLink();
        String user="KarolN";
        userList.selectAllColumns();
        userList.typeIntoSearchfield(user);
        userList.checkIfTheUserYouAreLookingForExists(user);

}}