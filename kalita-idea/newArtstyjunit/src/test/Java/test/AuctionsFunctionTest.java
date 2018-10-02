package test;

import data.ArtstyUserData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class AuctionsFunctionTest extends Helper {
    @Test
    public void auction_check_function() {
        artstylogin();
        goToMainPage();
        go_to_auctions();
        Assert.assertTrue(isElementPresent(By.xpath("//button[@class='avant-garde-button-black is-block js-register-button']")));
    }
}
