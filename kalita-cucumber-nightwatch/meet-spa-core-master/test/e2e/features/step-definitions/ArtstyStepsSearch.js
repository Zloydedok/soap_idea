import {client} from 'nightwatch-cucumber';
import {Given, When, Then} from 'cucumber';


  const artstySearch = client.page.artstySearch();
  const loginData = {
    email: 'Xenus1993@gmail.com',
    password: 'aftershock1'
  };
  Given("I fill the search field with {string} name", async artistName => {
    await artstySearch.navigate();
    await artstySearch.waitForElementVisible('@searchField', 10000);
    await artstySearch.setValue('@searchField', artistName);
    await artstySearch.waitForElementVisible('@suggestionSearchResult', 10000);
  })
  When("I click the search button", async () => {
    await artstySearch.click('@searchSubmitButton');
  })
  Then("I should see {string} in top of search results", async expArtistName => {
    await artstySearch.waitForElementVisible('@firstSearchResult', 10000);
    await artstySearch.assert.containsText('@firstSearchResultTitle', expArtistName)
  })
  Then("The search result must belong to a group of {string}", expSearchResultKind => {
    artstySearch.assert.containsText('@firstSearchResultKind', expSearchResultKind)
  })
