package jdbc_maven_eb9_user_database;

public class User {

	private int id;
	private String name;
	private String email;
	private String password;
	private String address;

	private String facebookpwd;
	private String instagrampwd;
	private String snapchatpwd;
	private String zomatopwd;
	private String twitterpwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFacebookpwd() {
		return facebookpwd;
	}

	public void setFacebookpwd(String facebookpwd) {
		this.facebookpwd = facebookpwd;
	}

	public String getInstagrampwd() {
		return instagrampwd;
	}

	public void setInstagrampwd(String instagrampwd) {
		this.instagrampwd = instagrampwd;
	}

	public String getSnapchatpwd() {
		return snapchatpwd;
	}

	public void setSnapchatpwd(String snapchatpwd) {
		this.snapchatpwd = snapchatpwd;
	}

	public String getZomatopwd() {
		return zomatopwd;
	}

	public void setZomatopwd(String zomatopwd) {
		this.zomatopwd = zomatopwd;
	}

	public String getTwitterpwd() {
		return twitterpwd;
	}

	public void setTwitterpwd(String twitterpwd) {
		this.twitterpwd = twitterpwd;
	}

}
