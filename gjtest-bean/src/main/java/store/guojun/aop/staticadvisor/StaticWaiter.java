package store.guojun.aop.staticadvisor;

import store.guojun.aop.Waiter;

public class StaticWaiter implements Waiter {
	@Override
	public void greetTo(String name) throws Exception{
		System.out.println("greet "+name);
	}

	@Override
	public void serveTo(String name) throws Exception {
		System.out.println("serving "+name);
	}
}
