package aop;

public class TestB extends TestA{
	private TestB testA;
	public void testa(){
		System.out.println("testa");
		testb();
	}
	public void testb(){
		System.out.println("testbb");
	}

	public static void main(String[] args) {
		TestB testB = new TestB();
//		testB.setTestA(testB);
		testB.testa();
	}
	
}
