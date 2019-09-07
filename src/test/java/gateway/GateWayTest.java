package gateway;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.thorntail.gateway.rest.RestApplication;
import com.thorntail.gateway.service.WebClientService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(Arquillian.class)
public class GateWayTest {

	
	private static String port = "18080";

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackages(true, RestApplication.class.getPackage())
                .addAsResource("project-local.yml", "project-defaults.yml");
    }

    @Before
    public void beforeTest() throws Exception {
        RestAssured.baseURI = String.format("http://localhost:%s", port);
    }

    @Test
    @RunAsClient
    public void testGetStoreStatus() throws Exception {
        given()
            .get("/gateway/test")
            .then()
            .assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("status", equalTo("OK"));
    }
    
    @Test
    @RunAsClient
    public void testHealthCheck() throws Exception {
        given()
            .get("/health")
            .then()
            .assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("outcome", equalTo("UP"));
    }

	
}
