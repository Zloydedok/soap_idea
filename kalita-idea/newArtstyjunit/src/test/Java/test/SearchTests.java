package test;
import org.junit.Test;
import data.*;

public class SearchTests extends Helper {

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
