package test;

import data.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LogInLogOutTest extends Helper {
    @Test
    public void loginCheck_logOutCheck(){
        ArtstyUserData example_user_data = new ArtstyUserData();
        artstylogin();
        artstylogout();
        Assert.assertTrue(isElementPresent(By.xpath("//a[@class='avant-garde-button-white mlh-login']")));
    }
}