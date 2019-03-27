package service.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@RestController
public class AppApplication {
    @Value("${service.instance.name}")
    private String instance;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @RequestMapping("/")
    public String message() {
        return "Hello from " + instance;
    }
}

