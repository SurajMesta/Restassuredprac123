
import Builder.LombokBuilder;
import Builder.Payload;
import Builder.PayloadBuilder;
import Builder.StaticInner;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static Utils.APIUtils.*;

public class TestForAPIs {

    @Test(priority = 0)
    public void testWithExternalBuilder() {
        Payload request = PayloadBuilder.build().setPrice(11.85).and().setTitle("test product two")
                .setCategory("electronic").and().with()
                .setDescription("this is a test product").and().with()
                .setImage("https://i.pravatar.cc").perform();

        Response response = buildAPIRequest().body(request).post("/products");
        response.prettyPrint();

    }

    @Test(priority = 1)
    public void testWithInnerClass() {
        StaticInner payload = StaticInner.StaticInnerBuilder.build().with().setTitle("test product three")
                .and().with().setPrice(12.50)
                .and().with().setCategory("Electronics")
                .and().with().setDescription("this is a test product")
                .and().with().setImage("https://i.pravatar.cc").perform();
        buildAPIRequest().body(payload).post("/products");
    }

    @Test(priority = 2)
    public void testWithLombok() {
        LombokBuilder payload = LombokBuilder.builder().setTitle("test product four")
                .setPrice(13.50)
                .setCategory("Clothes")
                .setDescription("this is a fourth product")
                .setImage("https://i.pravatar.cc").perform();
        Response response = buildAPIRequest().body(payload).post("/products");
        response.prettyPrint();
    }

}
