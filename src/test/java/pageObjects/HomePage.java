package pageObjects;

import elementMapper.HomePageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends HomePageElementMapper {

    public HomePage(){
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    public void clickBtnLogin(){
        login.click();
    }

    public void fillSearch(){
        search_query_top.sendKeys("dress");
    }

    public void clickSearchBtn(){
        submit_search.click();
    }
}
