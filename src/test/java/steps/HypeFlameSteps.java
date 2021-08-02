package selenium.pages;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.java8.Pt;
import org.json.simple.JSONObject;
import java.lang.Math;
import selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;
import selenium.pages.HomeHypeFlame;


import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class HypeFlameSteps extends BasePage implements Pt {


    public HypeFlameSteps() {

        Dado("que estou na home da hypeflame", () -> {
            System.out.println("----DRIVER: " + driver);
            HomeHypeFlame.load();
        });      

        Dado("clico em buscar", () -> {
            HomeHypeFlame.clicarBuscar();
        });


        Quando("escrevo um valor que retorna muitos resultados", () -> {
            HomeHypeFlame.buscarString("artigos");
        });

        Quando("clico em enviar", () -> {
            HomeHypeFlame.clicarBuscarEnviar();
        });

        Então("muitos resultados são retornados", () -> {
            assertTrue(HomeHypeFlame.contarArtigos() > 2);
        });

        Quando("escrevo um valor que não retorna resultados", () -> {
            HomeHypeFlame.buscarString("Caraguatatuba");

        });

        Então("nenhum resultado é retornado", () -> {
            assertEquals(HomeHypeFlame.contarArtigos(), 0);
        });

        Então("o sistema avisa que não houve resultados", () -> {
            assertEquals(HomeHypeFlame.getResultadoText(), "Nenhum resultado");
        });        
    }
}