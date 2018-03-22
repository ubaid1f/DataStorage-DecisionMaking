# DataStorage-DecisionMaking
This module connects to the smart home network and collects the activated sensor information. Then store this information along with the timestamp to a local database. Also, from the activity recognition application, it collects the information about the current activity of the user and store it in the local database along with the time stamp. Based on the collected information in a specific time frame, the decision-making process initiates and identify the best suitable time to remind a user about their medication.

i)	DBMain
This class connects with the smart home network and listen to the postgresql channel for the activated sensor information. And store the sensor information in a local SQL database for further decision making.
 
ii)	MainController
This class is the main body, which handles all the process from data storage to the decision-making. It contains multiple REST services, which collects the sensor information and activ-ity from the smart home and smart phone respectively, then send it to the local database. Based on the information stored in the local database, the rule-based decision-making pro-cess initiates and identify, whether it’s a good time to remind a user about the medication or not.

iii)	RestClient
This class generates a post request in Json format and send it to the corresponding url.

iv)	Activity
This is the entity class for activity, which hibernate will automatically translate into a table.

v)	ActivityRepository
This is the repository interface for activity. It contains abstract classes, which will be auto-matically implemented by Spring in a bean with the same name and functionality.
 
vi)	Application
This class makes the application executable.
 
vii)	ClockInterval
This class identifies the time interval for the reminding the patient about the medication.
 
viii)	Sensor
This is the entity class for the sensor, which hibernate will automatically translate into a ta-ble.

ix)	SensorRepository
This is the repository interface for sensor. It contains abstract classes, which will be automatical-ly implemented by Spring in a bean with the same name and functionality.
