import {client} from 'nightwatch-cucumber';
import {Given, Then, When} from 'cucumber';

 const yandSP = client.page.yandSP();

Given(/^I go to Yandex's search page$/, () => {
  const yandSP = client.page.yandSP()
  return yandSP
    .navigate()
    .waitForElementVisible('@body', 1000)
})

When('I write in searchField {string} and press submit button', async text => {
 await yandSP.setValue('@searchBar', text + client.Keys.ENTER)
})

Then('I get Wiki in search results',  async () => {
  await yandSP.assert.elementPresent('@wikiResult')
})
