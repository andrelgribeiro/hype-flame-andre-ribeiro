package selenium.pages;

import java.io.IOException; 
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import utils.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;



public class HomeHypeFlame extends BasePage {
    private static JavascriptExecutor jse = (JavascriptExecutor)driver;
    private static String url = baseURL;
    

    public static void load() throws Exception {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public static void clicarBuscar() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement botaoBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#header-search")));    
        botaoBuscar.click();
    }
    
    public static void buscarString(String parametro) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement campoBusca = wait.until(ExpectedConditions.presenceOfElementLocated​(By.cssSelector("input[type='search']")));    
        campoBusca.sendKeys(parametro);
    }
    
    public static void clicarBuscarEnviar() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement botaoBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));    
        botaoBuscar.click();
        Thread.sleep(3000);

    }
    
    public static int contarArtigos() throws Exception {
        int resultado = driver.findElements(By.cssSelector("article")).size();
        return resultado;
    }

    public static String getResultadoText() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement texto = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#main header h1")));    
        return texto.getText();
    }
}
