import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dtoSwagger.BooksResponse;
import dtoSwagger.CreateUserRequest;
import dtoSwagger.SwaggerUserResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
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
}
