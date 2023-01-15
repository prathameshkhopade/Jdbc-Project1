package jdbc_maven_eb9_user_database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;

public class UserAPP {

	public static Connection getConnection() throws Exception {

		Driver driver = new Driver();

		DriverManager.registerDriver(driver);

		FileInputStream fileInputStream = new FileInputStream("dbuserconfig.properties");

		// create object of properties
		Properties properties = new Properties();

		properties.load(fileInputStream);

		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"), properties.getProperty("password"));
		return connection;

	}

	// for signUp
	public void saveUsers(User users) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userinput VALUES(?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, users.getId());
		preparedStatement.setString(2, users.getName());
		preparedStatement.setString(3, users.getEmail());
		preparedStatement.setString(4, users.getPassword());
		preparedStatement.setString(5, users.getAddress());
		preparedStatement.setString(6, users.getFacebookpwd());
		preparedStatement.setString(7, users.getInstagrampwd());
		preparedStatement.setString(8, users.getSnapchatpwd());
		preparedStatement.setString(9, users.getZomatopwd());
		preparedStatement.setString(10, users.getTwitterpwd());
		preparedStatement.execute();
		connection.close();
		System.out.println("signed in successfully");

	}

	public boolean loginUsers(User users) throws Exception {
		String query = "select * from userinput where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, users.getEmail());

		ResultSet resultSet = preparedStatement.executeQuery();
		String password = null;
		String email=null;
		while (resultSet.next()) {
			password = resultSet.getString("password");
		}
		if (users.getPassword().equals(password) && users.getEmail().equals(email)) {
			return true;
		}
		return false;

	}

	public void FbPassword(String facebookPwd, String email) throws Exception {
		String query = "update userinput set facebookPwd=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, facebookPwd);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public void InstaPassword(String instagrampwd, String email) throws Exception {
		String query = "update userinput set instagramPwd=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, instagrampwd);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public void SnapchatPassword(String snapchatPwd, String email) throws Exception {
		String query = "update userinput set snapchatPwd=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, snapchatPwd);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public void resetzomatopwd(String zomatopwd, String email) throws Exception {
		String query = "update userinput set zomatopwd=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, zomatopwd);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public void resetTwiter(String twiterpwd, String email) throws Exception {
		String query = "update userinput set twitterPwd=? where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, twiterpwd);
		preparedStatement.setString(2, email);
		preparedStatement.execute();
		connection.close();
	}

	public User getUsers(String email) throws Exception {
		String query = "select * from userinput where email=?";
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		User myUser = new User();
		while (resultSet.next()) {
			myUser.setId(resultSet.getInt(1));
			myUser.setName(query);
			myUser.setEmail(resultSet.getString(3));
			myUser.setPassword(resultSet.getString(4));
			myUser.setAddress(resultSet.getString(5));
			myUser.setFacebookpwd(resultSet.getString(6));
			myUser.setInstagrampwd(resultSet.getString(7));
			myUser.setSnapchatpwd(resultSet.getString(8));
			myUser.setZomatopwd(resultSet.getString(9));
			myUser.setTwitterpwd(resultSet.getString(10));

		}
		return myUser;

	}
}
