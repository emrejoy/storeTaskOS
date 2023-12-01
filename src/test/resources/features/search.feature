Feature: Shopping for Stainless Work Table on Webstaurant Store

Agile story:As a user who is looking for a stainless work table on the Webstaurant Store website,
I want to be able to search for 'stainless work table,' ensure that all products in the
search results have the word 'Table' in their titles, add the last found item to my Cart,
and subsequently empty the Cart.

  @test
  Scenario: Search for Stainless Work Table, Add to Cart, and Empty Cart
    Given   I am on the Webstaurant Store website
    When    I search for 'stainless work table'
    Then    every product in the search results should have the word 'Stainless' in its title
    And     I add the last found item to the Cart
    And     I empty the Cart