package store.guojun.aop;

public class NaiveWaiter implements Waiter {
	@Override
	public void greetTo(String name) throws Exception{
		System.out.println("greet "+name);
	}

	@Override
	public void serveTo(String name) throws Exception {
		System.out.println("serving "+name);
	}
}
