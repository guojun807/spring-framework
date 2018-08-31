package store.guojun.beans.constructor;

public class HelloBean {
	private String name;
	private String address;
	private String enName;
	public HelloBean(String name) {
		this.name = name;
	}

	public HelloBean(String name, String address, String enName) {
		this.name = name;
		this.address = address;
		this.enName = enName;
	}

	@Override
	public String toString() {
		return "HelloBean{" +
				"name='" + name + '\'' +
				", address='" + address + '\'' +
				", enName='" + enName + '\'' +
				'}';
	}
}
