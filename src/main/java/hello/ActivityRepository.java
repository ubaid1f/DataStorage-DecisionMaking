package hello;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
	public List <Activity>  findByname(String name);
	public Activity findFirst1ByNameOrderByIdDesc(String name);
	
	
	public List <Activity> findByTimeBetween(int start, int end);
	public List <Activity> findByTimeBetween(Timestamp start, Timestamp end);
	public List <Activity>  findByactivity(String activity);
	public Activity findFirst1ByActivityOrderByIdDesc(String activity);
	
	public Activity findFirst1ByActivityOrderByIdDesc(List <Activity> activity);
}
