package aop;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import store.guojun.aop.Seller;
import store.guojun.aop.Waiter;

/**
 * 切面测试
 * advisor:顾问
 */
public class AopAdvisorTest {
	ClassPathXmlApplicationContext cp = new ClassPathXmlApplicationContext("application.xml");
	@Test
	public void staticAdvisor(){
		try {
			Seller seller = (Seller)cp.getBean("seller");
			seller.greetTo("小明");

			Waiter waiter = (Waiter)cp.getBean("waiter");
			waiter.greetTo("小花");
			waiter.serveTo("小亮");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void regexpAdvisor(){
		try {
			Waiter waiter = (Waiter)cp.getBean("regexpWaiter");
			waiter.greetTo("小花");
			waiter.serveTo("小亮");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void dynamicAdvisor(){
		try {
			Waiter waiter = (Waiter)cp.getBean("dynamicWaiter");
			waiter.greetTo("小花");
			waiter.serveTo("小亮");
			waiter.greetTo("张三");
			waiter.serveTo("李四");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
