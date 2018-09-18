package store.guojun.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * 增强类
 */
public class GreetingBeforeAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		String clientName = (String) args[0];
		System.out.println(clientName+"的前置增强");
	}
}
