package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import java.math.MathContext;

import static org.junit.Assert.*;

public class SetupTest extends BaseTests{

    @Test
    public void testOpeningBrowserAndLoadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseURL()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    public void testLogin(){
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickBtnLogin();
        System.out.println("Click login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getLoginPageURL()));

        login.fillEmail();
        System.out.println("Inseriu e-mail");
        login.fillPasswd();
        System.out.println("Inseriu senha");
        login.clickBtnSubmitLogin();

        System.out.println("Click sign in");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getLoggedUserPageURL()));
        System.out.println("Logado com sucesso");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Pagina de usuário carregada com sucesso");
    }

    @Test
    public void testSearchProduct(){
        HomePage home = new HomePage();
        SearchPageResult search = new SearchPageResult();

        String keys = "DRESS";
        String resultCounter = "7";

        home.fillSearch(keys);
        System.out.println("preencheu busca");

        home.clickSearchBtn();
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"",""),keys);
        assertThat(search.getTextHeadingCounter(), CoreMatchers.containsString(resultCounter));

        System.out.println("executou a busca");
    }

    @Test
    public void testAccessCategoryTShirts(){
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        home.clickCategoryTShirts();
        assertTrue(category.isPageTShirts());
    }

    @Test
    public void testAddProductToProductPage(){

        testAccessCategoryTShirts();

        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();
        String nameProductCategory = category.getProductNameCategory();
        category.clickProductAddToProductPage();
        assertEquals(pdp.getProductNamePDP(), nameProductCategory);
    }

    @Test
    public void testAddProductToCartPage() {

        testAddProductToProductPage();

        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        String nameProductPDP = pdp.getProductNamePDP();
        pdp.ClickButtonAddToCart();
        WebDriverWait wait = new WebDriverWait(Browser.getCurrentDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(pdp.clearFix));
        pdp.clickButtonModalProceedToCheckout();
        assertEquals(cart.getNameProductCart(), nameProductPDP);
    }
}


