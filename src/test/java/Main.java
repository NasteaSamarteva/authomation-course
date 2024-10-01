import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thoughtworks.xstream.XStream;
import convertioTask.ConvertAllRates;
import dto.ValCurs;
import dto.Valute;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import testSimpleClass.PropertyReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        try (CloseableHttpClient client = new DefaultHttpClient()) {
            HttpGet request = new HttpGet(PropertyReader.getProperty("bnmUrl"));
            CloseableHttpResponse response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String xmlFullResponse = "";
            String xmlResponseBody = "";
            while ((xmlResponseBody = rd.readLine()) != null) {
                xmlFullResponse += xmlResponseBody + "\r\n";
            }

            XStream xStream = new XStream();
            xStream.processAnnotations(ValCurs.class);
            xStream.processAnnotations(Valute.class);


            xStream.addImplicitCollection(ValCurs.class, "valutes", Valute.class);
            ValCurs valCurs = (ValCurs) xStream.fromXML(xmlFullResponse);

            //from java to json
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                System.out.println(objectMapper.writeValueAsString(valCurs));


         //   System.out.println( ConvertAllRates.convertedRates(valCurs,"usd"));
            //            System.out.println(xStream.toXML(valCurs));



        } catch (Exception e) {
            System.out.println("Не получилось отправить запрос");
        }
//        sorting of valutes
//        Collections.sort(valCurs.getValutes());
//

        // Nominal check
//        try {
//            NominalValidation.nominalCheck(valCurs);
//        } catch (NominalException e) {
//            System.out.println(e + e.getMessage());
//        }

        //Find and print specific currency rate
        //       FindAndPrintRate.printSpecificRate(valCurs, "usd");

//        for (Valute valute: valCurs.getValutes()) {
//            System.out.println(valute.getCharCode()+": "+ valute.getValue());
//        }
        //from java to xml
        //

        //Average Exchange Rate
//            System.out.println(AverageExchangeRate.averageExR(valCurs));





    }
}
