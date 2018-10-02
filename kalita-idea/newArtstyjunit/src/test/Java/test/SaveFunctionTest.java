package test;

import data.ArtstyUserData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class SaveFunctionTest extends Helper {
    @Test
    public void safe_function(){
        ArtstyUserData example_user_data = new ArtstyUserData(); //sup for login
        artstylogin();
        goToMainPage();
        save_product();
        check_saved_product();
        Assert.assertTrue(isElementPresent(By.xpath("//div[@class='settings-quasi-infinite__total' and contains(text(), 'artworks')]")));
        remove_saved_product();
        Assert.assertTrue(!isElementPresent(By.xpath("//div[@class='settings-quasi-infinite__total' and contains(text(), 'artworks')]")));
    }
}
