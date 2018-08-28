package resource;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
@SuppressWarnings("deprecation")
public class ResourceTest {
	@Test
	public void resourceTest1() {
		Resource resource = new ClassPathResource("application.xml");
		InputStream inputStream = null;
		try {
			inputStream = resource.getInputStream();
			System.out.println("读取完成");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(inputStream != null){
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}
}
