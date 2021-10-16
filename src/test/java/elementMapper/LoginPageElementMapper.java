package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {

    public WebElement email;

    public WebElement passwd;

    public WebElement submitLogin;

    @FindBy(id = "email_create")
    public WebElement createAccountEmail;

    @FindBy(id = "SubmitCreate")
    public WebElement createAnAccountButton;
}
