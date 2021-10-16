package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

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
    public void clickBtnSubmitLogin() {
        submitLogin.click();
    }

    @Step("Preencheu email de criação de cadastro")
    public void fillAccountCreationEmail() {
        int randomInt = new Random().nextInt(10000) + 1;
        createAccountEmail.sendKeys("teste" + String.valueOf(randomInt) + "@mail.com");
    }

    @Step("Clicou em Create an account")
    public void createAnAccountClickButton() {
        createAnAccountButton.click();
    }
}