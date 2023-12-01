package step_definitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import pages.SearchPage;
import utilities.BrowserUtils;
import utilities.Driver;

import java.util.List;

public class search_stepDefinitions {
    SearchPage searchPage = new SearchPage();

    @Given("I am on the Webstaurant Store website")
    public void i_am_on_the_webstaurant_store_website() {

        Driver.getDriver().get("https://www.webstaurantstore.com");

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "WebstaurantStore: Restaurant Supplies & Foodservice Equipment";

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        searchPage.searchBox.sendKeys(searchTerm);
        searchPage.searchBox.sendKeys(Keys.ENTER);

    }

    @Then("every product in the search results should have the word {string} in its title")
    public void every_product_in_the_search_results_should_have_the_word_in_its_title(String searchTerm) {
        int pageNumber = 2;
        boolean nextButtonExists = true;

        while (nextButtonExists) {

            List<WebElement> productTitles = Driver.getDriver().findElements(By.xpath("//div[@id=\"product_listing\"]/div"));

            for (WebElement title : productTitles) {
                String productTitleText = title.getText();

               Assert.assertTrue("Product title does not contain the expected keyword: " + searchTerm, productTitleText.contains(searchTerm));
            }
            try {
                WebElement nextButton = Driver.getDriver().findElement(By.xpath("//a[@aria-label='go to page " + pageNumber + "']"));
                nextButton.click();
                BrowserUtils.waitForPageToLoad(10);
                pageNumber++;

            } catch (NoSuchElementException e) {
                nextButtonExists = false;
            }
        }
    }
    @Then("I add the last found item to the Cart")
    public void i_add_the_last_found_item_to_the_cart () {

        List<WebElement> productTitles = Driver.getDriver().findElements(By.xpath("//div[@id=\"product_listing\"]/div"));
        WebElement lastProduct = productTitles.get(productTitles.size() - 1);
        lastProduct.click();

        searchPage.addCardButton.click();

        }

    @Then("I empty the Cart")
    public void i_empty_the_cart () {

        searchPage.Cart.click();
        searchPage.EmptyCart.click();
        searchPage.EmptyCartButton.click();

        }


    }
