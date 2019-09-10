package socialnetworking.steps;

import com.socialnetworking.data.Comments;
import com.socialnetworking.data.Post_Data;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;

import java.io.IOException;

public class CucumberSteps {

    static ValidatableResponse response = null;
    static Post_Data dataItem = null;
    static Comments comments_post = null;


    @Before
    public void setup() throws IOException {
        //ValidatableResponse response = null;
    }

    @Given("^I navigate to the api URI$")
    public void i_navigate_to_the_api_URI() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }


    @Then("^I get Http response code \"([^\"]*)\"$")
    public void i_get_Http_response_code(String arg1) {
        response.statusCode(Integer.parseInt(arg1));
    }

    private static Post_Data postData(String userId, String id, String title, String body){
        Post_Data data = new Post_Data();
        data.setUserId(userId);
        data.setId(id);
        data.setTitle(title);
        data.setBody(body);
        return data;

    }

    private static Comments getMaterials(int postId, String name, String email){
        Comments materials = new Comments();
        materials.setPostId(postId);
//        materials.setId(id);
        materials.setName(name);
        materials.setEmail(email);
//        materials.setBody(body);
        return materials;

    }

    @Then("^I get a list of users from the end point and verify the HTTP response \"([^\"]*)\"$")
    public void iGetAListOfUsersFromTheEndPointAndVerifyTheHTTPResponse(String arg0) throws Throwable {
        SerenityRest.given()
                .when()
                .get("/users")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

    @When("^I make a post using these data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iMakeAPostUsingTheseData(String userId, String id, String title, String body) throws Throwable {
        Post_Data data = postData(userId, id, title, body);
        dataItem = data;
        response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .log().all()  //This will print the request information
                .when()
                .body(data)
                .post("/posts")
                .then()
                .log()
                .all()
                .statusCode(201);
    }


    @When("^I make comments to the post using these data \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iMakeCommentsToThePostUsingTheseData(int postId, String name, String email) throws Throwable {
        Comments comment = getMaterials(postId, name, email);
        comments_post = comment;
        response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .log().all()  //This will print the request information
                .when()
                .body(comment)
//                .post("/comments")
                .put("/comments")
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
