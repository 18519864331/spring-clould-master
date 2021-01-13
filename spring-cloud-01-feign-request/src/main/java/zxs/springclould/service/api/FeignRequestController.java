package zxs.springclould.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import zxs.springclould.feign.ClientServiveFeign;

@RestController
public class FeignRequestController {

	@Autowired
	private ClientServiveFeign clientServiveFeign;
	
	@RequestMapping(value = "/helloFeign",method = {RequestMethod.GET})
	public String helloFeign() {
		return clientServiveFeign.helloFeign();
	}
	
	/**
	 * 测试降级策略
	 * @return
	 */
	@RequestMapping(value = "/hiFeign",method = {RequestMethod.GET})
	public String hiFeign() {
		return clientServiveFeign.hiFeign();
	}
	
	/**
	 * zuul 
	 * @return
	 */
	@RequestMapping(value = "/hiZuul",method = {RequestMethod.GET})
	public String hiZuul() {
		return clientServiveFeign.hiZuul();
	}
	

}
