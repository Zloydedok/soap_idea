import {client} from 'nightwatch-cucumber';
import {Given, When, Then} from 'cucumber';


 const doesntWork = client.page.doesntWork();

 Given('I go to Artworks', async () => {
     await doesntWork.click('@goToAtrworks');
     await doesntWork.waitForElementVisible('@titleAtTheArtworks',10000);
 })

 When('I search {string}', async (searchText) =>{
     await doesntWork.waitForElementVisible('@searchBar',10000);
     await doesntWork.getLocationInView('@example');
     await doesntWork.click('@searchBar');
     await doesntWork.clearValue('@searchBar');
     await doesntWork.setValue('@searchBar', searchText);
     await doesntWork.waitForElementPresent('@searchList',10000);
     await doesntWork.click('@searchList');
     await doesntWork.waitForElementPresent('@resultOfSearch', 10000);
  })
 Then('Check gallery {string}', async (Gallery) =>{
    await doesntWork.click('@resultOfSearch');
    var caseGallery = 'gallery'+Gallery.replace(/\s/g,'');
    await doesntWork.api.refresh();
    await doesntWork.waitForElementPresent('@plate',10000);
    await doesntWork.waitForElementPresent('@wayToBuyInquire',10000);
    await doesntWork.waitForElementPresent(`@${caseGallery}`,10000);
    await doesntWork.getLocationInView(`@${caseGallery}`);
    await doesntWork.click(`@${caseGallery}`);
 })
  Then('I see the picture {string}', async expectedPictureName => {
    await doesntWork.getLocationInView('@trueGalleryMaryFault');
    await doesntWork.api.pause(5000);
    await doesntWork.click('@trueGalleryMaryFault');
    await doesntWork.api.pause(5000);
    await doesntWork.click('@radioButtonMKFineArt');
    await doesntWork.api.pause(5000);
//    var elNameOfPaint = doesntWork.elements.nameOfPaint.selector+'[contains(text(),\'' + expectedPictureName + '\')]';
//    await doesntWork.waitForElementPresent("elNameOfPaint",10000);
//    await doesntWork.waitForElementPresent("@artResult"+"[contains(text(),'waitForElementPresent')]", 10000)
    await doesntWork.assert.containsText('@artResult', expectedPictureName)
  });

//Then('I see the {string}', async (nameOfPaint) =>{
//   await doesntWork.api.pause(3000);
//   var elNameOfPaint = doesntWork.elements.nameOfPaint.selector+"[contains(text(),\'' + nameOfPaint + '\')]";
//   await doesntWork.waitForElementPresent(elNameOfPaint,10000);
//   await artsty.waitForElementPresent('@nameOfPaint',10000);
//  <//em[contains(text(),'Le repos dans le jardin, Argenteuil')]>

//})
