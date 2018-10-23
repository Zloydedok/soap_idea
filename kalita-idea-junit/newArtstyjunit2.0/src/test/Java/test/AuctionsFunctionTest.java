package test;

import data.ArtstyUserData;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import screenshots_for_tests.ScreenShotRule;

public class AuctionsFunctionTest extends Helper {
    public AuctionsFunctionTest() throws Exception {
        super.setUp();
        screenShootRule = new ScreenShotRule(driver);
    }
    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);

    @Test
    public void auction_check_function() {
        artstylogin();
        goToMainPage();
        go_to_auctions();
        Assert.assertTrue(isElementPresent(By.xpath("//button[@class='avant-garde-button-black is-block js-register-button']")));
    }
}
