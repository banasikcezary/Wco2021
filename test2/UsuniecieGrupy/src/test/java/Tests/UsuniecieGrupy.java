package Tests;

  import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import PageObject.Dialog;
import PageObject.GroupPage;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class UsuniecieGrupy extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        GroupPage group = new GroupPage(driver);
        group.clickOnGroupButton();
        group.clickOnChooseGroup();
        String groupName ="test123";
        Dialog dialog = new Dialog(driver);

        group.clickOnDeleteGroupButton(groupName);
        dialog.clickOnConfirmButton();
        dialog.clickOnAcceptPopupButton();


        group.validateDeleteGroup(groupName);

}}