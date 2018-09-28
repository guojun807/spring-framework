package aop;

public class TestA {
	private TestA testA;

	public void setTestA(TestA testA){
		this.testA = testA;
	}
	public void testa(){
		System.out.println("testa");
		testb();
	}
	public void testb(){
		System.out.println("testb");
	}
}
