package test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import data.*;
import screenshots_for_tests.ScreenShotRule;

public class MagazineFunctionTest extends Helper {
    public MagazineFunctionTest() throws Exception {
        super.setUp();
        screenShootRule = new ScreenShotRule(driver);
    }
    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);

    @Test
    public void check_magazine() {
        goToMainPage();
        open_magazine_section();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='NewsPanel__NewsPanelContainer-q0ahqj-0 knLssa']")));
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='NewsPanel__Header-q0ahqj-1 hEMgvY']/div[text()='"+DateHelper.currentMonthAndDay()+"']")));
    }
}
