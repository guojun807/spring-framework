package store.guojun.beans.lookup;

public abstract class GetUserBeanTest {
	public void showMe(){
		this.getBean().showMe();
	}

	public abstract User getBean();
}
