package Utils;

import Builder.PayloadBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class APIUtils {

    private APIUtils() {
    }

    public static RequestSpecification buildAPIRequest() {
        return given().log().all().contentType(ContentType.JSON).baseUri("https://fakestoreapi.com");
    }
}
