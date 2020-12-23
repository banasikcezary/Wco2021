package Tests;

  import PageObject.LoginPage;
import PageObject.UserAndPermissions;
import PageObject.Configuration;
import PageObject.Dialog;
import PageObject.ShopPage;

  import org.testng.annotations.Test;
  import testng.listeners.RetryAnalyzer;
 
  public class DodanieNowegoUsera extends TestBase {
  
      @Test(         description ="as Admin Try Add New Certificate",         retryAnalyzer = RetryAnalyzer.class,         alwaysRun = true)
  public void test(){ LoginPage loginPage = new LoginPage(driver);
        loginPage.typeIntoPhoneNumberField("+48918171385");
        loginPage.typeIntoUsernameField("CRMNO5VWW56");
        loginPage.typeIntoPasswordField("Orange12345!");
        loginPage.clickIntoLogInButton();

        loginPage.checkPositiveLoginToApp();
ShopPage shopPage = new ShopPage(driver);
        shopPage.clickOnShopTab();
        shopPage.upValueUser();
        shopPage.clickOnSaveChangeButton();
        shopPage.checkSavingConfirmationText();

        Configuration configuration = new Configuration(driver);
        configuration.clickConfigurationLink();
        configuration.clickLinkUserList();
        configuration.selectNewUser();
        configuration.clickInCheckboxShowInGui();
        configuration.typeIntoLoginField("KarolN");

        configuration.typeIntoFirstNameField("Karol");
        configuration.typeIntoLastNameInputField("Nowak");
      //  configuration.typeIntoNumberInputField("666555777");

        configuration.typeIntoEmailInputField("qwerty@o2.pl");
        configuration.clickSaveButton();


        UserAndPermissions user = new UserAndPermissions(driver);
        user.clickOnUserAndPermissionButton();
        user.clickOnUserButton();
        user.clickOnClearButton();
        user.typeIntoSearchUserField("KarolN");
        user.clickOnSearchButton();

        user.assertUser("KarolN");

}}