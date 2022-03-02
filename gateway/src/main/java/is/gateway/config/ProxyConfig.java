package is.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class ProxyConfig {
  @Bean
  RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    return builder.routes()
        .route("ServerSmsApplication",
            route -> route.path("/ServerSmsApplication/**")
                .and()
                .method(HttpMethod.GET)
                .filters(filter -> filter.stripPrefix(1)
                )
                .uri("lb://ServerSmsApplication"))
        .route("ServerEmailApplication",
            route -> route.path("/ServerEmailApplication/**")
                .filters(filter -> filter.stripPrefix(1)
                )
                .uri("lb://ServerEmailApplication"))
        .route("ServerPushApplication",
            route -> route.path("/ServerPushApplication/**")
                .filters(filter -> filter.stripPrefix(1)
                )
                .uri("lb://ServerPushApplication"))
        .build();
  }
}