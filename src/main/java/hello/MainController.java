package hello;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)


public class MainController {
	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	private SensorRepository sensorRepository;

	@CrossOrigin
	@PostMapping(path = "/addActivity")
	public @ResponseBody String addNewActivity(@RequestBody Activity activity) {
		String action = "Activity Not Change!, already exist";
		Activity lastActivity = activityRepository.findFirst1ByNameOrderByIdDesc(activity.getName());
		if (lastActivity == null || !lastActivity.getActivity().equals(activity.getActivity())) {
			Timestamp ActivityTime = new Timestamp(System.currentTimeMillis());
			activity.setTime(ActivityTime);
			activityRepository.save(activity);
			action = "Activity Update";
		}

		return action;
	}

	@CrossOrigin
	@PostMapping(path = "/addSensor")
	public @ResponseBody String addNewSensor(@RequestBody Sensor sensor) {
		Timestamp SensorActiviationTime = new Timestamp(System.currentTimeMillis());
		sensor.setTime(SensorActiviationTime);
		sensorRepository.save(sensor);
		System.out.println("Sensor Repo add sensor info!");
		return "Sensor Added Successfully!";
	}

	@CrossOrigin
	@GetMapping(path="/CurrentActivityandActiveSensor")
	public @ResponseBody String CurrentActivityandActiveSensor (@RequestParam String name) {
		Activity CurrentActivity = activityRepository.findFirst1ByNameOrderByIdDesc(name);
		Sensor ActiveSensor = sensorRepository.findFirst1ByNameOrderByIdDesc(name);
		String IdentifiedActivity = CurrentActivity.getActivity();
		String IdentifiedActiveSensor = ActiveSensor.getSenID();
		String MedicationReminder = null;
		
		if (IdentifiedActiveSensor.matches("^[19BA,Larm]+$"))
		{
			IdentifiedActiveSensor = "Living Room";
		}
		else if (IdentifiedActiveSensor.matches("^[3DE0,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "In Bed";
		}
		else if (IdentifiedActiveSensor.matches("^[3DE0,Klar]+$"))
		{
			IdentifiedActiveSensor = "In Bed";
		}
		else if (IdentifiedActiveSensor.matches("^[3DE5,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Bathroom Door";
		}
		else if (IdentifiedActiveSensor.matches("^[3DE5,Klar]+$"))
		{
			IdentifiedActiveSensor = "Bathroom Door";
		}
		else if (IdentifiedActiveSensor.matches("^[3D7F,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Bedroom Door";
		}
		else if (IdentifiedActiveSensor.matches("^[3D7F,Klar]+$"))
		{
			IdentifiedActiveSensor = "Bedroom Door";
		}
		else if (IdentifiedActiveSensor.matches("^[3DF9,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Fridge";
		}
		else if (IdentifiedActiveSensor.matches("^[3DF9,Klar]+$"))
		{
			IdentifiedActiveSensor = "Fridge";
		}
		else if (IdentifiedActiveSensor.matches("^[3E23,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Cups Cabinet";
		}
		else if (IdentifiedActiveSensor.matches("^[3E23,Klar]+$"))
		{
			IdentifiedActiveSensor = "Cups Cabinet";
		}
		else if (IdentifiedActiveSensor.matches("^[1B98,Larm]+$"))
		{
			IdentifiedActiveSensor = "Movement in Office";
		}
		else if (IdentifiedActiveSensor.matches("^[1A67,Larm]+$"))
		{
			IdentifiedActiveSensor = "Movement in Bathroom";
		}
		else if (IdentifiedActiveSensor.matches("^[1A2D,Larm]+$"))
		{
			IdentifiedActiveSensor = "Movement in Bedroom";
		}
		else if (IdentifiedActiveSensor.matches("^[1A8F,Larm]+$"))
		{
			IdentifiedActiveSensor = "Movement in Kitchen";
		}
		else if (IdentifiedActiveSensor.matches("^[3E0B,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Cutlery Drawer";
		}
		else if (IdentifiedActiveSensor.matches("^[3E0B,Klar]+$"))
		{
			IdentifiedActiveSensor = "Cutlery Drawer";
		}
		else if (IdentifiedActiveSensor.matches("^[3D8D,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Bowls Drawer";
		}
		else if (IdentifiedActiveSensor.matches("^[3D8D,Klar]+$"))
		{
			IdentifiedActiveSensor = "Bowls Drawer";
		}
		else if (IdentifiedActiveSensor.matches("^[3DFB,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Seasoning Cabinet";
		}
		else if (IdentifiedActiveSensor.matches("^[3DFB,Klar]+$"))
		{
			IdentifiedActiveSensor = "Seasoning Cabinet";
		}
		else if (IdentifiedActiveSensor.matches("^[3DA9,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Plates Cabinet";
		}
		else if (IdentifiedActiveSensor.matches("^[3DA9,Klar]+$"))
		{
			IdentifiedActiveSensor = "Plates Cabinet";
		}
		else if (IdentifiedActiveSensor.matches("^[3DD3,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Washer";
		}
		else if (IdentifiedActiveSensor.matches("^[3DD3,Klar]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Washer";
		}
		else if (IdentifiedActiveSensor.matches("^[3D7D,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Trashcan";
		}
		else if (IdentifiedActiveSensor.matches("^[3D7D,Klar]+$"))
		{
			IdentifiedActiveSensor = "Trashcan";
		}
		else if (IdentifiedActiveSensor.matches("^[3DC9,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Microwave";
		}
		else if (IdentifiedActiveSensor.matches("^[3DC9,Klar]+$"))
		{
			IdentifiedActiveSensor = "Microwave";
		}
		else if (IdentifiedActiveSensor.matches("^[3E1D,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Graden Door";
		}
		else if (IdentifiedActiveSensor.matches("^[3E1D,Klar]+$"))
		{
			IdentifiedActiveSensor = "Graden Door";
		}
		else if (IdentifiedActiveSensor.matches("^[3D6B,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Bedroom Dressier";
		}
		else if (IdentifiedActiveSensor.matches("^[3D6B,Klar]+$"))
		{
			IdentifiedActiveSensor = "Bedroom Dressier";
		}
		else if (IdentifiedActiveSensor.matches("^[3E1B,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Bed Side Table";
		}
		else if (IdentifiedActiveSensor.matches("^[3E1B,Klar]+$"))
		{
			IdentifiedActiveSensor = "Bed Side Table";
		}
		else if (IdentifiedActiveSensor.matches("^[3DCD,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Bedroom Cabinet Drawer";
		}
		else if (IdentifiedActiveSensor.matches("^[3DCD,Klar]+$"))
		{
			IdentifiedActiveSensor = "Bedroom Cabinet Drawer";
		}
		else if (IdentifiedActiveSensor.matches("^[3D72,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Office Chair A";
		}
		else if (IdentifiedActiveSensor.matches("^[3D72,Klar]+$"))
		{
			IdentifiedActiveSensor = "Office Chair A";
		}
		else if (IdentifiedActiveSensor.matches("^[34B0,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Office Chair B";
		}
		else if (IdentifiedActiveSensor.matches("^[34B0,Klar]+$"))
		{
			IdentifiedActiveSensor = "Office Chair B";
		}
		else if (IdentifiedActiveSensor.matches("^[3D92,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Chair A";
		}
		else if (IdentifiedActiveSensor.matches("^[3D92,Klar]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Chair A";
		}
		else if (IdentifiedActiveSensor.matches("^[3D86,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Chair B";
		}
		else if (IdentifiedActiveSensor.matches("^[3D86,Klar]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Chair B";
		}
		else if (IdentifiedActiveSensor.matches("^[3E06,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Chair C";
		}
		else if (IdentifiedActiveSensor.matches("^[3E06,Klar]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Chair C";
		}
		else if (IdentifiedActiveSensor.matches("^[3D9E,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Chair D";
		}
		else if (IdentifiedActiveSensor.matches("^[3D9E,Klar]+$"))
		{
			IdentifiedActiveSensor = "Kitchen Chair D";
		}
		else if (IdentifiedActiveSensor.matches("^[3D78,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Footstool A";
		}
		else if (IdentifiedActiveSensor.matches("^[3D78,Klar]+$"))
		{
			IdentifiedActiveSensor = "Footstool A";
		}
		else if (IdentifiedActiveSensor.matches("^[3E28,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Footstool B";
		}
		else if (IdentifiedActiveSensor.matches("^[3E28,Klar]+$"))
		{
			IdentifiedActiveSensor = "Footstool B";
		}
		else if (IdentifiedActiveSensor.matches("^[3DB0,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Couch A";
		}
		else if (IdentifiedActiveSensor.matches("^[3DB0,Klar]+$"))
		{
			IdentifiedActiveSensor = "Couch A";
		}
		else if (IdentifiedActiveSensor.matches("^[3D7A,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Couch D";
		}
		else if (IdentifiedActiveSensor.matches("^[3D7A,Klar]+$"))
		{
			IdentifiedActiveSensor = "Couch D";
		}
		else if (IdentifiedActiveSensor.matches("^[3E0A,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Couch C";
		}
		else if (IdentifiedActiveSensor.matches("^[3E0A,Klar]+$"))
		{
			IdentifiedActiveSensor = "Couch C";
		}
		else if (IdentifiedActiveSensor.matches("^[3DDE,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Couch B";
		}
		else if (IdentifiedActiveSensor.matches("^[3DDE,Klar]+$"))
		{
			IdentifiedActiveSensor = "Couch B";
		}
		else if (IdentifiedActiveSensor.matches("^[3D8A,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Couch E";
		}
		else if (IdentifiedActiveSensor.matches("^[3D8A,Klar]+$"))
		{
			IdentifiedActiveSensor = "Couch E";
		}
		else if (IdentifiedActiveSensor.matches("^[3D9A,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Couch F";
		}
		else if (IdentifiedActiveSensor.matches("^[3D9A,Klar]+$"))
		{
			IdentifiedActiveSensor = "Couch F";
		}
		else if (IdentifiedActiveSensor.matches("^[3D42,Närvaro]+$"))
		{
			IdentifiedActiveSensor = "Entrance Carpet";
		}
		else if (IdentifiedActiveSensor.matches("^[3D42,Klar]+$"))
		{
			IdentifiedActiveSensor = "Entrance Carpet";
		}
		else if (IdentifiedActiveSensor.matches("^[3DBF,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Front Door";
		}
		else if (IdentifiedActiveSensor.matches("^[3DBF,Klar]+$"))
		{
			IdentifiedActiveSensor = "Front Door";
		}
		else if (IdentifiedActiveSensor.matches("^[1A98,Larm]+$"))
		{
			IdentifiedActiveSensor = "Dinning Table";
		}
		else if (IdentifiedActiveSensor.matches("^[3DC3,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Bedroom Cabinet";
		}
		else if (IdentifiedActiveSensor.matches("^[3DC3,Klar]+$"))
		{
			IdentifiedActiveSensor = "Bedroom Cabinet";
		}
		else if (IdentifiedActiveSensor.matches("^[3D75,Dörrlarm]+$"))
		{
			IdentifiedActiveSensor = "Pans Drawer";
		}
		else if (IdentifiedActiveSensor.matches("^[3D75,Klar]+$"))
		{
			IdentifiedActiveSensor = "Pans Drawer";
		}
		
		MedicationReminder = CheckTimeforMedication(IdentifiedActivity, IdentifiedActiveSensor);
		
		return MedicationReminder;
	}
		
	public boolean MorningMedicationTime() {
		ClockInterval morning = ClockInterval.between(LocalTime.of(7, 30), LocalTime.of(8, 30));
		
		LocalTime now = LocalTime.now();

		if (morning.contains(now)) {
			return true;
		} 
		return false;
	}
	
	public boolean AfterNoonMedicationTime() {
		ClockInterval afternoon = ClockInterval.between(LocalTime.of(13, 30), LocalTime.of(14, 30));
	
		LocalTime now = LocalTime.now();

		 if (afternoon.contains(now)) {
			 return true;
			} 
			return false;
		}
	
	public boolean EveningMedicationTime() {
		ClockInterval evening = ClockInterval.between(LocalTime.of(18, 30), LocalTime.of(19, 30));

		LocalTime now = LocalTime.now();

		if (evening.contains(now)) {
			return true;
		} 
		return false;
	}
	
	public boolean MorningMedicationTimeExceed() {
		ClockInterval TimeExceed = ClockInterval.between(LocalTime.of(8, 30), LocalTime.of(8, 31));
		LocalTime now = LocalTime.now();
		if (TimeExceed.contains(now)) {
			return true;
		} 
		return false;
	}
		
	public boolean AfterNoonMedicationTimeExceed() {
		ClockInterval TimeExceed = ClockInterval.between(LocalTime.of(14, 30), LocalTime.of(14, 31));
		LocalTime now = LocalTime.now();
		if (TimeExceed.contains(now)) {
			return true;
		} 
		return false;
	}
	
	public boolean EveningMedicationTimeExceed() {
		ClockInterval TimeExceed = ClockInterval.between(LocalTime.of(19, 30), LocalTime.of(19, 31));
		LocalTime now = LocalTime.now();
		if (TimeExceed.contains(now)) {
			return true;
		} 
		return false;
	}
	
	public String CheckTimeforMedication(String IdentifiedActivity, String IdentifiedActiveSensor)
	{
		String MedicationReminder = null;
		
		if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("In Bed"))
	{
		MedicationReminder = "Patient Sit Down on the Bed";
		
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("In Bed") )
	{
		MedicationReminder = "Patient is Sleeping";
		
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Living Room") )
	{
		MedicationReminder = "Patient is Walking in the Living Room";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Living Room") )
	{
		MedicationReminder = "Patient is Standing in the Living Room";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Living Room") )
	{
		MedicationReminder = "Patient is Sitting in the Living Room";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Bathroom Door") )
	{
		MedicationReminder = "Patient is moving towards Bathroom door";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Bathroom Door") )
	{
		MedicationReminder = "Patient is planning to using Bathroom door";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Bathroom Door") )
	{
		MedicationReminder = "Patient is near to the Bathroom door";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Bathroom Door") )
	{
		MedicationReminder = "Patient is unconscious near Bathroom door";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Fridge") )
	{
		MedicationReminder = "Patient is using Fridge";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Fridge") )
	{
		MedicationReminder = "Patient is picking something from the Fridge";	
	}	
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Fridge") )
	{
		MedicationReminder = "Patient unconscious near Fridge";	
	}	
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Fridge") )
	{
		MedicationReminder = "Patient is moving around Fridge";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Bedroom Door") )
	{
		MedicationReminder = "Patient is using Bedroom";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Bedroom Door") )
	{
		MedicationReminder = "Patient is planning to using Bedroom";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Bedroom Door") )
	{
		MedicationReminder = "Patient is sitting in the Bedroom";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Bedroom Door") )
	{
		MedicationReminder = "Patient is Lie Down";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Cups Cabinet") )
	{
		MedicationReminder = "Patient unconscious near Cups Cabinet";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Cups Cabinet") )
	{
		MedicationReminder = "Patient is accessing the Cups Cabinet";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Cups Cabinet") )
	{
		MedicationReminder = "Patient is sitting near the Cups Cabinet";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Cups Cabinet") )
	{
		MedicationReminder = "Patient takes some steps near the Cups Cabinet";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Movement in Office") )
	{
		MedicationReminder = "Patient Lie Down in the Office";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Movement in Office") )
	{
		MedicationReminder = "Patient is Standing in the Office";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Movement in Office") )
	{
		MedicationReminder = "Patient is sitting in the office";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Movement in Office") )
	{
		MedicationReminder = "Patient moves in the Office";	
	}	
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Movement in Bathroom") )
	{
		MedicationReminder = "Patient is unconscious in the Bathroom";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Movement in Bathroom") )
	{
		MedicationReminder = "Patient is using the Bathroom";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Movement in Bathroom") )
	{
		MedicationReminder = "Patient is currently using the Bathroom";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Movement in Bathroom") )
	{
		MedicationReminder = "Patient moves in the Bathroom";	
	}	
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Movement in Bedroom") )
	{
		MedicationReminder = "Patient is sleeping";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Movement in Bedroom") )
	{
		MedicationReminder = "Patient is standing in the Bedroom";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Movement in Bedroom") )
	{
		MedicationReminder = "Patient is sitting in the Bedroom";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Movement in Bedroom") )
	{
		MedicationReminder = "Patient moves in the Bedroom";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Movement in Kitchen") )
	{
		MedicationReminder = "Patient is unconscious in the Kitchen";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Movement in Kitchen") )
	{
		MedicationReminder = "Patient is standing in the Kitchen";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Movement in Kitchen") )
	{
		MedicationReminder = "Patient is sitting in the Kitchen";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Movement in Kitchen") )
	{
		MedicationReminder = "Patient moves in the Kitchen";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Cutlery Drawer") )
	{
		MedicationReminder = "Patient is standing near Cutlery Drawer";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Cutlery Drawer") )
	{
		MedicationReminder = "Patient is sitting near Cutlery Drawer";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Cutlery Drawer") )
	{
		MedicationReminder = "Patient moves near Cutlery Drawer";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Bowls Drawer") )
	{
		MedicationReminder = "Patient is standing near Bowls Drawer";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Bowls Drawer") )
	{
		MedicationReminder = "Patient is sitting near Bowls Drawer";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Bowls Drawer") )
	{
		MedicationReminder = "Patient moves near Bowls Drawer";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Seasoning Cabinet") )
	{
		MedicationReminder = "Patient is standing near Seasoning Cabinet";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Seasoning Cabinet") )
	{
		MedicationReminder = "Patient is sitting near Seasoning Cabinet";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Seasoning Cabinet") )
	{
		MedicationReminder = "Patient moves near Seasoning Cabinet";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Plates Cabinet") )
	{
		MedicationReminder = "Patient is standing near Plates Cabinet";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Plates Cabinet") )
	{
		MedicationReminder = "Patient is sitting near Plates Cabinet";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Plates Cabinet") )
	{
		MedicationReminder = "Patient moves near Plates Cabinet";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Kitchen Washer") )
	{
		MedicationReminder = "Patient is standing near Kitchen Washer";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Kitchen Washer") )
	{
		MedicationReminder = "Patient is sitting near Kitchen Washer";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Kitchen Washer") )
	{
		MedicationReminder = "Patient take steps near Kitchen Washer";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Trashcan") )
	{
		MedicationReminder = "Patient is standing near Trashcan";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Trashcan") )
	{
		MedicationReminder = "Patient is sitting near Trashcan";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Trashcan") )
	{
		MedicationReminder = "Patient walking near Trashcan";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Microwave") )
	{
		MedicationReminder = "Patient is standing near Microwave";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Microwave") )
	{
		MedicationReminder = "Patient is sitting near Microwave";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Microwave") )
	{
		MedicationReminder = "Patient walking near Microwave";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Graden Door") )
	{
		MedicationReminder = "Patient is standing near Graden Door";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Graden Door") )
	{
		MedicationReminder = "Patient is sitting near Graden Door";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Graden Door") )
	{
		MedicationReminder = "Patient walking near Graden Door";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Bedroom Dressier") )
	{
		MedicationReminder = "Patient is standing near Bedroom Dressier";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Bedroom Dressier") )
	{
		MedicationReminder = "Patient is sitting near Bedroom Dressier";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Bedroom Dressier") )
	{
		MedicationReminder = "Patient is walking near Bedroom Dressier";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Bedroom Dressier") )
	{
		MedicationReminder = "Patient Lie Down near Bedroom Dressier";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Bed Side Table") )
	{
		MedicationReminder = "Patient is standing near Bed Side Table";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Bed Side Table") )
	{
		MedicationReminder = "Patient is sitting near Bed Side Table";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Bed Side Table") )
	{
		MedicationReminder = "Patient is walking near Bed Side Table";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Bed Side Table") )
	{
		MedicationReminder = "Patient Lie Down near Bed Side Table";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Bedroom Cabinet Drawer") )
	{
		MedicationReminder = "Patient is standing near Bedroom Cabinet Drawer";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Bedroom Cabinet Drawer") )
	{
		MedicationReminder = "Patient is sitting near Bedroom Cabinet Drawer";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Bedroom Cabinet Drawer") )
	{
		MedicationReminder = "Patient is walking near Bedroom Cabinet Drawer";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Bedroom Cabinet Drawer") )
	{
		MedicationReminder = "Patient Lie Down near Bedroom Cabinet Drawer";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Office Chair A") )
	{
		MedicationReminder = "Patient is standing near Office Chair A";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Office Chair A") )
	{
		MedicationReminder = "Patient is sitting on Office Chair A";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Office Chair A") )
	{
		MedicationReminder = "Patient is walking near Office Chair A";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Office Chair A") )
	{
		MedicationReminder = "Patient Lie Down on Office Chair A";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Office Chair B") )
	{
		MedicationReminder = "Patient is standing near Office Chair B";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Office Chair B") )
	{
		MedicationReminder = "Patient is sitting on Office Chair B";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Office Chair B") )
	{
		MedicationReminder = "Patient is walking near Office Chair B";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Office Chair B") )
	{
		MedicationReminder = "Patient Lie Down on Office Chair B";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Kitchen Chair A") )
	{
		MedicationReminder = "Patient is standing near Kitchen Chair A";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Kitchen Chair A") )
	{
		MedicationReminder = "Patient is sitting on Kitchen Chair A";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Kitchen Chair A") )
	{
		MedicationReminder = "Patient is walking near Kitchen Chair A";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Kitchen Chair A") )
	{
		MedicationReminder = "Patient Lie Down on Kitchen Chair A";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Kitchen Chair B") )
	{
		MedicationReminder = "Patient is standing near Kitchen Chair B";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Kitchen Chair B") )
	{
		MedicationReminder = "Patient is sitting on Kitchen Chair B";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Kitchen Chair B") )
	{
		MedicationReminder = "Patient is walking near Kitchen Chair B";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Kitchen Chair B") )
	{
		MedicationReminder = "Patient Lie Down on Kitchen Chair B";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Kitchen Chair C") )
	{
		MedicationReminder = "Patient is standing near Kitchen Chair C";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Kitchen Chair C") )
	{
		MedicationReminder = "Patient is sitting on Kitchen Chair C";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Kitchen Chair C") )
	{
		MedicationReminder = "Patient is walking near Kitchen Chair C";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Kitchen Chair C") )
	{
		MedicationReminder = "Patient Lie Down on Kitchen Chair C";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Kitchen Chair D") )
	{
		MedicationReminder = "Patient is standing near Kitchen Chair D";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Kitchen Chair D") )
	{
		MedicationReminder = "Patient is sitting on Kitchen Chair D";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Kitchen Chair D") )
	{
		MedicationReminder = "Patient is walking near Kitchen Chair D";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Kitchen Chair D") )
	{
		MedicationReminder = "Patient Lie Down on Kitchen Chair D";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Footstool A") )
	{
		MedicationReminder = "Patient is standing near Footstool A";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Footstool A") )
	{
		MedicationReminder = "Patient is sitting on Footstool A";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Footstool A") )
	{
		MedicationReminder = "Patient is walking near Footstool A";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Footstool A") )
	{
		MedicationReminder = "Patient Lie Down";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Footstool B") )
	{
		MedicationReminder = "Patient is standing near Footstool B";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Footstool B") )
	{
		MedicationReminder = "Patient is sitting on Footstool B";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Footstool B") )
	{
		MedicationReminder = "Patient is walking near Footstool B";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Footstool B") )
	{
		MedicationReminder = "Patient Lie Down";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Couch A") )
	{
		MedicationReminder = "Patient is standing near Couch A";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Couch A") )
	{
		MedicationReminder = "Patient is sitting on Couch A";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Couch A") )
	{
		MedicationReminder = "Patient is walking near Couch A";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Couch A") )
	{
		MedicationReminder = "Patient Lie Down on Couch A";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Couch D") )
	{
		MedicationReminder = "Patient is standing near Couch D";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Couch D") )
	{
		MedicationReminder = "Patient is sitting on Couch D";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Couch D") )
	{
		MedicationReminder = "Patient is walking near Couch D";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Couch D") )
	{
		MedicationReminder = "Patient Lie Down on Couch D";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Couch C") )
	{
		MedicationReminder = "Patient is standing near Couch C";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Couch C") )
	{
		MedicationReminder = "Patient is sitting on Couch C";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Couch C") )
	{
		MedicationReminder = "Patient is walking near Couch C";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Couch C") )
	{
		MedicationReminder = "Patient Lie Down on Couch C";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Couch B") )
	{
		MedicationReminder = "Patient is standing near Couch B";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Couch B") )
	{
		MedicationReminder = "Patient is sitting on Couch B";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Couch B") )
	{
		MedicationReminder = "Patient is walking near Couch B";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Couch B") )
	{
		MedicationReminder = "Patient Lie Down on Couch B";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Couch E") )
	{
		MedicationReminder = "Patient is standing near Couch E";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Couch E") )
	{
		MedicationReminder = "Patient is sitting on Couch E";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Couch E") )
	{
		MedicationReminder = "Patient is walking near Couch E";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Couch E") )
	{
		MedicationReminder = "Patient Lie Down on Couch E";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Couch F") )
	{
		MedicationReminder = "Patient is standing near Couch F";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Couch F") )
	{
		MedicationReminder = "Patient is sitting on Couch F";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Couch F") )
	{
		MedicationReminder = "Patient is walking near Couch F";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Couch F") )
	{
		MedicationReminder = "Patient Lie Down on Couch F";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Entrance Carpet") )
	{
		MedicationReminder = "Patient is standing on Entrance Carpet";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Entrance Carpet") )
	{
		MedicationReminder = "Patient is sitting near Entrance Carpet";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Entrance Carpet") )
	{
		MedicationReminder = "Patient take some steps on the Entrance Carpet";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Entrance Carpet") )
	{
		MedicationReminder = "Patient Lie Down near Entrance Carpet";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Front Door") )
	{
		MedicationReminder = "Patient is standing on the Front Door";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Front Door") )
	{
		MedicationReminder = "Patient is sitting near Front Door";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Front Door") )
	{
		MedicationReminder = "Patient is walking through the Front Door";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Front Door") )
	{
		MedicationReminder = "Patient Lie Down near Front Door";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Dinning Table") )
	{
		MedicationReminder = "Patient is standing near the Dinning Table ";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Dinning Table") )
	{
		MedicationReminder = "Patient is sitting near Dinning Table";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Dinning Table") )
	{
		MedicationReminder = "Patient is walking near Dinning Table";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Dinning Table") )
	{
		MedicationReminder = "Patient Lie Down near Dinning Table";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Bedroom Cabinet") )
	{
		MedicationReminder = "Patient is standing near Bedroom Cabinet";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Bedroom Cabinet") )
	{
		MedicationReminder = "Patient is sitting near Bedroom Cabinet";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Bedroom Cabinet") )
	{
		MedicationReminder = "Patient is walking near Bedroom Cabinet";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Bedroom Cabinet") )
	{
		MedicationReminder = "Patient Lie Down near Bedroom Cabinet";	
	}
	else if (IdentifiedActivity.equals("Stand") && IdentifiedActiveSensor.equals("Pans Drawer") )
	{
		MedicationReminder = "Patient is standing near Pans Drawer";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Pans Drawer") )
	{
		MedicationReminder = "Patient is sitting near Pans Drawer";	
	}
	else if (IdentifiedActivity.equals("Walk") && IdentifiedActiveSensor.equals("Pans Drawer") )
	{
		MedicationReminder = "Patient is walking near Pans Drawer";	
	}
	else if (IdentifiedActivity.equals("Lie") && IdentifiedActiveSensor.equals("Pans Drawer") )
	{
		MedicationReminder = "Patient Lie Down near Pans Drawer";	
	}
		////////////////For Reminding Medication Morning, Afternoon, and Evening
	if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Dinning Table") && MorningMedicationTime() )
	{
		MedicationReminder = "Good Morning! Please take your morning medication :)";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Dinning Table") && AfterNoonMedicationTime() )
	{
		MedicationReminder = "Good Afternoon! Please take your afternoon medication :)";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Dinning Table") && EveningMedicationTime() )
	{
		MedicationReminder = "Good Evening! Please take your evening medication :)";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Dinning Table") && MorningMedicationTimeExceed() )
	{
		MedicationReminder = "Good Morning! Please take your morning medication :)";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Dinning Table") && AfterNoonMedicationTimeExceed() )
	{
		MedicationReminder = "Good Afternoon! Please take your afternoon medication :)";	
	}
	else if (IdentifiedActivity.equals("Sit") && IdentifiedActiveSensor.equals("Dinning Table") && EveningMedicationTimeExceed() )
	{
		MedicationReminder = "Good Evening! Please take your evening medication :)";	
	}
	
	return MedicationReminder;
}

	
	@CrossOrigin
	@PostMapping(path = "/CurrentActivity")
	public @ResponseBody Activity CurrentActivity(@RequestBody Activity activity) {
		return activityRepository.findFirst1ByNameOrderByIdDesc(activity.getName());
	}
	
	@CrossOrigin
	@PostMapping(path = "/CurrentSensorActive")
	public @ResponseBody Sensor CurrentSensorActive(@RequestBody Sensor sensor) {
		return sensorRepository.findFirst1ByNameOrderByIdDesc(sensor.getName());
	}
	
	@CrossOrigin
	@GetMapping(path = "/AllActivitiesInTimePeriod")
	public @ResponseBody Iterable<Activity> getAllActivityInfo(@RequestParam Timestamp start, @RequestParam Timestamp end){
		return activityRepository.findByTimeBetween(start, end);
	}
	
	@CrossOrigin
	@GetMapping(path = "/AllActiveSensorInTimePeriod")
	public @ResponseBody Iterable<Sensor> getAllActiveSensorInfo(@RequestParam Timestamp start, @RequestParam Timestamp end){
		return sensorRepository.findByTimeBetween(start, end);
	}

	@CrossOrigin
	@GetMapping(path = "/allActivityBetween")
	public @ResponseBody Iterable<Activity> getAllActivityBetween(@RequestParam int start, @RequestParam int end) {
		List<Activity> activities = activityRepository.findByTimeBetween(start, end);
		return activityRepository.findByTimeBetween(start, end);

	}

	@CrossOrigin
	@GetMapping(path = "/allActivity")
	public @ResponseBody Iterable<Activity> getAllActivity() {
		return activityRepository.findAll();
	}

	@CrossOrigin
	@GetMapping(path = "/allSensor")
	public @ResponseBody Iterable<Sensor> getAllSensor() {
		return sensorRepository.findAll();
	}

}