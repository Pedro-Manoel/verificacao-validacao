const { Builder, By, until, Key } = require('selenium-webdriver');
const assert = require('assert');

describe('association types', () => {
  let driver;

  before(async () => {
    driver = await new Builder().forBrowser('chrome').build();
  });

  after(async () => {
    await driver.quit();
  });

  beforeEach(async () => {
    driver.manage().deleteAllCookies();
    await driver.get('http://localhost:3333/admin');
    // await driver.get('http://150.165.75.99:8080/admin');
    await driver.findElement(By.id('_username')).sendKeys('sylius');
    await driver.findElement(By.id('_password')).sendKeys('sylius');
    await driver.findElement(By.css('.primary')).click();
    // await driver.sleep(1000);
  });

  // Remove .only and implement others test cases!
  it('change the name of an association type', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Type in value input to search for specify association type
    await driver.findElement(By.id('criteria_name_value')).sendKeys('Similar');

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Click in edit of the remain association type
    const buttons = await driver.findElements(By.css('*[class^="ui labeled icon button "]'));
    await buttons[1].click();

    // Edit association type name
    const inputName = await driver.findElement(By.id('sylius_product_association_type_translations_en_US_name'));
    inputName.click();
    inputName.clear();
    inputName.sendKeys('Real similar products');

    // Click on Save changes button
    await driver.findElement(By.id('sylius_save_changes_button')).click();

    // Assert that association type name has been updated
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Product association type has been successfully updated.'));
  });

  it('create a new association type', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Click in create button
    await driver.findElement(By.css('*[class^="ui labeled icon button "]')).click();
    
    // Defines the code of the association type
    await driver.findElement(By.id('sylius_product_association_type_code')).sendKeys('low-cost');
    
    // Defines the name of the association type in english
    await driver.findElement(By.id('sylius_product_association_type_translations_en_US_name')).sendKeys('Low Cost');

    // Click on the portuguese language dropdown
    await driver.findElement(By.css('div[data-locale="pt_PT"] .title')).click();

    // Defines the name of the association type in portuguese
    const inputName = await driver.findElement(By.id('sylius_product_association_type_translations_pt_PT_name'));
    inputName.click();
    inputName.clear();
    inputName.sendKeys('Baixo Custo');

    // Click in create button
    await driver.findElement(By.css('*[class^="ui labeled icon primary button"]')).click();

    // Assert that association type has been created
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Product association type has been successfully created.'));
  });

  it('create a new association type that already exists', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();
    
    // Click in create button
    await driver.findElement(By.css('*[class^="ui labeled icon button "]')).click();
    
    // Defines the code of the association type
    await driver.findElement(By.id('sylius_product_association_type_code')).sendKeys('similar_products');
    
    // Defines the name of the association type in english
    await driver.findElement(By.id('sylius_product_association_type_translations_en_US_name')).sendKeys('Real similar products');

    // Click on the german language dropdown
    await driver.findElement(By.css('div[data-locale="de_DE"] .title')).click();

    // Defines the name of the association type in german
    await driver.findElement(By.id('sylius_product_association_type_translations_de_DE_name')).sendKeys('echte ähnliche Produkte');      
    // // Click in create button
    await driver.findElement(By.css('*[class^="ui labeled icon primary button"]')).click();

    // Asserting that the association type was not created
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('The association type with given code already exists.'));
  });

  it('delete association type by action button in table', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Defines code to search for a specific association type
    await driver.findElement(By.id('criteria_code_value')).sendKeys('low-cost');

    // Defines name to search for a specific association type
    await driver.findElement(By.id('criteria_name_value')).sendKeys('Low Cost');

    // Click in filter button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Wait for the table to load
    await driver.wait(until.elementLocated(By.css('.item')));
    
    // Click in delete button on the table
    const buttons = await driver.findElements(By.css('*[class^="ui red labeled icon button"]'));
    await buttons[1].click();
  
    // Click in confirmation button
    await driver.findElement(By.id('confirmation-button')).click();

    // Assert that association type has been deleted
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Product association type has been successfully deleted.'));
  });

  it('delete association type by button outside table', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Click in create button
    await driver.findElement(By.css('*[class^="ui labeled icon button "]')).click();
     
    // Defines the code of the association type
    await driver.findElement(By.id('sylius_product_association_type_code')).sendKeys('low-cost');
     
    // Defines the name of the association type in english
    await driver.findElement(By.id('sylius_product_association_type_translations_en_US_name')).sendKeys('Low Cost');
  
    // Click in create button
    await driver.findElement(By.css('*[class^="ui labeled icon primary button"]')).click();

    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Defines code to search for a specific association type
    await driver.findElement(By.id('criteria_code_value')).sendKeys('low-cost');

    // Defines name to search for a specific association type
    await driver.findElement(By.id('criteria_name_value')).sendKeys('Low Cost', Key.ENTER);
    
    // Click on select all items in the table
    await driver.findElement(By.css('th.center.aligned input[type="checkbox"]')).click();

    // Click in delete button outside the table
    await driver.findElement(By.css('*[class^="ui red labeled icon button"]')).click();

    // Click in confirmation button
    await driver.findElement(By.id('confirmation-button')).click();

    // Assert that association type has been deleted
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Product_association_types have been successfully deleted.'));
  });

  it('checks filter "Not contains"', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Define filter type
    await driver.findElement(By.css('select#criteria_name_type')).sendKeys('Not contains');

    // Type in value input to search for specify association type
    await driver.findElement(By.css('[id="criteria_name_value"]')).sendKeys('similar');

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Asserting that the search did not return any results
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(!bodyText.includes('Real similar products'));
  })

  it('checks filter "Starts with"', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Define filter type
    await driver.findElement(By.css('select#criteria_name_type')).sendKeys('Starts with');

    // Type in value input to search for specify association type
    await driver.findElement(By.css('[id="criteria_name_value"]')).sendKeys('Real');

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Asserting that the search returned the expected result
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Real similar products'));

    // Asserting that there is only the searched item in the table
    const tableRows = await driver.findElements(By.css('table.ui.table tbody tr.item'));
    assert.strictEqual(tableRows.length, 1);
  })

  it('filter with empty result', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Type in value input to search for specify association type
    await driver.findElement(By.id('criteria_code_value')).sendKeys('melao');

    // Type in value input to search for specify association type
    await driver.findElement(By.id('criteria_name_value')).sendKeys('Melão');

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Asserting that the search did not return any results
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('There are no results to display'));
  });

  it('clear filters to return normal result', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Type in value input to search for specify association type
    await driver.findElement(By.id('criteria_code_value')).sendKeys('melao');

    // Type in value input to search for specify association type
    await driver.findElement(By.id('criteria_name_value')).sendKeys('Melão');

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Click in clear filter button
    const buttons = await driver.findElements(By.css('*[class^="ui labeled icon button"]'));
    await buttons[1].click();

    // Assert that the results have returned to the normal state
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Real similar products'));
  });

  it('add Spanish (Spain) name for an association type', async () => {
    // Click in association types in side menu
    await driver.findElement(By.linkText('Association types')).click();

    // Type in value input to search for specify association type
    await driver.findElement(By.id('criteria_name_value')).sendKeys('similar');

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();

    // Click in edit of the remain association type
    const buttons = await driver.findElements(By.css('*[class^="ui labeled icon button "]'));
    await buttons[1].click();

    // Click in dropdown to select Spanish
    await driver.findElement(By.css('div[data-locale="es_ES"] .title')).click();

    // Edit association type name in Spanish
    await driver.findElement(By.id('sylius_product_association_type_translations_es_ES_name')).sendKeys('Productos similares reales');    

    // Click on Save changes button
    await driver.findElement(By.id('sylius_save_changes_button')).click();

    // Assert that association type name has been updated
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Product association type has been successfully updated.'));
  });

  it('defines a type of association between one product and another', async () => {
    // Click in products in side menu
    await driver.findElement(By.linkText('Products')).click();

    // Type in value input to search for specify product
    await driver.findElement(By.css('[id="criteria_search_value"]')).sendKeys('Knitted wool-blend green cap');
   
    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();
    
    // Click in edit product
    await driver.findElement(By.css('*[class^="icon pencil"]')).click();
   
    // Click in association option
    await driver.findElement(By.css('a.item[data-tab="associations"]')).click();
    
    // Click in dropdown the products
    await driver.findElement(By.css('*[class^="product-select ui fluid multiple search selection dropdown"]')).click();
    await driver.sleep(1000);

    // Click in Cashmere_blend_violet_beanie product option
    await driver.findElement(By.css('div.item[data-value="Cashmere_blend_violet_beanie"]')).click();

    // Click on Save changes button
    await driver.findElement(By.css('[id="sylius_save_changes_button"]')).click();
    
    // Assert that product has been updated
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Product has been successfully updated.'));
  });

  it('delete a type of association between one product and another', async () => {
    // Click in products in side menu
    await driver.findElement(By.linkText('Products')).click();

    // Type in value input to search for specify product
    await driver.findElement(By.css('[id="criteria_search_value"]')).sendKeys('Knitted wool-blend green cap');

    // Click in filter blue button
    await driver.findElement(By.css('*[class^="ui blue labeled icon button"]')).click();
   
    // Click in edit product
    await driver.findElement(By.css('*[class^="icon pencil"]')).click();

    // Click in association option
    await driver.findElement(By.css('a.item[data-tab="associations"]')).click();
    await driver.sleep(1000);

    // Click in delete icon
    await driver.findElement(By.css('a.ui.label.transition.visible[data-value="Cashmere_blend_violet_beanie"] i.delete.icon')).click();

    // Click on Save changes button
    await driver.findElement(By.css('[id="sylius_save_changes_button"]')).click();

    // Assert that product has been updated
    const bodyText = await driver.findElement(By.css('body')).getText();
    assert(bodyText.includes('Product has been successfully updated.'));
  });
});