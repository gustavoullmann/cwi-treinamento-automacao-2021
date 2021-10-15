package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

@Feature("Testes site de ecommerce")
public class SetupTest extends BaseTests{

    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseURL()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    @Story("Realizar o login")
    public void testLogin(){
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickBtnLogin();
        System.out.println("Clicou em Sign In e direcionou para a página de login");
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

//    @Test
//    public void testSearchProduct(){
//        HomePage home = new HomePage();
//        SearchPageResult search = new SearchPageResult();
//
//        String keys = "DRESS";
//        String resultCounter = "7";
//
//        home.fillSearch(keys);
//        System.out.println("preencheu busca");
//
//        home.clickSearchBtn();
//        assertTrue(search.isSearchPage());
//        assertEquals(search.getTextLighter().replace("\"",""),keys);
//        assertThat(search.getTextHeadingCounter(), CoreMatchers.containsString(resultCounter));
//
//        System.out.println("executou a busca");
//    }

    @Test
    @Story("Acessar Categoria")
    public void testAccessCategoryTShirts(){
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        home.clickCategoryTShirts();
        assertTrue(category.isPageTShirts());
    }

    @Test
    @Story("Adicionar página de Produto")
    public void testAddProductToProductPage(){
        testAccessCategoryTShirts();

        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();
        String nameProductCategory = category.getProductNameCategory();
        category.clickProductAddToProductPage();
        assertEquals(pdp.getProductNamePDP(), nameProductCategory);
    }

    @Test
    @Story("Adicionar Produto ao Carrinho")
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

//teste new branch