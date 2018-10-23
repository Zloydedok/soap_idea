package screenshots_for_tests;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;


public class ScreenShotRule extends TestWatcher {

    private final WebDriver browser;


    public ScreenShotRule(WebDriver browser) {
        this.browser =  browser;
        System.out.println("Create browser in TestWatcher");
    }

    @Override
    protected void succeeded(Description description) {
        Helper helper=new Helper();
        helper.takeScreenshot(browser,"SUCCEEDED");
    }
    @Override
    protected void failed(Throwable e, Description description) {
        Helper helper=new Helper();
        helper.takeScreenshot(browser,"FAILED");
    }

    @Override
    protected void finished(Description description) {
        if (browser!=null)
            browser.quit();
    }

}