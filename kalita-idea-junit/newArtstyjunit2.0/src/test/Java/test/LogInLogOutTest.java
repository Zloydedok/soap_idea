package test;

import data.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import screenshots_for_tests.ScreenShotRule;

public class LogInLogOutTest extends Helper {
    public LogInLogOutTest() throws Exception {
        super.setUp();
        screenShootRule = new ScreenShotRule(driver);
    }
    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);

    @Test
    public void loginCheck_logOutCheck(){
        ArtstyUserData example_user_data = new ArtstyUserData();
        artstylogin();
        artstylogout();
        Assert.assertTrue(isElementPresent(By.xpath("//a[@class='avant-garde-button-white mlh-login']")));
    }
}