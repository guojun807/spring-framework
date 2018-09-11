package store.guojun.beans.depends;

public class TestA {
	private TestB testB;

	public TestA() {
	}

	public TestA(TestB testB) {
		this.testB = testB;
	}

	public void a(){
		System.out.println("执行a方法");
		testB.b();
	}

	public TestB getTestB() {
		return testB;
	}

	public void setTestB(TestB testB) {
		this.testB = testB;
	}
}
