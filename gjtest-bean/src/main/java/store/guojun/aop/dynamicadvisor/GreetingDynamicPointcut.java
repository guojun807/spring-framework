package store.guojun.aop.dynamicadvisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import store.guojun.aop.Waiter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
	private static List<String> specialClientList = new ArrayList<String>();
	static {
		specialClientList.add("张三");
		specialClientList.add("李四");
	}

	/**
	 * 对类进行静态切点检查
	 */
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				System.out.println("调用getClassFilter()对"+clazz.getName()+"做静态检查");
				return Waiter.class.isAssignableFrom(clazz);
			}
		};
	}

	/**
	 * 对方法进行静态切点检查
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		System.out.println("调用matches(method,class)"+targetClass.getName()+"."+method.getName()+"做静态检查");
		return "greetTo".equals(method.getName());
	}
	/**
	 * 对方法进行动态切点检查
	 */
	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		System.out.println("调用matches(method,class)"+targetClass.getName()+"."+method.getName()+"做动态检查");
		String clientName = (String) args[0];
		return specialClientList.contains(clientName);
	}
}

































