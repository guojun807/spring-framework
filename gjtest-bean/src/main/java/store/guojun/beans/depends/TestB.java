package store.guojun.beans.depends;

public class TestB {
	private TestC testC;

	public TestB() {
	}

	public TestB(TestC testC) {
		this.testC = testC;
	}

	public void b(){
		System.out.println("执行b方法");
		testC.c();
	}

	public TestC getTestC() {
		return testC;
	}

	public void setTestC(TestC testC) {
		this.testC = testC;
	}
}
