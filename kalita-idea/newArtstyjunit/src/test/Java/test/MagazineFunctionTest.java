package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import data.*;

public class MagazineFunctionTest extends Helper {
    @Test
    public void check_magazine() {
        goToMainPage();
        open_magazine_section();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='NewsPanel__NewsPanelContainer-q0ahqj-0 knLssa']")));
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='NewsPanel__Header-q0ahqj-1 hEMgvY']/div[text()='"+DateHelper.currentMonthAndDay()+"']")));
    }
}
