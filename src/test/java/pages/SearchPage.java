package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPage {

    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='searchval']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='border-gray-200 border-solid border border-t-0 border-l-0 box-border flex flex-col p-2 relative xsl:p-4']")
    public WebElement productDetails;

    @FindBy(xpath = "//*[@id=\"buyButton\"]")
    public WebElement addCardButton;

    @FindBy(xpath = "//a[@aria-label='Your cart has 1 items. View your cart.']")
    public WebElement Cart;

    @FindBy(xpath = "//button[normalize-space()='Empty Cart']")
    public WebElement EmptyCart;

    @FindBy(xpath = "//div[@role='alertdialog']//footer//button[1]")
    public WebElement EmptyCartButton;


}
