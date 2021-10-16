package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreationPageElementMapper {

    @FindBy(id = "customer_firstname")
    public WebElement customerFirstname;

    @FindBy(id = "customer_lastname")
    public WebElement customerLastname;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement idState;

    @FindBy(id = "postcode")
    public WebElement postcode;

    @FindBy(id = "phone_mobile")
    public WebElement phoneMobile;

    @FindBy(id = "submitAccount")
    public WebElement submitAccountButton;
}
