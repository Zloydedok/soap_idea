package test;

import data.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.By;
import screenshots_for_tests.ScreenShotRule;

public class BrowseWorksForSaleTest extends Helper {
    public BrowseWorksForSaleTest() throws Exception {
        super.setUp();
        screenShootRule = new ScreenShotRule(driver);
    }
    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);

    @Test
    public void select_all_works_for_sale(){
        goToMainPage();
        getAllArtsForSale();
        Assert.assertTrue(!isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display'")));
    }

    @Test
    public void select_a_specific_selling_category() {
        goToMainPage();
        chooseSellCategory(ArtstyDataForSale.Painting_Category);
        Assert.assertTrue(isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display' and text() =" + ArtstyDataForSale.Painting_Category + "]")));

        goToMainPage();
        chooseSellCategory(ArtstyDataForSale.Photography_Category);
        Assert.assertTrue(isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display' and text() =" + ArtstyDataForSale.Photography_Category + "]")));

        goToMainPage();
        chooseSellCategory(ArtstyDataForSale.Sculpture_Category);
        Assert.assertTrue(isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display' and text() =" + ArtstyDataForSale.Sculpture_Category + "]")));

        goToMainPage();
        chooseSellCategory(ArtstyDataForSale.Prints_and_Multiples_Category);
        Assert.assertTrue(isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display' and text() =" + ArtstyDataForSale.Prints_and_Multiples_Category + "]")));

        goToMainPage();
        chooseSellCategory(ArtstyDataForSale.Works_on_Paper_Category);
        Assert.assertTrue(isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display' and text() =" + ArtstyDataForSale.Works_on_Paper_Category + "]")));

        goToMainPage();
        chooseSellCategory(ArtstyDataForSale.Film_and_Video_Category);
        Assert.assertTrue(isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display' and text() =" + ArtstyDataForSale.Film_and_Video_Category + "]")));

        goToMainPage();
        chooseSellCategory(ArtstyDataForSale.Design_Category);
        Assert.assertTrue(isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display' and text() =" + ArtstyDataForSale.Design_Category + "]")));

    }
    @Test
    public void check_range_function(){
        goToMainPage();
        go_to_artworks_for_sale();
        clickAndMoveSlider();
    }
}
