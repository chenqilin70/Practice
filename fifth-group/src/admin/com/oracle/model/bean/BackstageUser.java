package admin.com.oracle.model.bean;

public class BackstageUser {
	private int userid;
	private String username;
	private String password;
	private String realname;
	private String email;
	private String sex;
	private int age;
	private int online;
	private int identityid;
	private String position;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public int getIdentityid() {
		return identityid;
	}
	public void setIdentityid(int identityid) {
		this.identityid = identityid;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public BackstageUser(int userid, String username, String password, String realname, String email, String sex,
			int age, int online, int identityid, String position) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.email = email;
		this.sex = sex;
		this.age = age;
		this.online = online;
		this.identityid = identityid;
		this.position = position;
	}
	public BackstageUser() {
		super();
	}
	@Override
	public String toString() {
		return "BackstageUser [userid=" + userid + ", username=" + username + ", password=" + password + ", realname="
				+ realname + ", email=" + email + ", sex=" + sex + ", age=" + age + ", online=" + online
				+ ", identityid=" + identityid + ", position=" + position + "]";
	}
	
	
}
