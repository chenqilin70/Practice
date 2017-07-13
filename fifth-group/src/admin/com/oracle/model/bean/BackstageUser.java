package admin.com.oracle.model.bean;

public class BackstageUser {
	private String ID;
	private String username;
	private String password;
	private String realname;
	private String email;
	private String sex;
	private int age;
	private int identity;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	public BackstageUser(String iD, String username, String password, String realname, String email, String sex,
			int age, int identity) {
		super();
		ID = iD;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.email = email;
		this.sex = sex;
		this.age = age;
		this.identity = identity;
	}
	public BackstageUser() {
		super();
	}
	public String toString() {
		return "BackstageUser [ID=" + ID + ", username=" + username + ", password=" + password + ", realname="
				+ realname + ", email=" + email + ", sex=" + sex + ", age=" + age + ", identity=" + identity + "]";
	}
}
