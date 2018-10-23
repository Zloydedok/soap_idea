package test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import screenshots_for_tests.ScreenShotRule;

public class ArtFairsTest extends Helper {
    public ArtFairsTest() throws Exception {
        super.setUp();
        screenShootRule = new ScreenShotRule(driver);
    }
    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);

    @Test
    public void current_prev_fairs_check(){
        goToMainPage();
        open_fairs();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='fairs__current-fairs']/div/div/div")));//current fairs exist
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='fairs__past-fairs']/div/a")));//past fairs exist
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='fairs__upcoming-fairs']/div")));//upcoming fairs exist
    }
}
