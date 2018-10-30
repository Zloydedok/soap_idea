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
      galleriesLink: {
        selector: "//a[@class='mlh-top-nav-link galleries is-inactive']",
        locateStrategy: "xpath"
      },
      dropDownList: {
        selector: "//span[@class='mlh-top-nav-link hover-pulldown']",
        locateStrategy: "xpath"
      }
    }
 }
