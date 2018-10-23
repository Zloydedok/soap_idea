package test;

import data.ArtstyUserData;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import screenshots_for_tests.ScreenShotRule;

public class FollowGalleriesFunctionTest extends Helper {
    public FollowGalleriesFunctionTest() throws Exception {
        super.setUp();
        screenShootRule = new ScreenShotRule(driver);
    }
    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);

    @Test
    public void follow_galleries_test() {

        artstylogin();

        goToMainPage();

        find_gallery_and_follow();

        check_followed_gallery();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='settings-quasi-infinite__total' and contains(text(),'profiles')]")));

        unfollow_followed_gallery();
        Assert.assertTrue(!isElementPresent(By.xpath("//div[@class='settings-galleries-institutions__profile']//a[@data-state='following']")));
    }

}
