package zxs.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulController {
	
	@RequestMapping(value = "/hiZuulClient", method = {RequestMethod.GET})
	public String hiZuul(@RequestHeader("userInfo") String userInfo, @RequestHeader("otherParam") String otherParam) {
		System.err.println("----userInfo:"+userInfo);
		System.err.println("----otherParam:"+otherParam);
		return "Hi Zuul Client1!" + userInfo;
	}
}
