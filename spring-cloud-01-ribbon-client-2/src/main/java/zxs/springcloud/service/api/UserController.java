package zxs.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zxs.springcloud.entity.User;

@RestController
public class UserController {
	
	@RequestMapping(value = "/getRetry", method = {RequestMethod.GET})
	public String retry() {
		System.err.println("调用了client2---------");
		return "client2";
	}
	
	@RequestMapping(value = "/getUser", method = {RequestMethod.GET} )
	public User getUser(@RequestParam("id") String id) {
		System.err.println( " client 2 - -- id : "+ id);
		return new User ( id , "张三" , 18 );
	}
	
	@RequestMapping(value = "/postUser", method = {RequestMethod.POST} )
	public User postUser(@RequestParam("id") String id) {
		System.err.println( " client 2 - -- id : "+ id);
		return new User ( id , "李四" , 19 );
	}
	
	@RequestMapping(value = "/insertUser",produces = {"application/json;charset=UTF-8"}, consumes ={"application/json;charset=UTF-8"}, method = {RequestMethod.POST} )
	public User insertUser(@RequestBody User user) {
		System.err.println( " client 2 - -- insert--Name : "+ user.getName());
		return user;
	}
	
	@RequestMapping(value = "/putUser", method = {RequestMethod.PUT} )
	public void putUser(@RequestBody User user,@RequestParam("id") String id) {
		System.err.println( " client 2 - -update--- name : "+ user.getName());
	}
	
	@RequestMapping(value = "/deleteUser", method = {RequestMethod.DELETE} )
	public void deleteUser(@RequestParam("id") String id) {
		System.err.println( " client 2 - -delete--- id : "+ id);
	}
}
