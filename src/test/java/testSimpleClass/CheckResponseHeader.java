package testSimpleClass;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckResponseHeader {
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
    public void serverHeaderCheck() throws IOException{
        HttpOptions options  = new HttpOptions("https://api.github.com");
        CloseableHttpResponse optionsResponse = client.execute(options);

        String header=UtilityMethod.getHeader(optionsResponse,"Server");
        Assert.assertEquals(header, "github.com");
    }
    @Test
    public void headerIsPresentCheck() throws IOException{
        HttpOptions options  = new HttpOptions("https://api.github.com");
        CloseableHttpResponse optionsResponse = client.execute(options);

        Boolean headerIsPresent = UtilityMethod.headerIsPresent(optionsResponse,"ETag");

        Assert.assertFalse(headerIsPresent);
    }
}
