package com.cloud;

import com.cloud.filter.AccessFilter;
import com.cloud.filter.CustomErrorFilter;
import com.cloud.filter.ResponseBodyFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class CloudApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudApiGatewayApplication.class, args);
    }

    //@Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    public ResponseBodyFilter responseBodyFilter() {
        return new ResponseBodyFilter();
    }

    @Bean
    public CustomErrorFilter customErrorFilter() {
        return new CustomErrorFilter();
    }
}
