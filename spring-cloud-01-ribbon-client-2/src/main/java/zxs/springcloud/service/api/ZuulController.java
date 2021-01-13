package zxs.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulController {
	
	@RequestMapping(value = "/hiZuulClient", method = {RequestMethod.GET})
	public String hiZuul(@RequestHeader("userInfo") String userInfo, @RequestHeader("otherParam") String otherParam) {
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		System.err.println("----userInfo:"+userInfo);
		System.err.println("----otherParam:"+otherParam);
		return "Hi Zuul Client2!" + userInfo;
	}
}
