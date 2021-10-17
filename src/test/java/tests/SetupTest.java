package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utils.Browser;

import static org.junit.Assert.*;

@Feature("Testes site de e-commerce http://automationpractice.com/")
public class SetupTest extends BaseTests{

    @Test
    @Story("Carregar a homepage do site")
    public void testLoadHomePage() {
        HomePage homePage = new HomePage();
        assertTrue(homePage.isHomePage());
    }

    @Test
    @Story("Carregar a página de criação de cadastro")
    public void testLoadAccountCreationPage() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.clickLoginButton();
        loginPage.fillAccountCreationEmail();
        loginPage.clickCreateAnAccountButton();
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 10);
        wait.until(ExpectedConditions.urlContains("#account-creation"));

        assertTrue(loginPage.isAccountCreationPage());
    }

    @Test
    @Story("Preencher cadastro de novo usuário")
    public void testFillAccountCreationForm() {
        testLoadAccountCreationPage();
        AccountCreationPage accountCreationPage = new AccountCreationPage();

        accountCreationPage.fillFirstName();
        accountCreationPage.fillLastName();
        accountCreationPage.fillPassword();
        accountCreationPage.fillAddress1();
        accountCreationPage.fillCity();
        accountCreationPage.selectState();
        accountCreationPage.fillPostCode();
        accountCreationPage.fillPhoneMobile();
        accountCreationPage.clickSubmitAccountButton();

        assertTrue(accountCreationPage.isNewUserPage());
    }

    @Test
    @Story("Realizar o login")
    public void testLogin() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.clickLoginButton();
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.submitLogin));
        loginPage.fillEmail();
        loginPage.fillPasswd();
        loginPage.clickSubmitLoginButton();

        assertTrue(loginPage.isMyAccountPage());
    }

    @Test
    @Story("Realizar uma pesquisa de produto")
    public void testSearchProduct() {
        testLogin();
        MyAccountPage myAccountPage = new MyAccountPage();

        String keys = "DRESS";

        myAccountPage.fillSearch(keys);
        myAccountPage.clickSubmitSearchButton();
    }

    @Test
    @Story("Adicionar página de Produto")
    public void testAddProductToProductPage() {
        testSearchProduct();
        SearchResultPage searchResultPage = new SearchResultPage();

        searchResultPage.clickProductAddToProductPage();
    }

    @Test
    @Story("Adicionar Produto ao Carrinho")
    public void testAddProductToCartPage() {
        testAddProductToProductPage();
        ProductPage productPage = new ProductPage();

        productPage.ClickAddToCartBUtton();
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(productPage.clearFix));
        productPage.clickModalProceedToCheckoutButton();
    }

    @Test
    @Story("Finalizar uma compra")
    public void completeOrder() {
        testAddProductToCartPage();
        OrderPage orderPage = new OrderPage();

        orderPage.clickProceedToCheckoutButton();
        orderPage.clickProceedToCheckoutButtonStep1();
        orderPage.clickAgreeToTheTermsServiceCheckBox();
        orderPage.clickProceedToCheckoutButtonStep2();
        orderPage.clickpayByBankWirePaymentOption();
        orderPage.clickIConfirmMyOrderButton();
    }
}