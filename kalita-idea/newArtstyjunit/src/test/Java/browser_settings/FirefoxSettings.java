package browser_settings;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class FirefoxSettings {

    String driverPath = "drivers/";
    public WebDriver driver;
    @Before
    public void launchBrowser() {
        System.out.println("launching firefox browser");
        System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
        driver = new FirefoxDriver();
    }


    @After
    public void closeDriver() {
        if(driver!=null) {
            driver.quit();
        }
    }
    public void waiterUntilInvis(String SomeLocatorByXpath, int time){
        WebDriverWait waitForOne = new WebDriverWait(driver, time);
        waitForOne.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(SomeLocatorByXpath)));
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
