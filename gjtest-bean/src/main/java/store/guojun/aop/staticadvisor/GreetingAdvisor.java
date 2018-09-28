package store.guojun.aop.staticadvisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;
import store.guojun.aop.Waiter;

import java.lang.reflect.Method;

/**
 * 静态切面
 */
public class GreetingAdvisor extends StaticMethodMatcherPointcutAdvisor {

	/**
	 * 切点方法匹配规则
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return "greetTo".equals(method.getName());
	}

	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}
}
