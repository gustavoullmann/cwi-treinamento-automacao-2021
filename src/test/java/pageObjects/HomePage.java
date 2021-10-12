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

    public void fillSearch(String keys){
        search_query_top.sendKeys(keys);
    }

    public void clickSearchBtn(){
        submit_search.click();
    }
}
