package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import client.DBMain;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        PersistData();
    }

    public static  void PersistData() {
        DBMain Data = new DBMain();
        try {

        Data.insertdata();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}