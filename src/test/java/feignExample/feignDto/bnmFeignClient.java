package feignExample.feignDto;

import feign.RequestLine;
import feign.Response;

public interface bnmFeignClient {

    @RequestLine("GET /en/official_exchange_rates?get_xml=1&date=13.07.2021")
    Response getData();
}
