package ml.wonwoo.springparametertype.webflux;

import ml.wonwoo.springparametertype.domain.Foo;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public class WebFluxController {

    @PostMapping("/webflux")
    public Mono<?> webflux(@RequestBody Mono<Foo> foo) {
        return foo;
    }

    @GetMapping("/server")
    public Mono<?> webflux(ServerWebExchange exchange, ServerHttpRequest request, ServerHttpResponse response) {
        return Mono.empty();
    }
}
