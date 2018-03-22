package hello;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor, Long> {
	public List <Sensor> findByname(String name);
	public Sensor findFirst1ByNameOrderByIdDesc(String name);
	public List <Sensor> findByTimeBetween(Timestamp start, Timestamp end);

}
