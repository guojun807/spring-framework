package store.guojun.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 增强类
 */
public class GreetingAterAdvice implements AfterReturningAdvice {
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		String clientName = (String) args[0];
		System.out.println("谢谢您的光临:"+clientName);

	}
}
