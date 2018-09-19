package aop;

import org.aopalliance.aop.Advice;
import org.junit.Test;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import store.guojun.aop.*;

public class AopTest {
	/**
	 * 普通前置增强
	 */
	@Test
	public void beforeAdvice() {
		Waiter target = new NaiveWaiter();
		BeforeAdvice advice = new GreetingBeforeAdvice();
		//spring 提供的代理工厂
		ProxyFactory pf = new ProxyFactory();
		//设置代理目标
		pf.setTarget(target);
		//为代理目标添加增强
		pf.addAdvice(advice);
		//生成代理实例

		Waiter proxy = (Waiter) pf.getProxy();
		try {
			proxy.greetTo("张三");
			proxy.serveTo("李四");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过xml配置的前置增强
	 */
	@Test
	public void beforeAdviceByXml() {
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("application.xml");
		Waiter waiter = (Waiter) cp.getBean("waiter");
		try {
			waiter.greetTo("小明");
			waiter.serveTo("小军");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 后置增强
	 */
	@Test
	public void afterAdvice() {
		Waiter target = new NaiveWaiter();
		AfterAdvice advice = new GreetingAterAdvice();
		BeforeAdvice before = new GreetingBeforeAdvice();
		//spring 提供的代理工厂
		ProxyFactory pf = new ProxyFactory();
		//设置代理目标
		pf.setTarget(target);
		//为代理目标添加增强
		pf.addAdvice(advice);
		pf.addAdvice(before);
		//生成代理实例

		Waiter proxy = (Waiter) pf.getProxy();
		try {
			proxy.greetTo("张三");
			proxy.serveTo("李四");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过xml配置的后置增强
	 */
	@Test
	public void afterAdviceByXml() {
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("application.xml");
		Waiter waiter = (Waiter) cp.getBean("afterwaiter");
		try {
			waiter.greetTo("小明");
			waiter.serveTo("小军");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 环绕增强
	 */
	@Test
	public void aroundAdvice() {
		Waiter target = new NaiveWaiter();
		Advice around = new GreetingAroundAdvice();
		//spring 提供的代理工厂
		ProxyFactory pf = new ProxyFactory();
		//设置代理目标
		pf.setTarget(target);
		//为代理目标添加增强
		pf.addAdvice(around);
		//生成代理实例

		Waiter proxy = (Waiter) pf.getProxy();
		try {
			proxy.greetTo("张三");
			proxy.serveTo("李四");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * xml 配置环绕增强
	 */
	@Test
	public void aroundAdviceByXml() {
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("application.xml");
		Waiter waiter = (Waiter) cp.getBean("aroundwaiter");
		try {
			waiter.greetTo("小明");
			waiter.serveTo("小军");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 异常增强
	 */
	@Test
	public void throwAdvice() {
		NaiveErrorWaiter target = new NaiveErrorWaiter();
		Advice around = new GreetingThrowAdvice();
		//spring 提供的代理工厂
		ProxyFactory pf = new ProxyFactory();
		//设置代理目标
		pf.setTarget(target);
		//为代理目标添加增强
		pf.addAdvice(around);
		//生成代理实例

		Waiter proxy = (Waiter) pf.getProxy();
		try {
			proxy.greetTo("张三");
			proxy.serveTo("李四");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * xml 配置环绕增强
	 */
	@Test
	public void throwAdviceByXml() {
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("application.xml");
		NaiveErrorWaiter waiter = (NaiveErrorWaiter) cp.getBean("throwwaiter");
		try {
			waiter.greetTo("小明");
			waiter.serveTo("小军");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * xml 配置引介增强
	 */
	@Test
	public void introduceAdviceByXml() {
		ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("application.xml");
		NaiveWaiter naiveWaiter = (NaiveWaiter) cp.getBean("formService");
		try {
			naiveWaiter.greetTo("张三");
			naiveWaiter.serveTo("李四");

			Monitorable monitorable = (Monitorable) naiveWaiter;
			monitorable.setMonitorableActive(true);

			naiveWaiter.greetTo("小明");
			naiveWaiter.serveTo("小军");





		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
