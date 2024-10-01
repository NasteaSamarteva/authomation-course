package testSimpleClass;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class OptionTest {
    CloseableHttpClient client;

    @BeforeMethod
    public void setUp(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
    }

    @Test
    public void check404Status() throws IOException{
        String header="Access-Control-Allow-Methods";
        String expectedReply="GET, POST, PATCH, PUT, DELETE";
        HttpOptions options  = new HttpOptions("https://api.github.com");
        CloseableHttpResponse optionsResponse = client.execute(options);
        Assert.assertEquals(expectedReply, UtilityMethod.getHeader(optionsResponse,header));
    }
}
