import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class Check401StatusCodeTest {
    CloseableHttpClient client;

    @BeforeMethod
    public void setUp(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException {
        client.close();
    }
    @DataProvider(name = "notAuthorizedApiData")
    public Object[] notAuthorizedApiData(){
        return new Object[]{
//                PropertyReader.getProperty("current_user_url"),
//                PropertyReader.getProperty("followers_url"),
//                PropertyReader.getProperty("user_organizations_url")
        };
    }
    @Test(dataProvider = "notAuthorizedApiData")
    public void statusCode401Test(String endPoint) throws IOException {

        HttpGet request = new HttpGet(endPoint);
        HttpResponse response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatusCode, 401);
    }

}
