package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ArtFairsTest extends Helper {
    @Test
    public void current_prev_fairs_check(){
        goToMainPage();
        open_fairs();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='fairs__current-fairs']/div/div/div")));//current fairs exist
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='fairs__past-fairs']/div/a")));//past fairs exist
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='fairs__upcoming-fairs']/div")));//upcoming fairs exist
    }
}
