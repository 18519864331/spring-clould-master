package zxs.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/getAppName", method = {RequestMethod.GET})
	public String getAppName() {
		//如果使用服务名称prodiver-servive，就不需要配置服务端的contextPath了，目前项目中配置了，http://prodiver-servive/hello调用即可
	    ResponseEntity<String> forEntity = restTemplate.getForEntity("http://prodiver-servive/prodiver/hello", String.class);
		System.err.println("body=======>"+ forEntity);
	    return "调用成功";
	}
	/**
	 *  通过http方式调用
	 * @return
	 */
	@RequestMapping(value = "/getByUrl", method = {RequestMethod.GET})
	public String getByUrl() {
		RestTemplate urlTemplate = new RestTemplate();
	    ResponseEntity<String> forEntity = urlTemplate.getForEntity("http://localhost:7001/prodiver/hello", String.class);
		System.err.println("body=======>"+ forEntity);
	    return "调用成功";
	}
}
