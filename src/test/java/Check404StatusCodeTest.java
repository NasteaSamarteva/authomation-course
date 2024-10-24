package testSimpleClass;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Check404StatusCodeTest {
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
        HttpGet request = new HttpGet("https://api.github.com/use");
        HttpResponse response = client.execute(request);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 404);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), 401);
    }
}
