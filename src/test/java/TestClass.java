import POJO.AbcPOJO;
import POJO.FavsPOJO;
import POJO.MainPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static io.restassured.RestAssured.*;

public class TestClass {

    @Test(priority = 0)
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

    @Test(priority = 1)
    public void secondMethod() {
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


    @Test(priority = 2)
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

    @Test(priority = 3)
    public void fourthMethod() throws JsonProcessingException {
        //{
        //  "name":"Darshan",
        //  "place":"Bangalore",
        //   "abcd":["abc1","abc2"],
        //   "favs":{
        //     "xyz":"xyz1",
        //     "list":["a","b","c","d],
        //     "abc1":{
        //       "name":"suraj",
        //       "lname":"mesta"}}}


        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Darshan");
        map.put("place", "Bangalore");
        List<String> alist = new ArrayList<String>();
        alist.add("abc1");
        alist.add("abc2");
        map.put("abcd", alist);

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("xyz", "xyz1");
        List<String> alist1 = new ArrayList<String>();
        alist1.add("a");
        alist1.add("b");
        alist1.add("c");
        alist1.add("d");
        map1.put("list", alist1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "suraj");
        map2.put("lname", "mesta");
        map1.put("abc1", map2);

        map.put("favs", map1);

        String str = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(map).toString();
        System.out.println(str);


    }

    @Test(priority = 4)
    public void fifthMethod() {
        JSONObject jobj = new JSONObject();
        jobj.put("name", "Darshan");
        jobj.put("place", "Bangalore");
        JSONArray jarr = new JSONArray();
        jarr.put("abc1");
        jarr.put("abc2");
        jobj.put("abcd", jarr);
        JSONObject jobj1 = new JSONObject();
        jobj1.put("xyz", "xyz1");
        JSONArray jarr1 = new JSONArray();
        jarr1.put("a");
        jarr1.put("b");
        jarr1.put("c");
        jarr1.put("d");
        jobj1.put("list", jarr1);
        JSONObject jobj2 = new JSONObject();
        jobj2.put("name", "suraj");
        jobj2.put("lname", "mesta");
        jobj1.put("abc1", jobj2);
        jobj.put("favs", jobj1);

        try {
            String val = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jobj.toMap()).toString();
            System.out.println(val);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test(priority = 5)
    public void pojoTest(){
        AbcPOJO abcpojo = new AbcPOJO("suraj", "mesta");
        FavsPOJO favspojo = new FavsPOJO("xyz1", Arrays.asList("a", "b", "c", "d"),abcpojo);
        MainPOJO mainpojo = new MainPOJO("Darshan", "Bangalore", Arrays.asList("abc1", "abc2"), favspojo);

        try{
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(mainpojo).toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
