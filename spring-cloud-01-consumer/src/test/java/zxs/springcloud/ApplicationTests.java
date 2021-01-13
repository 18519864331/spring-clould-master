package zxs.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zxs.springcloud.service.RetryService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ConsumerApplication.class)
public class ApplicationTests {

	@Autowired RetryService retryService;
	
	@Test
	public void testRety() throws Exception {
		retryService.call();
	}
	
}
