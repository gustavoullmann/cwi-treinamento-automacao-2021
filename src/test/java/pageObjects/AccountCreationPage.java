package pageObjects;

import elementMapper.AccountCreationPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.Utils;

public class AccountCreationPage extends AccountCreationPageElementMapper {

    public AccountCreationPage() {
        PageFactory.initElements(Browser.getCurrentDriver(),this);
    }

    @Step("Preencheu o primeiro nome")
    public void fillFirstName() {
        customerFirstname.sendKeys("Gustavo");
    }

    @Step("Preencheu o sobrenome")
    public void fillLastName() {
        customerLastname.sendKeys("Ullmann");
    }

    @Step("Preencheu a senha")
    public void fillPassword() {
        password.sendKeys("12345");
    }

    @Step("Preencheu o endereço")
    public void fillAddress1() {
        address.sendKeys("Rua das Avenidas");
    }

    @Step("Preencheu a cidade")
    public void fillCity() {
        city.sendKeys("Porto Alegre");
    }

    @Step("Selecionou o Estado")
    public void selectState() {
        idState.sendKeys("Alaska");
    }

    @Step("Preencheu o CEP")
    public void fillPostCode() {
        postcode.sendKeys("90000");
    }

    @Step("Preencheu o telefone celular")
    public void fillPhoneMobile() {
        phoneMobile.sendKeys("987654321");
    }

    @Step("Clicou em Register")
    public void clickSubmitAccountButton() {
        submitAccountButton.click();
    }

    @Step("Confirmou que está na página do novo usuário")
    public boolean isNewUserPage() {
        return Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getNewUserURL());
    }
}
