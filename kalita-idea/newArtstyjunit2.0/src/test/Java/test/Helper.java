package test;
import browser_settings.SetUpWebdriver;
import data.ArtstyUserData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Helper extends SetUpWebdriver {
    public void goToMainPage(){
        driver.get("https://www.artsy.net/");
    }

    public void artstylogin() {
        driver.get("https://www.artsy.net/");
        driver.findElement(By.xpath("//a[@class='avant-garde-button-white mlh-login']")).click();
        waiter("//input[@name='email']", 8);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ArtstyUserData.artLogin);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(ArtstyUserData.artPass);
        driver.findElement(By.xpath("//div[contains(text(), 'Log in')]")).click();
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.findElement(By.xpath("//div[@class='main-layout-header-user']")).click();
        waiter("//h1[@class='settings-page__header__name']", 20);
        String actName = driver.findElement(By.xpath("//h1[@class='settings-page__header__name']")).getText();
        String expName = ArtstyUserData.expUserName;
        Assert.assertEquals(actName, expName);
    }
    public void artstylogout() {
        driver.get("https://www.artsy.net/");
        Actions actions = new Actions(driver);
        waiter("//span[@class='mlh-user-name hover-pulldown']", 10);
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='mlh-user-name hover-pulldown']"))).build().perform();
        waiter("//a[@class='mlh-logout']", 10);
        driver.findElement(By.xpath("//a[@class='mlh-logout']")).click();
        waiter("//a[@class='avant-garde-button-white mlh-login']", 10);
        //Assert.assertTrue(isElementPresent(By.xpath("//a[@class='avant-garde-button-white mlh-login']")));
    }
    public void inputInSearchField(String enterTheSearchRequest) {
        driver.get("https://www.artsy.net/");
        waiter("//input[@id='main-layout-search-bar-input']", 5);
        driver.findElement(By.xpath("//input[@id='main-layout-search-bar-input']")).sendKeys(enterTheSearchRequest);
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.findElement(By.xpath("//a[@id='main-layout-search-bar-icon']")).click();
    }
    public void checkSearchObjectStatus(String expStatus) {
        waiter("//a[@class='search-result artist'][1]/div/div[contains(text(),"+expStatus+")]", 20);
        Assert.assertTrue(isElementPresent(By.xpath("//a[@class='search-result artist'][1]/div/div[contains(text(),"+expStatus+")]")));
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }
    public void getAllArtsForSale() {
        driver.get("https://www.artsy.net/");
        driver.findElement(By.xpath("//div[@class='home-browse-all-right']/a[contains(text(),'View All')]")).click();
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }

    public void chooseSellCategory(String selectedCategory) {
        driver.findElement(By.xpath("//a[@class='home-browse-module__menu__option grid-item' and text()="+selectedCategory+"]")).click();
        waiter("//span[@class='cf-pillbox__pillboxes_display' and text() ="+selectedCategory+"]", 10);
    }
//    public void assertSellCategory(String selectedCategory) {
//        Assert.assertTrue(isElementPresent(By.xpath("//span[@class='cf-pillbox__pillboxes_display' and text() =" + selectedCategory + "]")));
//    }
    public void save_product() {
        waiter("//a[@class='mlh-top-nav-link is-inactive' and text()='Artworks']", 10);
        driver.findElement(By.xpath("//a[@class='mlh-top-nav-link is-inactive' and text()='Artworks']")).click();
        waiter("//div[@class='artwork-column'][1]/figure[@class='artwork-item'][1]", 10);
        driver.findElement(By.xpath("//div[@class='artwork-column'][1]/figure[@class='artwork-item'][1]")).click();
        waiter("//i[@class='icon-heart']", 5);
        driver.findElement(By.xpath("//i[@class='icon-heart']")).click();
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }
    public void check_saved_product() {
        Actions actions = new Actions(driver);
        waiter("//span[@class='mlh-user-name hover-pulldown']", 10);
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='mlh-user-name hover-pulldown']"))).build().perform();
        waiter("//div[@class='hover-pulldown-menu']/a[text()='Saves & Follows']", 10);
        driver.findElement(By.xpath("//div[@class='hover-pulldown-menu']/a[text()='Saves & Follows']")).click();
        waiter("//div[@class='settings-quasi-infinite__total' and contains(text(), 'artworks')]", 10);
    }
    public void remove_saved_product(){
        driver.findElement(By.xpath("//div[@id='saved-artworks']//div[@class='overlay-button-save']")).click();
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
        driver.navigate().refresh();
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }
    public void find_gallery_and_follow(){
        waiter("//a[@class='mlh-top-nav-link galleries is-inactive']", 10);
        driver.findElement(By.xpath("//a[@class='mlh-top-nav-link galleries is-inactive']")).click();
        waiter("//a[@href='/galleries-a-z']", 15);
        driver.findElement(By.xpath("//a[@href='/galleries-a-z']")).click();
        waiter("//div[@class='a-to-z-row'][1]/ul[1]/li[1]/a",15);
        driver.findElement(By.xpath("//div[@class='a-to-z-row'][1]/ul[1]/li[1]/a")).click();
        waiter("//button[@class='avant-garde-follow-button-black follow-button is-small no-touch']",10);
        driver.findElement(By.xpath("//button[@class='avant-garde-follow-button-black follow-button is-small no-touch']")).click();
    }
    public void check_followed_gallery(){
        Actions actions = new Actions(driver);
        waiter("//span[@class='mlh-user-name hover-pulldown']", 10);
        actions.moveToElement(driver.findElement(By.xpath("//span[@class='mlh-user-name hover-pulldown']"))).build().perform();
        waiter("//div[@class='hover-pulldown-menu']/a[text()='Saves & Follows']", 10);
        driver.findElement(By.xpath("//div[@class='hover-pulldown-menu']/a[text()='Saves & Follows']")).click();
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }
    public void unfollow_followed_gallery(){
        driver.get("https://www.artsy.net/user/saves");
        waiter("//div[@class='settings-galleries-institutions__profile']//a[@data-state='following']", 10);
        driver.findElement(By.xpath("//div[@class='settings-galleries-institutions__profile']//a[@data-state='following']")).click();
        driver.navigate().refresh();
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }
    public void go_to_auctions(){
        driver.findElement(By.xpath("//a[@class='mlh-top-nav-link is-inactive' and text()='Auctions']")).click();
        waiter("//a[@class='af-go-button avant-garde-button-black']",10);
        driver.findElement(By.xpath("//a[@class='af-go-button avant-garde-button-black']")).click();
        try
        {
            Thread.sleep(5000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }
//    waiter("//div[@id='saved-artworks']//div[@class='overlay-button-save']", 5);
//    driver.findElement(By.xpath("//div[@id='saved-artworks']//div[@class='overlay-button-save']")).click();
    public void open_fairs(){
        if (driver.findElement(By.xpath("//a[@class='mlh-top-nav-link fairs is-inactive' and text()='Fairs']"))!=null)
        {
            driver.findElement(By.xpath("//a[@class='mlh-top-nav-link fairs is-inactive' and text()='Fairs']")).click();
            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException e)
            {
                // this part is executed when an exception occurs
            }
        }
        else
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.xpath("//nav[@class='mlh-navbar']/div[@id='main-layout-header-center']/span[@class='mlh-top-nav-link hover-pulldown']"))).build().perform();
            waiter("//a[@class='mlh-pulldown-top-link fairs is-inactive']",10);
            driver.findElement(By.xpath("//a[@class='mlh-pulldown-top-link fairs is-inactive']")).click();
            try
            {
                Thread.sleep(3000);
            }
            catch(InterruptedException e)
            {
                // this part is executed when an exception occurs
            }
        }
    }
    public void open_all_profiles() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//nav[@class='mlh-navbar']/div[@id='main-layout-header-center']/span[@class='mlh-top-nav-link hover-pulldown']"))).build().perform();
        waiter("//a[@class='mlh-pulldown-top-link-persistent is-inactive' and text()='Artists']",10);
        driver.findElement(By.xpath("//a[@class='mlh-pulldown-top-link-persistent is-inactive' and text()='Artists']")).click();
    }
    public void choose_artists_filter(String letter) {
        waiter("//div[@class='alphabetical-index-range']/a[text()='"+letter+"']",5);
        driver.findElement(By.xpath("//div[@class='alphabetical-index-range']/a[text()='"+letter+"']")).click();
    }
    public void chose_first_artist_in_list(){
        waiter("//a[@class='highlight-link'][1]",10);
        driver.findElement(By.xpath("//a[@class='highlight-link'][1]")).click();
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }
    public void open_magazine_section(){
        driver.findElement(By.xpath("//a[@class='mlh-top-nav-link magazine is-inactive']")).click();
    }
    public void go_to_artworks_for_sale(){
        driver.findElement(By.xpath("//a[@class='mlh-top-nav-link is-inactive' and text()='Artworks']")).click();
    }
    public void clickAndMoveSlider() {
        waiter("//div[@class='cf-sidebar']/div[@class='cf-sidebar__filter cf-sidebar__size']/div[@class='cf-sidebar__size__width']//div[@class='noUi-handle noUi-handle-lower']",10);
        Actions acts = new Actions(driver);
        acts.dragAndDrop(driver.findElement(By.xpath("//div[@class='cf-sidebar']/div[@class='cf-sidebar__filter cf-sidebar__size']/div[@class='cf-sidebar__size__width']//div[@class='noUi-handle noUi-handle-lower']")), driver.findElement(By.xpath("//*[@id=\"main-layout-container\"]/div/div[2]/div[4]/div[1]/div/div/div[2]/div/div[3]/div")));
        //        acts.dragAndDropBy(driver.findElement(By.xpath("//div[@class='cf-sidebar']/div[@class='cf-sidebar__filter cf-sidebar__size']/div[@class='cf-sidebar__size__width']//div[@class='noUi-handle noUi-handle-lower']")), move_x, 0);
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException e)
        {
            // this part is executed when an exception occurs
        }
    }

}