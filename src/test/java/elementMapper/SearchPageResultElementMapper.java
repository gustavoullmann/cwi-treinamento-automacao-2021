package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageResultElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement navigationPage;

    @FindBy(className = "lighter")
    public WebElement lighter;

    @FindBy(className = "heading-counter")
    public WebElement headingCounter;

    @FindBy(css = ".product_list .product-name")
    public WebElement product;

    @FindBy(css = ".button[title=View]")
    public WebElement buttonMoreAddToProductPage;
}
