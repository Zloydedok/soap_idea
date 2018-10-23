module.exports = {
  url: 'https://www.yandex.ru/',
  elements: {
    body: {
    selector: 'body',
    locateStrategy: 'css selector'
    },
    searchBar: {
      selector: "//input[@class=\"input__control input__input\"]",
      locateStrategy: 'xpath'
    },
    searchButton: {
      selector: "//button[@class=\"button suggest2-form__button button_theme_websearch button_size_ws-head i-bem button_js_inited\"]",
      locateStrategy: 'xpath'
    },
    wikiResult: {
      selector: "//div[@class='organic__url-text' and contains(text(), 'Wikipedia')]",
      locateStrategy: 'xpath'
    }
  }
 }

