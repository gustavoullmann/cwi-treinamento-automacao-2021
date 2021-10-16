package pageObjects;

import elementMapper.AccountCreationPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class AccountCreationPage extends AccountCreationPageElementMapper {

    public AccountCreationPage() {
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }
}
