package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountElementMapper {

    @FindBy(id = "search_query_top")
    public WebElement searchQuery;

    @FindBy(name = "submit_search")
    public WebElement submitSearch;
}
