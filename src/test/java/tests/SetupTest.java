package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import java.sql.SQLOutput;

import static org.junit.Assert.*;

@Feature("Testes site de e-commerce http://automationpractice.com/")
public class SetupTest extends BaseTests{

    @Test
    @Story("Carregar a homepage do site")
    public void testLoadHomePage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getHomePageURL()));
        System.out.println("Abrimos o navegador e carregamos a url da homepage!");
    }

    @Test
    @Story("Carregar a página de criação de cadastro")
    public void testLoadAccountCreation() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        homePage.clickBtnLogin();
        loginPage.fillAccountCreationEmail();
        loginPage.createAnAccountClickButton();
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 10);
        wait.until(ExpectedConditions.urlContains("#account-creation"));

        assertTrue(loginPage.isAccountCreationPage());
    }

    @Test
    @Story("Preencher cadastro de novo usuário")
    public void testFillAccountCreationForm() {
        testLoadAccountCreation();
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
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickBtnLogin();
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(login.submitLogin));
        login.fillEmail();
        login.fillPasswd();
        login.clickBtnSubmitLogin();

        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getLoggedUserPageURL()));
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

//    @Test
//    @Story("Acessar Categoria")
//    public void testAccessCategoryTShirts() {
//        HomePage home = new HomePage();
//        CategoryPage category = new CategoryPage();
//
//        home.clickCategoryTShirts();
//        assertTrue(category.isPageTShirts());
//    }

    @Test
    @Story("Adicionar página de Produto")
    public void testAddProductToProductPage() {
        testSearchProduct();
        SearchPageResult searchPageResult = new SearchPageResult();

        searchPageResult.clickProductAddToProductPage();
    }

    @Test
    @Story("Adicionar Produto ao Carrinho")
    public void testAddProductToCartPage() {
        testAddProductToProductPage();
        ProductPage productPage = new ProductPage();

        productPage.ClickButtonAddToCart();
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(productPage.clearFix));
        productPage.clickButtonModalProceedToCheckout();
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