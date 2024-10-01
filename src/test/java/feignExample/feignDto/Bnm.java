package feignExample.feignDto;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import feign.Feign;
import feign.Response;
import feign.jackson.JacksonDecoder;
import feignDto.ValCurs;
import feignDto.Valute;

public class Bnm {
    public static void main(String[] args) {
        bnmFeignClient client = Feign.builder()
                .decoder(new JacksonDecoder())
                .target(bnmFeignClient.class, "https://www.bnm.md");

        String param = "yourParam";
        Response response = client.getData();

        try {
            String xmlResponseBody = response.body().toString();

            XmlMapper xmlMapper=new XmlMapper();
            ValCurs valute = xmlMapper.readValue(xmlResponseBody, ValCurs.class);
            System.out.println(valute.getValutes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
