package zxs.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeginController {

	@RequestMapping(value = "/helloFeignClient",method = {RequestMethod.GET})
	public String helloFeign() {
		return "Hello Feign client1";
	}
	
	@RequestMapping(value = "/hiFeignClient",method = {RequestMethod.GET})
	public String hiFeignClient() {
		try {
			//测试降级策略
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Hi Feign client1";
	}

}
