package test;

import data.DateHelper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import screenshots_for_tests.ScreenShotRule;

public class ArtsitsProfilesTest extends Helper {
    public ArtsitsProfilesTest() throws Exception {
        super.setUp();
        screenShootRule = new ScreenShotRule(driver);
    }
    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);

    @Test
    public void check_artist_profile() {
        goToMainPage();
        open_all_profiles();
        choose_artists_filter("a");
        chose_first_artist_in_list();
        Assert.assertTrue(isElementPresent(By.xpath("//button/div[text()='Follow']")));
    }
}
