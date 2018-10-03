package browser_settings;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class SetUpWebdriver {

    public static WebDriver driver=null;
    public String baseUrl=null;
    public String logoutUrl=null;
    public StringBuffer verificationErrors = new StringBuffer();
    public boolean acceptNextAlert = true;
    public static Properties CONFIG=null;
    public static Properties OR=null;
    private static ChromeDriverService service;
    protected static DesiredCapabilities dCaps;

    @Before
// ИНИЦИАЛИЗАЦИЯ ДРАЙВЕРА
    public void setUp() throws Exception {

        if (driver == null) {
            // config property file
            CONFIG = new Properties();
            FileInputStream fn = new FileInputStream(System.getProperty("user.dir") + "//src//config/config.properties");
            CONFIG.load(fn);

            // Initalize the webdriver and EventFiringWebDriver

            dCaps = new DesiredCapabilities();
            dCaps.setJavascriptEnabled(true);

            if (CONFIG.getProperty("browser").equals("FF")) {
                //            SET Profile FIREFOX AND SETUP DRIVER FF
                ProfilesIni allProfiles = new ProfilesIni();
                //FirefoxProfile profile = allProfiles.getProfile("forselenium");
                //profile.setEnableNativeEvents(true);
                //driver = new FirefoxDriver(profile);
                FirefoxProfile testprofile = allProfiles.getProfile("selenium");
                testprofile.setPreference("dom.webnotifications.enabled", false);
                testprofile.setPreference("apz.popups.enabled",false);
                DesiredCapabilities dc = DesiredCapabilities.firefox();
                dc.setCapability(FirefoxDriver.PROFILE, testprofile);
                FirefoxOptions opt = new FirefoxOptions();
                opt.merge(dc);
                if (CONFIG.getProperty("modeofbr").equals("headless")) {
                    FirefoxBinary firefoxBinary = new FirefoxBinary();
                    firefoxBinary.addCommandLineOptions("--headless");
                    opt.setBinary(firefoxBinary);
                }
                driver =  new FirefoxDriver(opt);

                // driver.register(new WebDriverLogger("#FFFF00", 3, 500, TimeUnit.MILLISECONDS));
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                baseUrl = CONFIG.getProperty("baseurl");
                System.out.println(System.getenv("browser"));
            } else if (CONFIG.getProperty("browser").equals("IE")) {
                File file = new File("C://browsers//IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

                driver = new InternetExplorerDriver();
                //driver.register(new WebDriverLogger("#FFFF00", 3, 500, TimeUnit.MILLISECONDS));
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                baseUrl = CONFIG.getProperty("baseurl");
                System.out.println(System.getenv("browser"));
            } else if (CONFIG.getProperty("browser").equals("Chrome")) {

               /*service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("C://browsers//chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                service.start();
                driver = new ChromeDriver(service);*/

                //Set Chrome Headless mode as TRUE
                ChromeOptions options = new ChromeOptions();
                options.setHeadless(true);

                //Instantiate Web Driver
                WebDriver driver = new ChromeDriver(options);

                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                baseUrl = CONFIG.getProperty("baseurl");

                System.out.println(System.getenv("browser"));


            }
        /*else if (CONFIG.getProperty("browser").equals("PJS")) {
            driver = new PhantomJSDriver(dCaps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            baseUrl = CONFIG.getProperty("baseurl");
            System.out.println(System.getenv("browser"));
        }*/


        }
    }
    public void waiter(String SomeLocatorByXpath , int time){
        WebDriverWait waitForOne = new WebDriverWait(driver, time);
        waitForOne.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SomeLocatorByXpath)));
    }
    public void waitforpagetofullload()
    {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bx-footer-bottomline']")));
    }

    protected void type(WebElement webelement, String text) {
        webelement.click();
        webelement.clear();
        webelement.sendKeys(text);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
