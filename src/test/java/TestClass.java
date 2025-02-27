import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    @Test
    public void secondMethod(){
        File file = new File(System.getProperty("user.dir") + "/payload.json");
        Response response = given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .baseUri("https://fakestoreapi.com")
                .body(file)
                .post("/products");
        response.prettyPrint();
    }


    @Test
    public void thirdMethod() throws IOException {
        //File file = new File(System.getProperty("user.dir") + "/payload.json");
        String val = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/payload.json")));
        String val1 = val.replace("11.75", "12.15");
        System.out.println(val);
        Response response = given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .baseUri("https://fakestoreapi.com")
                .body(val1)
                .post("/products");
        response.prettyPrint();
    }

}
