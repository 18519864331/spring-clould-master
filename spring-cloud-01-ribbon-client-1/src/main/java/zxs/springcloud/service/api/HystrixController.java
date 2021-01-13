package zxs.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {

	@RequestMapping(value = "/helloHystrix",method = {RequestMethod.GET})
	public String helloHystrix() {
		System.err.println("------Hello Hystrix-------");
		return "---client1  Hello Hystrix ---";
	}
	
	@RequestMapping(value = "/hiHystrix",method = {RequestMethod.GET})
	public String hiHystrix() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("------Hi Hystrix-------");
		return "---client1  Hi Hystrix ---";
	}
}
