package testSimpleClass;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Get200Test {

    CloseableHttpClient client;

    @BeforeMethod
    public void setUp(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void tearDown() throws IOException{
            client.close();
    }

    @DataProvider(name = "endPointsData")
    public Object[] apiData(){
        return new Object[]{
//                PropertyReader.getProperty("githubApi"),
//                PropertyReader.getProperty("rate_limit_url"),
//                PropertyReader.getProperty("public_gists_url")
        };
    }


    @Test(dataProvider = "endPointsData")
    public void statusCodeTest(String endPoint) throws IOException {

        HttpGet request = new HttpGet(endPoint);
        HttpResponse response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(actualStatusCode, 200);
    }


}
