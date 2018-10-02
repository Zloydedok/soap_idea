package test;

import data.DateHelper;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ArtsitsProfilesTest extends Helper {
    @Test
    public void check_artist_profile() {
        goToMainPage();
        open_all_profiles();
        choose_artists_filter("a");
        chose_first_artist_in_list();
        Assert.assertTrue(isElementPresent(By.xpath("//button/div[text()='Follow']")));
    }
}
