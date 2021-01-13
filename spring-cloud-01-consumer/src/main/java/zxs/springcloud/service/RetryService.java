package zxs.springcloud.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

	//进行重试次略
	@Retryable(value = {RemoteAccessException.class}, //意思是什么样的异常进行重试策略，此异常表示远程异常
			maxAttempts = 3,  //重试次数
			backoff = @Backoff(delay = 5000,multiplier = 5) //间隔，多少个执行者
	)
	public void call() throws Exception{
		System.err.println("---调用了call()方法-------");
		throw new RemoteAccessException("rpc调用异常");
	}
	
	@Recover //最终失败补偿
	public void recover(RemoteAccessException e) {
		System.err.println("-------最终处理---------->"+e.getMessage());
	}
}
