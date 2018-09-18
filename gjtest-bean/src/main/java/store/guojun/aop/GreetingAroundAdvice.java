package store.guojun.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingAroundAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object[] args = invocation.getArguments();
		String clientName = (String) args[0];
		System.out.println(clientName+"欢饮您");
		// 利用反射调用原有逻辑
		Object obj = invocation.proceed();
		System.out.println(clientName+"期待您的下次到来");

		return obj;
	}
}
