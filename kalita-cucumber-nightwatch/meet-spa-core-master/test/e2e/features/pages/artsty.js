module.exports = {
    url: 'https://www.artsy.net/',
    elements: {
    body: {
      selector: 'body',
      locateStrategy: 'css selector'
    },
    openLogInFormButton: {
      selector: "//a[@class='avant-garde-button-white mlh-login']",
      locateStrategy: 'xpath'
    },
    logInForm: {
      selector: "//div[@class='Modal__ModalContent-ae7lk6-0 TufQz']",
      locateStrategy: 'xpath'
    },
    logInEmailField: {
      selector: "//input[@name='email']",
      locateStrategy: 'xpath'
    },
    logInPasswordField: {
      selector: "//input[@name='password']",
      locateStrategy: 'xpath'
    },
    submitLogInButton: {
      selector: "//div[contains(text(), 'Log in')]",
      locateStrategy: 'xpath'
    },
    goToProfileFromMainPage: {
      selector: "//span[@class='mlh-user-name hover-pulldown']/a",
      locateStrategy: 'xpath'
    },
    firstNameInSettings: {
      selector: "//h1[@class='settings-page__header__name']",
      locateStrategy: 'xpath'
    },
    goToProfileSettings: {
      selector: "//a[@class='settings-tabs__tab js-avant-garde-tablist__tab' and text()='Settings']",
      locateStrategy: 'xpath'
    },
    profileSettingsFullNameField: {
      selector: "//input[@id='name']",
      locateStrategy: 'xpath'
    },
    profileSettingsEmailField: {
      selector: "//input[@id='email']",
      locateStrategy: 'xpath'
    },
    informationSettingsChangesButton: {
      selector: "//div[@id='information']/descendant::button[text()='Save Changes']",
      locateStrategy: 'xpath'
    }
  }
}
