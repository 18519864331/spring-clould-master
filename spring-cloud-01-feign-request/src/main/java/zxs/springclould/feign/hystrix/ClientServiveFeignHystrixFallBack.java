package zxs.springclould.feign.hystrix;

import org.springframework.stereotype.Component;

import zxs.springclould.feign.ClientServiveFeign;

@Component
public class ClientServiveFeignHystrixFallBack implements ClientServiveFeign{

	@Override
	public String helloFeign() {
		
		return "--Hello Feign 方法的降级策略 --------------";
	}

	@Override
	public String hiFeign() {
		
		return "--Hi Feign 方法的降级策略 --------------";
	}

	@Override
	public String hiZuul() {
		return "--Hi Zuul 方法的降级策略 --------------";

	}

}
