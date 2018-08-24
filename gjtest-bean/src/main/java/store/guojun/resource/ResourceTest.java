package store.guojun.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("application.xml");
		try {
			InputStream inputStream = resource.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
