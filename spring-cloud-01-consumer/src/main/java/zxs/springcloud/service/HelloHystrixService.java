package zxs.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class HelloHystrixService {
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "callHelloFallback")
	public String callHello() {
		String s = restTemplate.getForObject("http://client-servive/helloHystrix", String.class);
		return s;
	}
	
	public String callHelloFallback() {
		System.out.println("----执行降级策略--------");
		return "----执行降级策略--------";
	}

	/**
	 * 单独设置断容器超时时间
	 * @return
	 */
	@HystrixCommand(fallbackMethod ="callHifallback",
			commandProperties = {
					@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="80000")
			}
	)
	public String callHi() {
		String s = restTemplate.getForObject("http://client-servive/hiHystrix", String.class);
		return s;
	}
	
	public String callHifallback() {
		System.out.println("----执行Hi降级策略--------");
		return "----执行Hi降级策略--------";
	}
	

}
