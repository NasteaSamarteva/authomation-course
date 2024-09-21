import com.thoughtworks.xstream.XStream;
import dto.ValCurs;
import dto.Valute;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        try (CloseableHttpClient client = new DefaultHttpClient()) {
            HttpGet request = new HttpGet(PropertyReader.getProperty("bnmUrl"));
            CloseableHttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));
        String xmlFullResponse = "";
        String xmlResponseBody = "";
        while ((xmlResponseBody= rd.readLine()) != null){
            xmlFullResponse+=xmlResponseBody+"\r\n";
        }

        XStream xStream=new XStream();
        xStream.processAnnotations(ValCurs.class);
        xStream.processAnnotations(Valute.class);

        xStream.addImplicitCollection(ValCurs.class,"valutes", Valute.class);
        ValCurs valCurs= (ValCurs) xStream.fromXML(xmlFullResponse);
            for (Valute valute:valCurs
                 ) {

            }

        }catch (Exception e){
            System.out.println("Не получилось отправить запрос");
        }


    }
}
