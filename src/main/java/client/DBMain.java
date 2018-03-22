package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.Sensor;

public class DBMain {
	public void insertdata() throws Exception {
		// Settings for DB part
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://192.168.1.198/postgres";
		Properties props = new Properties();
		props.setProperty("user", "postgres");
		props.setProperty("password", "postgres");
		System.out.println("Listening for Activated Smart Home Sensor and Patient Activity ");
		Connection lConn = DriverManager.getConnection(url, props);

		// Run a thread for listening data from DB and sending it to Android
		Listener listener = new Listener(lConn);
		listener.start();
	}

}

// Listen from DB and send to Android
class Listener extends Thread {

	private Connection conn;
	private org.postgresql.PGConnection pgconn;
	Listener(Connection conn) throws SQLException {
		System.out.println("Listener is Listening");

		// Connect to DB channel and start to listen
		this.conn = conn;
		this.pgconn = (org.postgresql.PGConnection) conn;
		Statement stmt = conn.createStatement();
		stmt.execute("LISTEN SA3L_VIS");
		stmt.close();
	}

	public void run() {
		while (true) {
			try {
				org.postgresql.PGNotification notifications[] = pgconn.getNotifications();
				if (notifications != null) {
					String receivedFromDB = "";
					for (int i = 0; i < notifications.length; i++) {
						receivedFromDB += notifications[i].getParameter();
					}

					System.out.print("Sensor " + receivedFromDB + " Activated on ");
					System.out.println(new Timestamp(System.currentTimeMillis()));
					
					Sensor s = new Sensor();
					s.setSenID(receivedFromDB); // recieve from Infrastructure DB
					s.setName("Bob"); // Need to set the name for updation, Bob is Smart Phone user 
					//s.setName("Alice"); // Need to set the name for updation, Alice is Smart Watch user
					
					ObjectMapper m1 = new ObjectMapper();
					String post1 = m1.writeValueAsString(s);
					System.out.print("Here it is adding!");
					String url = "http://localhost:8080/demo/addSensor";
					RestClient.sendPostRequest(post1, url);
				}
				// wait a while before checking again for new notifications
				Thread.sleep(500);
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			} catch (Exception e) {

			}
		}
	}
}
