describe('association types', () => {

  beforeEach(() => {
    cy.visit('/admin');
    cy.get('[id="_username"]').clear().type('sylius');
    cy.get('[id="_password"]').clear().type('sylius');
    cy.get('.primary').click();
  });
 
  it('change the name of an association type', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Type in value input to search for specify association type
    cy.get('[id="criteria_name_value"]').type('Similar');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Click in edit of the remain association type
    cy.get('*[class^="ui labeled icon button "]').last().click();

    // Edit association type name
    cy.get('[id="sylius_product_association_type_translations_en_US_name"]').clear().type('Real similar products');
    
    // Click on Save changes button
    cy.get('[id="sylius_save_changes_button"]').scrollIntoView().click();

    // Assert that association type name has been updated
    cy.get('body').should('contain', 'Product association type has been successfully updated.');
  });

  it('create a new association type', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');
    
    // Click in create button
    cy.get('*[class^="ui right floated buttons"]').first().click();
    
    // Defines the code of the association type
    cy.get('[id="sylius_product_association_type_code"]').type('low-cost');
    
    // Defines the name of the association type in english
    cy.get('[id="sylius_product_association_type_translations_en_US_name"]').type('Low Cost');

    // Click on the portuguese language dropdown
    cy.get('div[data-locale="pt_PT"] .title').click();

    // Defines the name of the association type in portuguese
    cy.get('#sylius_product_association_type_translations_pt_PT_name').clear().type('Baixo Custo');
    
    // Click in create button
    cy.get('*[class^="ui labeled icon primary button"]').last().click();

    // Assert that association type has been created
    cy.get('body').should('contain', 'Product association type has been successfully created.');
  });

  it('create a new association type that already exists', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');
    
    // Click in create button
    cy.get('*[class^="ui right floated buttons"]').first().click();
    
    // Defines the code of the association type
    cy.get('[id="sylius_product_association_type_code"]').type('similar_products');
    
    // Defines the name of the association type in english
    cy.get('[id="sylius_product_association_type_translations_en_US_name"]').type('Real similar products');

    // Click on the german language dropdown
    cy.get('div[data-locale="de_DE"] .title').click();

    // Defines the name of the association type in german
    cy.get('#sylius_product_association_type_translations_de_DE_name').clear().type('echte ähnliche Produkte');
    
    // Click in create button
    cy.get('*[class^="ui labeled icon primary button"]').last().click();

    // Asserting that the association type was not created
    cy.get('body').should('contain', 'The association type with given code already exists.');
  });

  it('delete association type by action button in table', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Defines code to search for a specific association type
    cy.get('[id="criteria_code_value"]').type('low-cost');

    // Defines name to search for a specific association type
    cy.get('[id="criteria_name_value"]').type('Low Cost');

    // Click in filter button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Click in delete button on the table
    cy.get('tr.item:contains("Low Cost") button[type="submit"]').click();

    // Click in confirmation button
    cy.get('[id="confirmation-button"]').last().click();

    // Assert that association type has been deleted
    cy.get('body').should('contain', 'Product association type has been successfully deleted.');
  });

  it('delete association type by button outside table', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Click in create button
    cy.get('*[class^="ui right floated buttons"]').first().click();
    
    // Defines the code of the association type
    cy.get('[id="sylius_product_association_type_code"]').type('low-cost');
    
    // Defines the name of the association type in english
    cy.get('[id="sylius_product_association_type_translations_en_US_name"]').type('Low Cost');

    // Click in create button
    cy.get('*[class^="ui labeled icon primary button"]').last().click();

    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Defines code to search for a specific association type
    cy.get('[id="criteria_code_value"]').type('low-cost');

    // Defines name to search for a specific association type and enter click
    cy.get('[id="criteria_name_value"]').type('Low Cost').type('{enter}');

    // Click on select all items in the table
    cy.get('th.center.aligned input[type="checkbox"]').first().click();

    // Click in delete button outside the table
    cy.get('*[class^="ui red labeled icon button"]').first().click();

    // Click in confirmation button
    cy.get('[id="confirmation-button"]').last().click();

    // Assert that association type has been deleted
    cy.get('body').should('contain', 'Product_association_types have been successfully deleted.');
  });

  it('checks filter "Not contains"', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Define filter type
    cy.get('select#criteria_name_type').select('Not contains');

    // Type in value input to search for specify association type
    cy.get('[id="criteria_name_value"]').type('similar');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Asserting that the search did not return any results
    cy.get('body').should('not.contain', 'Real similar products');
  })

  it('checks filter "Starts with"', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Define filter type 
    cy.get('select#criteria_name_type').select('Starts with');

    // Type in value input to search for specify association type
    cy.get('[id="criteria_name_value"]').type('Real');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Asserting that the search returned the expected result
    cy.get('body').should('contain', 'Real similar products');

    // Asserting that there is only the searched item in the table
    cy.get('table.ui.table tbody tr.item').should('have.length', 1);
  })

  it('filter with empty result', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Type in value input to search for specify association type
    cy.get('[id="criteria_code_value"]').type('melao');

    // Type in value input to search for specify association type
    cy.get('[id="criteria_name_value"]').type('Melão');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Asserting that the search did not return any results
    cy.get('body').should('contain', 'There are no results to display');
  });

  it('clear filters to return normal result', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Type in value input to search for specify association type
    cy.get('[id="criteria_code_value"]').type('melao');

    // Type in value input to search for specify association type
    cy.get('[id="criteria_name_value"]').type('Melão');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Click in clear filter button
    cy.get('*[class^="ui labeled icon button"]').last().click();

    // Assert that the results have returned to the normal state
    cy.get('body').should('contain', 'Real similar products');
  });

  it('add Spanish (Spain) name for an association type', () => {
    // Click in association types in side menu
    cy.clickInFirst('a[href="/admin/product-association-types/"]');

    // Type in value input to search for specify association type
    cy.get('[id="criteria_name_value"]').type('similar');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').click();

    // Click in edit of the remain association type
    cy.get('*[class^="ui labeled icon button "]').last().click();

    // Click in dropdown to select Spanish
    cy.get('div[data-locale="es_ES"] .title').click();

    // Edit association type name in Spanish
    cy.get('#sylius_product_association_type_translations_es_ES_name').clear().type('Productos similares reales');

    // Click on Save changes button
    cy.get('[id="sylius_save_changes_button"]').scrollIntoView().click();

    // Assert that association type name has been updated
    cy.get('body').should('contain', 'Product association type has been successfully updated.');
  });

  it('defines a type of association between one product and another', () => {
    // Click in products in side menu
    cy.clickInFirst('a[href="/admin/products/"]');

    // Type in value input to search for specify product
    cy.get('[id="criteria_search_value"]').scrollIntoView().type('Knitted wool-blend green cap');

    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').scrollIntoView().click();

    // Click in edit product
    cy.get('a.ui.labeled.icon.button').contains('Edit').click();

    // Click in association option
    cy.get('a').contains('Associations').click();

    // Click in dropdown the products
    cy.get('*[class^="product-select ui fluid multiple search selection dropdown"]').first().click();

    // Click in Cashmere_blend_violet_beanie product option
    cy.get('div.item[data-value="Cashmere_blend_violet_beanie"]').click();

    // Click on Save changes button
    cy.get('[id="sylius_save_changes_button"]').scrollIntoView().click();

    // Assert that product has been updated
    cy.get('body').should('contain', 'Product has been successfully updated.');
  });
  
  it('delete a type of association between one product and another', () => {
    // Click in products in side menu
    cy.clickInFirst('a[href="/admin/products/"]');

    // Type in value input to search for specify product
    cy.get('[id="criteria_search_value"]').scrollIntoView().type('Knitted wool-blend green cap');
 
    // Click in filter blue button
    cy.get('*[class^="ui blue labeled icon button"]').scrollIntoView().click();
 
    // Click in edit product
    cy.get('a.ui.labeled.icon.button').contains('Edit').click();
 
    // Click in association option
    cy.get('a').contains('Associations').click();

    // Click in delete icon
    cy.get('a.ui.label.transition.visible[data-value="Cashmere_blend_violet_beanie"] i.delete.icon').click();

    // Click on Save changes button
    cy.get('[id="sylius_save_changes_button"]').scrollIntoView().click();

    // Assert that product has been updated
    cy.get('body').should('contain', 'Product has been successfully updated.');
  });
});