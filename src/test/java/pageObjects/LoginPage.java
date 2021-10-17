package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.Utils;

import java.util.Random;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Preencheu o email")
    public void fillEmail() {
        email.sendKeys("gustavoullmann@gmail.com");
    }

    @Step("Preencheu a senha")
    public void fillPasswd() {
        passwd.sendKeys("12345");
    }

    @Step("Clicou em Sign In")
    public void clickSubmitLoginButton() {
        submitLogin.click();
    }

    @Step("Preencheu email de criação de cadastro")
    public void fillAccountCreationEmail() {
        int randomInt = new Random().nextInt(10000) + 1;
        createAccountEmail.sendKeys("testeGustavo" + String.valueOf(randomInt) + "@mail.com");
    }

    @Step("Clicou em Create an account")
    public void clickCreateAnAccountButton() {
        createAnAccountButton.click();
    }

    @Step("Confirmou que está na página My Account")
    public boolean isMyAccountPage() {
        return Browser.getCurrentDriver().getCurrentUrl().contains((Utils.getLoggedUserPageURL()));
    }

    @Step("Confirmou que está na página de criação de cadastro")
    public boolean isAccountCreationPage() {
        return Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getAccountCreationURL());
    }
}