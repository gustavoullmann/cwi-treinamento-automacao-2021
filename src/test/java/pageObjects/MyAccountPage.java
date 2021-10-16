package pageObjects;

import elementMapper.MyAccountElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class MyAccountPage extends MyAccountElementMapper {

    public MyAccountPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Preencheu a busca")
    public void fillSearch(String keys) {
        searchQuery.sendKeys(keys);
    }

    @Step("Clicou em submeter pesquisa")
    public void clickSubmitSearchButton() {
        submitSearch.click();
    }
}
