package pageObjects;

import elementMapper.HomePageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends HomePageElementMapper {

    public HomePage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Clicou em Sign In e direcionou para a página de login")
    public void clickBtnLogin(){
        login.click();
    }

    public void fillSearch(String keys){
        searchQueryTop.sendKeys(keys);
    }

    public void clickSearchBtn(){
        submitSearch.click();
    }

    public void clickCategoryTShirts() {
        menuTShirts.click();
    }
}