package pageObjects;

import elementMapper.SearchResultPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class SearchResultPage extends SearchResultPageElementMapper {

    public SearchResultPage(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Realizou Mouse Over sobre o produto e clicou em More")
    public void clickProductAddToProductPage() {
        BasePage.mouseOver(product);
        buttonMoreAddToProductPage.click();
    }
}