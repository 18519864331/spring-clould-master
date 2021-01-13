package zxs.springclould;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients  //启用feign代理
@EnableCircuitBreaker  //启用断路器 @EnableHystrix也可
@EnableRetry //启用重试机制
@EnableEurekaClient //注册到eureka服务上
@SpringBootApplication
public class Application {

	/**
	 * 使用ribbon做负载均衡
	 * @return
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 启动方法
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
