package testSimpleClass;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dto.GitResponse;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CreateRepo {

    private static final String GITHUB_TOKEN_ENV = "GITHUB_TOKEN";
    CloseableHttpClient client;
    CloseableHttpResponse response;
    String githubToken;

    @BeforeMethod
    public void setUp() {
        githubToken = System.getenv(GITHUB_TOKEN_ENV);
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
    }

    @Test(priority = 1)
    public void createRepo() throws IOException {
        HttpPost request = new HttpPost("https://api.github.com/user/repos");
        request.setHeader(HttpHeaders.AUTHORIZATION, "token %s".formatted(githubToken));


        String json = "{\"name\": \"hello-world2\"}";
        request.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        System.out.println(json);

        response = client.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_CREATED);

    }

    @Test(priority = 2)
    public void deleteRepo() throws IOException {
        HttpDelete request = new HttpDelete("https://api.github.com/repos/NasteaSamarteva/hello-world2");
        request.setHeader(HttpHeaders.AUTHORIZATION, "token %s".formatted(githubToken));

        response = client.execute(request);

        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void checkResponseBody() throws IOException {
        HttpGet request = new HttpGet("https://api.github.com/repos/NasteaSamarteva/hello-world2");
        response = client.execute(request);

        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();

        GitResponse gitResponseMessage = objectMapper.readValue(responseBody,GitResponse.class);

        Assert.assertEquals(gitResponseMessage.getMessage(),"Not Found");
    }
}
