package zxs.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import zxs.springcloud.entity.User;

@RestController
public class IndexController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/retry", method = {RequestMethod.GET})
	public String retry() {
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://client-servive/getRetry", String.class);
		String ret = forEntity.getBody();
		System.err.println("---ret:" + ret);
		return "ret" + ret;
	}
	
	@RequestMapping(value = "/get", method = {RequestMethod.GET})
	public String get() {
		ResponseEntity<User> forEntity = restTemplate.getForEntity("http://client-servive/getUser?id={1}", User.class,"001");
		User user = forEntity.getBody();
		System.err.println("---userName:" + user.getName());
		return "============getUser=========";
	}
	
	@RequestMapping(value = "/post", method = {RequestMethod.GET})
	public String post() {
		MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
		form.set("id", 002);
		ResponseEntity<User> postForEntity = restTemplate.postForEntity("http://client-servive/postUser", form, User.class);
		User user = postForEntity.getBody();
		System.err.println("---userName:" + user.getName());
		return "============postUser=========";
	}
	
	@RequestMapping(value = "/insert", method = {RequestMethod.GET})
	public String insert() {
		User user = new User("003","王五",26);
		ResponseEntity<User> postForEntity = restTemplate.postForEntity("http://client-servive/insertUser", user, User.class);
		User postuser = postForEntity.getBody();
		System.err.println("---userName:" + postuser.getName());
		return "============insertUser=========";
	}
	
	@RequestMapping(value = "/put", method = {RequestMethod.GET})
	public String put() {
		User user = new User("003","王六",28);
		restTemplate.put("http://client-servive/putUser？id={1}", user,"003");
		return "============putUser=========";
	}
	
	@RequestMapping(value = "/delete", method = {RequestMethod.GET})
	public String delete() {
		restTemplate.delete("http://client-servive/deleteUser?id={1}", "003");
		return "============delete=========";
	}
	
	
}
