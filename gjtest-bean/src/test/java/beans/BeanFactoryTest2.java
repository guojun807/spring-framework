package beans;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;
import org.springframework.util.xml.XmlValidationModeDetector;
import store.guojun.beans.MyTestBean;
import store.guojun.beans.constructor.HelloBean;
import store.guojun.beans.depends.TestA;
import store.guojun.beans.lookup.GetUserBeanTest;

import java.io.InputStream;

@SuppressWarnings("deprecation")
public class BeanFactoryTest2 {
	/**
	 * 测试 循环依赖
	 * 测试前需要注释掉
	 */
	@Test
	public void BeanFactoryTest7(){
		BeanFactory bf = null;
		try {
			bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
			TestA testA = (TestA)bf.getBean("testA");
			testA.a();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
