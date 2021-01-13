package zxs.springclould.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zxs.springclould.feign.hystrix.ClientServiveFeignHystrixFallBack;

/**
 * name:调用服务端的yml文件的application name
 * fallback:降级策略调的类
 * @author GQ
 *
 */
@FeignClient(name="client-servive",fallback = ClientServiveFeignHystrixFallBack.class)
public interface ClientServiveFeign {

	@RequestMapping(value = "/helloFeignClient",method = {RequestMethod.GET})
	public String helloFeign();
	
	@RequestMapping(value = "/hiFeignClient",method = {RequestMethod.GET})
	public String hiFeign();

	@RequestMapping(value = "/hiZuulClient",method = {RequestMethod.GET})
	public String hiZuul();
}
