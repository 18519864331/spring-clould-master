package zxs.springclould;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class CustmomAuthFilter extends ZuulFilter {

	public static final String TOKEN_VALUE ="123456";
	/**
	 * 是否开启Filter
	 */
	@Override
	public boolean shouldFilter() {
		//return true;
		return false;
	}

	/**
	 * 要实现的内容
	 */
	@Override
	public Object run() throws ZuulException {
		//http请求到---zuul(run方法)----RequestContext
		RequestContext ctx = RequestContext.getCurrentContext();
		//获得http请求内容
		HttpServletRequest request = ctx.getRequest();
		//从request里可以拿到请求路径，token等
		String uri = request.getRequestURI(); //拿到请求路径
		if(!"/prodiver-servive/prodiver/upload".equals(uri)) {
			//token(header)
			String token = request.getHeader("x-auth-token"); //x-auth-token:测试的时候从postman传入
			if(StringUtils.isBlank(token)) {
				System.err.println("---没有token，检验失败----");
				//返回信息
				ctx.setSendZuulResponse(false);
				ctx.setResponseStatusCode(401);
				ctx.setResponseBody("---no token!---");
				return null;
			}else {
				//拿到token 
				if(TOKEN_VALUE.equals(token)) {
					//可以解密，拿到token携带的用户信息
					ctx.addZuulRequestHeader("userInfo", "001_zs_25");
					ctx.addZuulRequestHeader("otherParam", "123");
				}else {
					System.err.println("---token错误，检验失败----");
					//返回信息
					ctx.setSendZuulResponse(false);
					ctx.setResponseStatusCode(401);
					ctx.setResponseBody("---token auth fail !---");
					return null;
				}
			}
		}
		return ctx;
	}

	/**
	 * filter的类型
	 * pre:在请求被路由之前被调用
	 * routing:在请求被路由中被调用
	 * post:在请求被路由后被调用
	 * error:在请求发生错误时调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * filter优先级，数字越小越优先级越高
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
