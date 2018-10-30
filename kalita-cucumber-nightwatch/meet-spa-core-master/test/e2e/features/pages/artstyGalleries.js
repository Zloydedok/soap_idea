module.exports = {
    url: 'https://www.artsy.net/',
    elements: {
      searchField:{
        selector: "//input[@id='main-layout-search-bar-input']",
        locateStrategy: "xpath"
      },
      searchSubmitButton: {
        selector: "//form/a[@id='main-layout-search-bar-icon']",
        locateStrategy: "xpath"
      },
      firstSearchResult: {
        selector: "//a[@class='search-result artist']/div[@class='search-result-info']",
        locateStrategy: "xpath"
      },
      suggestionSearchResult: {
        selector: "//span[@class='mlsb-suggestion-value']",
        locateStrategy: "xpath"
      },
      firstSearchResultKind: {
        selector: "//a[@class='search-result artist']/div[@class='search-result-info']/div[@class='search-result-kind']",
        locateStrategy: "xpath"
      },
      firstSearchResultTitle: {
        selector: "//a[@class='search-result artist']/div[@class='search-result-info']/div[@class='search-result-title']",
        locateStrategy: "xpath"
      }
    }
 }
