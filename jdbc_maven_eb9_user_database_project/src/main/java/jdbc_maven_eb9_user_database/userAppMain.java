package jdbc_maven_eb9_user_database;

import java.awt.Choice;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import javax.security.auth.login.LoginContext;

public class userAppMain {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		boolean repeat = true;

		User users = new User();
		UserAPP userAPp = new UserAPP();

		do {

			System.out.println(" 1.signUp \n 2.login \n 3.exit");
			System.out.println("enter your choice ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("enter the id");
				int id = scanner.nextInt();

				System.out.println("enter the username");
				String userName = scanner.next();

				System.out.println("enter the email");
				String email = scanner.next();

				System.out.println("enter the password");
				String password = scanner.next();

				System.out.println("enter the address");
				String address = scanner.next();

				users.setId(id);
				users.setName(userName);
				users.setEmail(email);
				users.setPassword(password);
				users.setAddress(address);

				userAPp.saveUsers(users);
				break;
			}

			case 2: {

				do {
					System.out.println("Choose your option to login");
					System.out.println(" 1.Facebook \n 2.Instagram \n 3.Snapchat \n 4.zomato \n 5.Twitter");
					System.out.println("enter your choice ");
					int choice1 = scanner.nextInt();
					switch (choice1) {
					case 1: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved = userAPp.loginUsers(users);

						if (saved == true) {

							System.out.println("logged in successfully");
							User user = userAPp.getUsers(email);
							System.out.println(user.getFacebookpwd());
							String faceBookpassword = users.getFacebookpwd();
							if (faceBookpassword == null) {
								System.out.println("Facebook password " + user.getFacebookpwd());
								System.out.println("Please update your Facebook password");
								String facebookPassword = scanner.next();
								userAPp.FbPassword(facebookPassword, email);
							} else {
								System.out.println("Please enter Facebook password");
								String facebookPwd = scanner.next();
								userAPp.FbPassword(facebookPwd, email);
							}
						}
						break;
					}

					case 2: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved1 = userAPp.loginUsers(users);

						if (saved1 == true) {
							System.out.println("logged in successfully");
							User user = userAPp.getUsers(email);
							System.out.println(user.getInstagrampwd());
							String instapassword = users.getInstagrampwd();
							if (instapassword == null) {
								System.out.println("Insta password " + user.getInstagrampwd());
								System.out.println("Please update your Insta password");
								String instaPassword = scanner.next();
								userAPp.InstaPassword(instaPassword, email);
							} else {
								System.out.println("Please enter Insta password");
								String instaPassword = scanner.next();
								userAPp.InstaPassword(instaPassword, email);
							}
						}
						break;
					}

					case 3: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved2 = userAPp.loginUsers(users);

						if (saved2 == true) {
							System.out.println("logged in successfully");
							User user = userAPp.getUsers(email);
							System.out.println(user.getSnapchatpwd());
							String snapchatpassword = users.getSnapchatpwd();

							if (snapchatpassword == null) {
								System.out.println("Insta password " + user.getSnapchatpwd());
								System.out.println("Please update your SnapChat password");
								String snapchatPassword = scanner.next();
								userAPp.SnapchatPassword(snapchatPassword, email);
							} else {
								System.out.println("Please enter snapchat password");
								String snapchatPassword = scanner.next();
								userAPp.SnapchatPassword(snapchatPassword, email);
							}
						}
						break;
					}

					case 4: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved2 = userAPp.loginUsers(users);

						if (saved2 == true) {

							System.out.println("logged in successfully");
							User user = userAPp.getUsers(email);

							System.out.println(user.getZomatopwd());
							String zompatopwdString = users.getZomatopwd();

							if (zompatopwdString == null) {
								System.out.println("zomatopwd " + user.getZomatopwd());
								System.out.println("Please update your zomatopwd password");
								String watsappPassword = scanner.next();
								userAPp.resetzomatopwd(zompatopwdString, email);
							} else {
								System.out.println("Please enter zomatopwd password");
								String watsappPassword = scanner.next();
								userAPp.resetzomatopwd(watsappPassword, email);
							}
						}

						break;
					}
					case 5: {
						System.out.println("enter the email");
						String email = scanner.next();

						System.out.println("enter the password");
						String password = scanner.next();

						users.setEmail(email);
						users.setPassword(password);

						boolean saved2 = userAPp.loginUsers(users);

						if (saved2 == true) {
							System.out.println("logged in successfully");
							User user = userAPp.getUsers(email);
							System.out.println(user.getTwitterpwd());
							String twiterpassword = users.getTwitterpwd();
							if (twiterpassword == null) {
								System.out.println("twiter password " + user.getTwitterpwd());
								System.out.println("Please update your twiter password");
								String twiterPassword = scanner.next();
								userAPp.resetTwiter(twiterPassword, email);
							} else {
								System.out.println("Please enter watsapp password");
								String twiterPassword = scanner.next();
								userAPp.resetTwiter(twiterPassword, email);
							}
						}
					}

					}
				} while (repeat);
			}
			}
		} while (repeat);
	}
}
