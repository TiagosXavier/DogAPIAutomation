package Breeds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API dos Breeds da Dog API")
public class BreedTest {

    private static final String BASE_URI = "https://dog.ceo/api";

    @BeforeAll
    public static void setup() {
        baseURI = BASE_URI;
    }

    @Test
    @DisplayName("Buscar a lista de todos os Dogs")
    public void testBuscarDogs() {
        given()
        .when()
            .get("/breeds/list/all")
        .then()
            .statusCode(200)
            .body("status", equalTo("success"))
            .body("message", notNullValue());
    }

    @Test
    @DisplayName("Buscar a imagem de um Dog especifico")
    public void testBuscarImagemDogEspecifico() {
        String breed = "beagle";
        given()
            .pathParam("breed", breed)
        .when()
            .get("/breed/{breed}/images")
        .then()
            .statusCode(200)
            .body("status", equalTo("success"))
            .body("message", notNullValue())
            .body("message", isA(java.util.ArrayList.class));
    }

    @Test
    @DisplayName("Buscar imagem de um Dog aleatorio")
    public void testBuscarImagemAleatoria() {
        given()
        .when()
            .get("/breeds/image/random")
        .then()
            .statusCode(200)
            .body("status", equalTo("success"))
                .body("message", containsString("https://images.dog.ceo/breeds/"));
    }

    @Test
    @DisplayName("Buscar a lista de todos os Dogs - CENÁRIO DE FALHA SIMULADA")
    public void testBuscarDogsComFalhaSimulada() {
        given()
                .when()
                .get("/breeds/list/all")
                .then()
                .statusCode(500)
                .body("status", equalTo("success"))
                .body("message", notNullValue());
    }

}
