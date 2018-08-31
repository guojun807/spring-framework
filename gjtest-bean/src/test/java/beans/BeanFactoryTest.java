package beans;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.XmlValidationModeDetector;
import store.guojun.beans.constructor.HelloBean;
import store.guojun.beans.lookup.GetUserBeanTest;
import store.guojun.beans.MyTestBean;

import java.io.*;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {
	BeanFactory bf = null;
	@Before
	public void BeanFactoryTest(){
		bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
	}

	@Test
	public void BeanFactoryTest1(){
		long time = System.currentTimeMillis();
		System.out.println(time);
		// --开始
		MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
		System.out.println(myTestBean.getTestStr());

		// --结束
		long endtime = System.currentTimeMillis();
		System.out.println(endtime);
		System.out.println(endtime-time);
	}

	@Test
	public void BeanFactoryTest2(){
		long time = System.currentTimeMillis();
		System.out.println(time);
		ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		MyTestBean myTestBean = (MyTestBean)ac.getBean("myTestBean");
		System.out.println(myTestBean.getTestStr());
		long endtime = System.currentTimeMillis();
		System.out.println(endtime);
		System.out.println(endtime-time);
	}

	@Test
	public void BeanFactoryTest3(){
		System.out.println(		StringUtils.hasText(null)		);
		System.out.println(		StringUtils.hasText("")		);
		System.out.println(		StringUtils.hasText("  ")		);
		System.out.println(		StringUtils.hasText(" aa")		);
	}

	@Test
	public void BeanFactoryTest4(){
		try {
			//查看验证xml验证模式
			InputStream inputStream = new ClassPathResource("application.xml").getInputStream();
			new XmlValidationModeDetector().detectValidationMode(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		new XmlValidationModeDetector();
	}

	/**
	 * 测试 解析lookup-methed
	 * 用于可插拔的配置
	 */
	@Test
	public void BeanFactoryTest5(){
		BeanDefinition bd = ((XmlBeanFactory) bf).getBeanDefinition("getUserBeanTest");
		System.out.println(bd.getAttribute("hello"));
		GetUserBeanTest myTestBean = (GetUserBeanTest) bf.getBean("getUserBeanTest");
		myTestBean.showMe();
	}

	/**
	 * 测试 解析lookup-methed
	 * 用于可插拔的配置
	 */
	@Test
	public void BeanFactoryTest6(){
		HelloBean myTestBean = (HelloBean) bf.getBean("helloBean");
		System.out.println(myTestBean.toString());
	}

}
