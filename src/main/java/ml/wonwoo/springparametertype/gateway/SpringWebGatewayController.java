package ml.wonwoo.springparametertype.gateway;

import org.springframework.cloud.gateway.mvc.ProxyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringWebGatewayController {

    @GetMapping("/proxy")
    public String proxy(ProxyExchange<String> exchange) {
        return exchange.uri("https://start.spring.io")
            .get(response -> ResponseEntity.status(response.getStatusCode())
                .header("foo", "bar")
                .headers(response.getHeaders()).body(response.getBody())).getBody();
    }
}
