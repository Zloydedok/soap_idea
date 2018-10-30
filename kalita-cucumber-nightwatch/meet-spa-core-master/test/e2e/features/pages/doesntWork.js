module.exports = {
    url: 'https://www.artsy.net/',
    elements: {
        goToAtrworks: {
        selector: "//nav[@class='mlh-navbar']/descendant::a[@href='/collect']",
        locateStrategy: 'xpath'
    },
      titleAtTheArtworks:{
        selector:"//div[text()='Collect art and design online']",
        locateStrategy: 'xpath'
    },
      searchBar:{
        selector:"//input[@id='main-layout-search-bar-input']",
        locateStrategy:'xpath'
    },
      searchList:{
        selector:"//span[@class='mlsb-suggestion-value']",
        locateStrategy:'xpath'
    },
      searchButton:{
        selector:"//a[@id='main-layout-search-bar-icon']",
        locateStrategy:'xpath'
    },
      resultOfSearch:{
        selector:"//div[contains(text(),'Claude Monet - View & Collect Works')]",
        locateStrategy:'xpath'
    },
      wayToBuyInquire:{
        selector:"//div[contains(text(),'Inquire')]",
        locateStrategy:'xpath'
    },
      plate:{
        selector:"//div[@class='sc-htpNat KtFsv sc-bwzfXH jVtwLE']",
        locateStrategy:'xpath'
    },
      example:{
        selector:"//a[contains(text(),'Education')]",
        locateStrategy:'xpath'
    },
      galleryMKFineArt:{
        selector:"//div[text()='Inquire']",
        locateStrategy:'xpath'
    },
      trueGalleryMaryFault:{
        selector: "//div[@class='sc-htpNat KtFsv sc-bwzfXH epVxoy' and text()='Gallery']/..",
        locateStrategy: 'xpath'
    },
      radioButtonMKFineArt: {
        selector: "//label[text()='MK Fine Art']",
        locateStrategy: 'xpath'
     },
      radioButtonMKFineArtAssert: {
        selector: "//div[@class='sc-kpOJdX krrnCB sc-bdVaJa fgmukL']/input",
        locateStrategyL: 'xpath'
      },
      artResult: {
        selector: "//a[@class='TextLink__StyledTextLink-pwn95u-0 duQJPz']/div/div/div/em",
        locateStrategy: 'xpath'
      },
      nameOfPaint:{
        selector:"//em",
        locateStrategy: 'xpath'
       }
    }
}
