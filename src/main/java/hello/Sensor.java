package hello;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Sensor {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	@NotNull
	private String name;

	private Timestamp time;

	private String senID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getSenID() {
		return senID;
	}

	public void setSenID(String senID) {
		this.senID = senID;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", name=" + name + ", time=" + time + ", senID=" + senID + "]";
	}

	
	
	
	

}
