package pageObjects;

import elementMapper.OrderPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class OrderPage extends OrderPageElementMapper {

    public OrderPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Clicou em Proceed to checkout")
    public void clickProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    @Step("Clicou em Proceed to checkout do Step 1")
    public void clickProceedToCheckoutButtonStep1() {
        proceedToCheckoutButtonStep1.click();
    }

    @Step("Clicou em concordo com os termos de serviço")
    public void clickAgreeToTheTermsServiceCheckBox() {
        agreeToTheTermsCheckBox.click();
    }

    @Step("Clicou em Proceed to checkout do Step 2")
    public void clickProceedToCheckoutButtonStep2() {
        proceedToCheckoutButtonStep2.click();
    }

    @Step("Escolheu opção Pay by Bank Wirw")
    public void clickpayByBankWirePaymentOption() {
        payByBankWirePaymentOption.click();
    }

    @Step("Clicou em I confirm my order")
    public void clickIConfirmMyOrderButton() {
        confirmOrder.click();
    }
}
