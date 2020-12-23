package Tests;

  import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import PageObject.Dialog;
import PageObject.Roles;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class DodanieNowejRoli extends TestBase {
  
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
        role.clickOnAddRoleButton();
        String rola="testRoleName";
        role.typeIntoAddRoleNameField(rola);
        role.typeIntoAddRoleDescriptionField("Rola123");
        role.clickOnSaveNewRole();
        Dialog dialog = new Dialog(driver);
        dialog.clickOnAcceptPopupButton();
        dialog.refreshPage();
        role.clickOnRolesButton();

        role.validateAddRole(rola);

}}