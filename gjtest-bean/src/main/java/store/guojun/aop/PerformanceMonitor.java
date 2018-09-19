package store.guojun.aop;

public class PerformanceMonitor {
	public static void begin(String str) {
		System.out.println("开始了");
		System.out.println(str);
	}

	public static void end(String str) {
		System.out.println("结束了");
	}
}
