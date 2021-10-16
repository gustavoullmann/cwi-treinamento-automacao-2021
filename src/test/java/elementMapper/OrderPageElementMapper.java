package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPageElementMapper {

    @FindBy(css = ".cart_navigation a[title='Proceed to checkout']")
    public WebElement proceedToCheckoutButton;

    @FindBy(css = ".cart_navigation [name='processAddress']")
    public WebElement proceedToCheckoutButtonStep1;

    @FindBy(id = "cgv")
    public WebElement agreeToTheTermsCheckBox;

    @FindBy(css = ".cart_navigation [name=processCarrier]")
    public WebElement proceedToCheckoutButtonStep2;

    @FindBy(css = ".payment_module [title='Pay by bank wire']")
    public WebElement payByBankWirePaymentOption;

    @FindBy(css = ".cart_navigation [type='submit']")
    public WebElement confirmOrder;
}
