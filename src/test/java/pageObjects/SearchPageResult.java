package pageObjects;

import elementMapper.SearchPageResultElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class SearchPageResult extends SearchPageResultElementMapper {

    public SearchPageResult(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextNavigationPage(){
        return navigationPage.getText();
    }

    public String getTextLighter(){
        return lighter.getText();
    }

    public String getTextHeadingCounter(){
        return headingCounter.getText();
    }

    public boolean isSearchPage(){
        return getTextNavigationPage().equals("Search");
    }

    @Step("Realizou Mouse Over sobre o produto e clicou em More")
    public void clickProductAddToProductPage() {
        BasePage.mouseOver(product);
        buttonMoreAddToProductPage.click();
    }
}