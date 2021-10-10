package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.assertTrue;

public class SetupTest extends BaseTests{

    @Test
    public void testOpeningBrowserAndLoadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseURL()));
        System.out.println("Abrimos o navegador e carregamos a url!");
    }

    @Test
    public void testLogin(){
        Browser.getCurrentDriver().findElement(By.className("login")).click();
        System.out.println("Click login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getLoginPageURL()));
        Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("gustavoullmann@gmail.com");
        System.out.println("Inseriu e-mail");
        Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("12345");
        System.out.println("Inseriu senha");
        Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
        System.out.println("Click sign in");
        assertTrue((Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getLoggedUserPageURL())));
        System.out.println("Logado com sucesso");
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Pagina de usuário carregada com sucesso");
    }
}
