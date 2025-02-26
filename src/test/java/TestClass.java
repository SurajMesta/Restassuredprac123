import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TestClass {

    @Test
    public void firstMethod() {
        String str = "{\n" +
                "    \"title\": \"test product one\",\n" +
                "    \"price\": 11.5,\n" +
                "    \"description\": \"this is a test product\",\n" +
                "    \"image\": \"https://i.pravatar.cc\",\n" +
                "    \"category\": \"electronic\"\n" +
                "}";

        Response response = given().contentType(ContentType.JSON)
                .log().all()
                .baseUri("https://fakestoreapi.com")
                .body(str)
                .post("/products");

        response.prettyPrint();
    }
}
