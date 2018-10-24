import {client} from 'nightwatch-cucumber';
import {Given, When, Then} from 'cucumber';


  const artsty = client.page.artsty();
  const loginData = {
    email: 'Xenus1993@gmail.com',
    password: 'aftershock1'
  };

Given('I go to main Artsty page', async () => {
    await artsty.navigate();
    await artsty.waitForElementVisible('@body', 10000);
})

When('I click login button', async () => {
  await artsty.click('@openLogInFormButton');
  await artsty.waitForElementVisible('@logInForm', 10000);
});

Then('Filled out the form with valid data',  async ()=> {
  await artsty.waitForElementVisible('@logInEmailField', 20000);
  await artsty.setValue('@logInEmailField', loginData.email);
  await artsty.setValue('@logInPasswordField', loginData.password);
  })

Then(/^Press the 'Log in' button$/, () => {
  artsty.click('@submitLogInButton');
})

Then('I successfully logged in', async () => {
  await artsty.waitForElementVisible('@goToProfileFromMainPage', 10000);
  await artsty.click('@goToProfileFromMainPage');
  await artsty.waitForElementVisible('@firstNameInSettings', 10000);
})

Given('I go to main Artsty page and login as {string}', async userFirstName  => {
  await artsty.navigate();
  await artsty.click('@openLogInFormButton');
  await artsty.waitForElementVisible('@body', 10000);
  await artsty.waitForElementVisible('@logInEmailField', 20000);
  await artsty.setValue('@logInEmailField', loginData.email);
  await artsty.setValue('@logInPasswordField', loginData.password);
  await artsty.click('@submitLogInButton');
  await artsty.waitForElementVisible('@goToProfileFromMainPage', 10000);
  await artsty.click('@goToProfileFromMainPage');
  await artsty.waitForElementVisible('@firstNameInSettings', 10000);
  await artsty.assert.containsText('@firstNameInSettings', userFirstName);
})
Given('I go to profile settings page and change my full name to {string}', async userNewFirstName => {
  await artsty.click('@goToProfileSettings');
  await artsty.waitForElementVisible('@profileSettingsFullNameField', 5000);
  await artsty.click('@profileSettingsFullNameField');
  await artsty.clearValue('@profileSettingsFullNameField');
  await artsty.click('@profileSettingsFullNameField');
  await artsty.setValue('@profileSettingsFullNameField', userNewFirstName);
  await artsty.click('@informationSettingsChangesButton');
  await artsty.api.refresh();
})
When ('My profile name is {string}', async userNewFirstName => {
  await artsty.api.refresh();
  await artsty.waitForElementVisible('@firstNameInSettings', 10000);
  await artsty.assert.containsText('@firstNameInSettings', userNewFirstName);
})
Then ('I change my name to {string}', async userFirstName => {
  await artsty.click('@profileSettingsFullNameField');
  await artsty.clearValue('@profileSettingsFullNameField');
  await artsty.setValue('@profileSettingsFullNameField', userFirstName);
  await artsty.click('@informationSettingsChangesButton');
  await artsty.api.refresh();
  await artsty.waitForElementVisible('@firstNameInSettings', 10000);
})
Then ('Then My profile name is {string}', async userFirstName => {
  await artsty.waitForElementVisible('@firstNameInSettings', 10000);
  await artsty.assert.containsText('@firstNameInSettings', userFirstName)
})
