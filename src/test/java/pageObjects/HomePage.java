package pageObjects;

import elementMapper.HomePageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.Utils;

public class HomePage extends HomePageElementMapper {

    public HomePage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Clicou em Sign In e direcionou para a página de login")
    public void clickLoginButton(){
        login.click();
    }

    @Step("Confirmou que está na homepage")
    public boolean isHomePage() {
        return Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getHomePageURL());
    }
}