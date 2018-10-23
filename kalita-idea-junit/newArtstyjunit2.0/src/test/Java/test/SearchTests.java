package test;
import org.junit.Rule;
import org.junit.Test;
import data.*;
import org.openqa.selenium.support.PageFactory;
import screenshots_for_tests.*;
import browser_settings.*;

public class SearchTests extends Helper {
    public SearchTests() throws Exception {
        super.setUp();
        screenShootRule = new ScreenShotRule(driver);
    }
    @Rule
    public ScreenShotRule screenShootRule = new ScreenShotRule(driver);


    @Test
    public void searchArtist() {
        goToMainPage();
        inputInSearchField(SearchArtistsData.chosenArtistSlug);
        checkSearchObjectStatus(SearchArtistsData.expArtistStatus);
    }
    @Test
    public void searchArtwork() {
        goToMainPage();
        inputInSearchField(SearchArtworkData.chosenArtworkSlug);
        checkSearchObjectStatus(SearchArtistsData.expArtistStatus);
    }
    @Test
    public void searchShow() {
        goToMainPage();
        inputInSearchField(SearchShowData.chosenShowSlug);
        checkSearchObjectStatus(SearchShowData.expShowStatus);
    }
}

