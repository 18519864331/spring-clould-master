package zxs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker //开启断路器
@EnableRetry //重试机制
@EnableDiscoveryClient  //表示可以注册到eureka上
@SpringBootApplication
public class ConsumerApplication {
	@Bean
	@ConfigurationProperties(prefix = "custom.rest")
	public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory() {
		/*
		 * HttpComponentsClientHttpRequestFactory a = new
		 * HttpComponentsClientHttpRequestFactory();
		 * a.setConnectionRequestTimeout(1000); 
		 * a.setConnectTimeout(250);
		 * a.setReadTimeout(3000);
		 */
		return new HttpComponentsClientHttpRequestFactory();
	}
	
	@Bean
	@LoadBalanced  //自动负载均衡，通过application name去寻找服务发现，做负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate(httpComponentsClientHttpRequestFactory());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ConsumerApplication.class, args);

	}

}
