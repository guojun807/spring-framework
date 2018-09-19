package store.guojun.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class GreetingThrowAdvice implements ThrowsAdvice {
	// 该接口未定义任何方法,是一个标签接口,在运行期 spring 使用反射机制自行判断,格式固定
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable{
		System.out.println("methdo:"+method.getName());
		System.out.println("抛出异常:"+ex.getMessage());
		System.out.println("成功回滚事务");
	}
}
