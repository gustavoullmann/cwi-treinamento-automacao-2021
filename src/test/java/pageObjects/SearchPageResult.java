package pageObjects;

import elementMapper.SearchPageResultElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class SearchPageResult extends SearchPageResultElementMapper {

    public SearchPageResult(){
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextNavigationPage(){
        return navigation_page.getText();
    }

    public String getTextLighter(){
        return lighter.getText();
    }

    public String getTextHeadingCounter(){
        return heading_counter.getText();
    }

    public boolean isSearchPage(){
        return getTextNavigationPage().equals("Search");
    }
}
