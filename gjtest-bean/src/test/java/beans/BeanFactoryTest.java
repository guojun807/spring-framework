package beans;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import store.guojun.beans.MyTestBean;

@SuppressWarnings("deprecation")
public class BeanFactoryTest {
	@Test
	public void BeanFactoryTest1(){
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("application.xml"));
		MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
		System.out.println(myTestBean.getTestStr());
	}

	@Test
	public void BeanFactoryTest2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
		MyTestBean myTestBean = (MyTestBean)ac.getBean("myTestBean");
		System.out.println(myTestBean.getTestStr());
	}
}
