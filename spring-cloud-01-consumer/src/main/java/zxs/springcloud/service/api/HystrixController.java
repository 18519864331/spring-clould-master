package zxs.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zxs.springcloud.service.HelloHystrixService;

@RestController
public class HystrixController {
	
	@Autowired
	private HelloHystrixService helloHystrixService;
	
	@RequestMapping(value = "/hystrix-hello",method = {RequestMethod.GET})
	public String helloHystrix() {
		
		return helloHystrixService.callHello();
	}
	
	@RequestMapping(value = "/hystrix-hi",method = {RequestMethod.GET})
	public String hiHystrix() {
		return helloHystrixService.callHi();
	}
}
