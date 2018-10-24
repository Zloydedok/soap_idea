import {client} from 'nightwatch-cucumber';
import {Given, Then, When} from 'cucumber';

Given(/^I open Google's search page$/,  () => {
 
  const google = client.page.google()
  return google
    .navigate()
    .waitForElementVisible('@body', 1000)
})

Then(/^the title is "([^"]*)"$/, (title) => {
  return client.assert.title(title);
});

Then(/^the Google search form exists$/, () => {
  const google = client.page.google()
  return google.assert.visible('@searchBar');
});

Then('I type searchrequest {string}', async text => {
  const google = client.page.google()
  google.setValue('@searchBar', text)})

Then('I click on submit button', async () => {
  const google = client.page.google()
  google.click('@searchButton')
  await google.waitForElementVisible('@body', 5000);
})
