package store.guojun.aop;

public class NaiveErrorWaiter {
	public void greetTo(String name){
		System.out.println("greet "+name);
		throw new RuntimeException(name+"抛出异常");
	}

	public void serveTo(String name){
		System.out.println("serving "+name);
		throw new RuntimeException(name+"抛出异常");
	}
}
