package ApiTests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.SSLConfig;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static Properties.LoadProperties.LoadConfigProperty;
import static Properties.LoadProperties.config;

public class Integration extends BasePage {

    @Before
    public void loadProperties() throws IOException {

        LoadConfigProperty();

    }

    @Test
    public void testGoogleTagManagerAPI() {

        RestAssured.baseURI = config.getProperty("baseURI");

        RequestSpecification request = RestAssured

                .given()
                .config(RestAssured.config().sslConfig(new SSLConfig().allowAllHostnames()))
                .accept("application/json, text/javascript, */*; q=0.01")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .cookie("PHPSESSID=g9l0tbdcq22agvssjlhp0imaa6; opcode=waccamaw")
                .header("Host", "app.base7.io")
                .header("Origin", "https://waccamaw.base7.io")
                .header("Referer", "https://waccamaw.base7.io/calendar")
                .param("username", config.getProperty("username"))
                .param("password", config.getProperty("password"));

        Response response = request

                .when()
                .post("/store/collection/integration_settings?whatdo=save-models");

        System.out.println(response.body().asString());

        int responseCode = response.getStatusCode();
        String accessControlAllowOrigin = response.header("Access-Control-Allow-Origin");

        Assert.assertEquals(
                "https://waccamaw.base7.io", accessControlAllowOrigin);

        Assert.assertEquals(
                200, responseCode);

    }
}
