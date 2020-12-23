package Tests;

  import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import PageObject.Dialog;
import PageObject.GroupPage;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class EdycjaGrupy extends TestBase {
  
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
        group.clickOnEditGroupButton();
        String editName="test123";
        group.typeIntoAddNameField(editName);
        group.typeIntoAddDescriptionField("test opisu grupy");
        group.clickOnSaveNewGroupButton();

        group.validateAddNewGroup(editName);

}}