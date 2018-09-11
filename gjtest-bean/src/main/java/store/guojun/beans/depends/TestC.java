package store.guojun.beans.depends;

public class TestC {
	private TestA testA;

	public TestC() {
	}

	public void c(){
		System.out.println("执行c方法");
		testA.a();
	}

	public TestC(TestA testA) {
		this.testA = testA;
	}

	public TestA getTestA() {
		return testA;
	}

	public void setTestA(TestA testA) {
		this.testA = testA;
	}
}
