package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPageResult;
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

        //TODO Acessar a página do produto que foi pesquisado
        //TODO Adicionar o produto pesquisado no nosso carrinho
    }
}
