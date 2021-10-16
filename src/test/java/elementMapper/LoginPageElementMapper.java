package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "passwd")
    public WebElement passwd;

    @FindBy(id = "SubmitLogin")
    public WebElement submitLogin;

    @FindBy(id = "email_create")
    public WebElement createAccountEmail;

    @FindBy(id = "SubmitCreate")
    public WebElement createAnAccountButton;
}
