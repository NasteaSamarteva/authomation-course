package swaggerAuthomation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dtoSwagger.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testSimpleClass.PropertyReader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AddBooksToUser {

   private CloseableHttpClient client;
   private CloseableHttpResponse response;
   private CreateUserRequest user = new CreateUserRequest();
   private String jsonRequest;
   private SwaggerUserResponse userResponse;
   private BooksResponse booksResponse;


    @BeforeMethod
    public void setUp() throws JsonProcessingException {
        client = HttpClientBuilder.create().build();

        user.setUserName("user11");
        user.setPassword("No123456@");
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        jsonRequest = objectWriter.writeValueAsString(user);

    }


    @Test
    public void createUser() throws IOException {
        HttpPost request = new HttpPost(PropertyReader.getProperty("swagger_new_user"));
        request.setHeader("Content-Type", "application/json");
        request.setEntity(new StringEntity(jsonRequest));

        response= client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        userResponse = objectMapper.readValue(responseBody,SwaggerUserResponse.class);

        Assert.assertEquals(statusCode,201);

    }

    @Test
    public void getBooks() throws IOException {
        HttpGet request = new HttpGet(PropertyReader.getProperty("swagger_books"));
        response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();

        String responseBody = EntityUtils.toString(response.getEntity(),StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        booksResponse = objectMapper.readValue(responseBody,BooksResponse.class);

        Assert.assertEquals(statusCode,200);

    }



}
