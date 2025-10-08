package com.upc.pre.peaceapp.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {
        "com.upc.pre.peaceapp.iam",
        "com.upc.pre.peaceapp.shared.documentation"
})
@EnableDiscoveryClient
public class IAMServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(IAMServiceApplication.class, args);
    }
}
