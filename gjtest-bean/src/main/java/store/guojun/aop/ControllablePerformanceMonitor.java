package store.guojun.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable{
	private ThreadLocal<Boolean> threadLocal = new ThreadLocal<Boolean>();

	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		Object obj;
		if(threadLocal != null && threadLocal.get() != null && threadLocal.get() ){
			PerformanceMonitor.begin(mi.getClass().getName()+"."+mi.getMethod());
			obj = super.invoke(mi);
			PerformanceMonitor.end(mi.getClass().getName()+"."+mi.getMethod());
		}else {
			obj = super.invoke(mi);
		}



		return obj;
	}

	@Override
	public void setMonitorableActive(boolean active) {
		threadLocal.set(active);
	}
}
