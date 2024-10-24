import com.beust.jcommander.IVariableArity;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.github.GitResponse;
import dto.Repo;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class CreateRepo extends BaseClass {

    CloseableHttpResponse response;
    Repo requestPayload = new Repo();

    private static final Logger log = Logger.getLogger(BaseClass.class);

    @Test(priority = 1)
    public void createRepo() throws IOException {
        String repoName = UUID.randomUUID().toString();
        requestPayload.setName(repoName);
        requestPayload.setDescription("Repository create prin HTTP apache");

        ObjectMapper objectMapper = new ObjectMapper();
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
        String createRepoGithubUrl = PropertyReader.getProperty("createRepoUrl");
        response = postRequest(createRepoGithubUrl, payload, githubToken);
        String responseStr = EntityUtils.toString(response.getEntity());
        log.info("response->" + responseStr);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);

    }

    @Test(priority = 2)
    public void deleteRepo() throws IOException {
        String createRepoGitHubUrl = PropertyReader.getProperty("deleteRepoUrl");
        response = deleteRequest(createRepoGitHubUrl,requestPayload.getName(),githubToken);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }

//    @Test
//    public void checkResponseBody() throws IOException {
//        HttpGet request = new HttpGet("https://api.github.com/repos/NasteaSamarteva/hello-world2");
//        response = client.execute(request);
//
//        String responseBody = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        GitResponse gitResponseMessage = objectMapper.readValue(responseBody, GitResponse.class);
//
//        Assert.assertEquals(gitResponseMessage.getMessage(), "Not Found");
//
//    }
}
