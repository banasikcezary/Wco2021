package Tests;

  import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import PageObject.Dialog;
import PageObject.Roles;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class EdycjaRoli extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
 UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        Roles role = new Roles(driver);
        role.clickOnRolesButton();
        role.clickOnEditRole();
        String editRoleName="Rola123445";
        role.typeIntoEditRoleNameField(editRoleName);
        role.typeIntoEditRoleDescription("testEdycjiOpisu");
        role.clickOnSaveEditRoleButton();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        role.clickOnRolesButton();


        role.validateEditRole(editRoleName);

}}