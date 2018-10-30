import {client} from 'nightwatch-cucumber';
import {Given, When, Then} from 'cucumber';


  const artstyGalleries = client.page.artstyGalleries();
  const loginData = {
    email: 'Xenus1993@gmail.com',
    password: 'aftershock1'
  };
  Given(/^I navigate to "Galleries" section from main page$/, async () => {

    browser.element("xpath", "//a[@class='search-result artist']/div[@class='search-result-info']/div[@class='search-result-kind']", function(result){
        if (result.value && result.value.ELEMENT) {
          artstyGalleries.waitForElementVisible('@galleriesLink', 10000)
          artstyGalleries.click('@galleriesLink')
        } else {
          artstyGalleries.waitForElementVisible('@ldropDownList', 10000)
          artstyGalleries.click('@galleriesLink')
        }
    });

//    artstyGalleries.assert.elementPresent("@galleriesLink" function() {
//      if (result.value.ELEMENT) {
//          artstyGalleries.waitForElementVisible('@galleriesLink', 10000)
//          artstyGalleries.click('@galleriesLink')
//      } else {
//            artstyGalleries.waitForElementVisible('@ldropDownList', 10000)
//            artstyGalleries.click('@galleriesLink')
//      }
//  })
})
