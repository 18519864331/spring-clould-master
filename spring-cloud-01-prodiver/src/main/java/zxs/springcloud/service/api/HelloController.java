package zxs.springcloud.service.api;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello", method = {RequestMethod.GET})
	public String getHello() {
		return "Hello";
	}
	
	@RequestMapping(value = "/hi", method = {RequestMethod.GET})
	public String getHi(@RequestHeader("userInfo") String userInfo, @RequestHeader("otherParam") String otherParam) {
		System.err.println("----userInfo:"+userInfo);
		System.err.println("----otherParam:"+otherParam);
		return "Hi Zuul!" + userInfo;
	}
	/**
	 * 文件上传
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = {RequestMethod.POST})
	public String upload(@RequestParam("file") MultipartFile file) {
		System.err.println("名称：" + file.getOriginalFilename());
		try {
			FileUtils.writeByteArrayToFile(new File("D:/upload/"+file.getOriginalFilename()), file.getBytes());
			return "ok";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
	}
}
