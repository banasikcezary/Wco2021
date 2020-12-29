package Tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import testng.listeners.TestListener;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners(TestListener.class)

public class TestBase {


    public WebDriver driver;

    @Step("Loading configuration from configuration.properties")
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws MalformedURLException {

    



        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-save-password-bubble");



        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "/home/wco/selenium/newfile");
        prefs.put(" download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
      //  prefs.put("safebrowsing.enabled", false);
        prefs.put("profile.default_content_settings.popups",0);
       // prefs.put("behavior", "allow");
    //    prefs.put("safebrowsing.disable_download_protection", true);
      //  prefs.put("browser.download.manager.showWhenStarting", false);
        prefs.put("profile.default_content_setting_values.automatic_downloads",1);
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled", false);


        options.setExperimentalOption("prefs", prefs);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


        driver = new RemoteWebDriver(new URL("http://172.25.0.33:4448/wd/hub"), capabilities);

        RemoteWebDriver remoteWebDriver = (RemoteWebDriver) this.driver;
        remoteWebDriver.setFileDetector(new LocalFileDetector());

        driver.navigate().to("http://172.25.0.33:7088/cert-wco/");
        System.out.println("Open Browser");
    }

    @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {

        driver.close();
        driver.quit();

        System.out.println("Closing Browser");


    }


}
