## JavaEE EJB - Schedule
Example of scheduled tasks with EJB. 

### Something about 
The class must be defined as a SessionBean. We are using the @Singleton for not create a pool in EJB Container.

The @Startup annotation defines the SessionBean must be started together to the EJB Container.

The method with @PostConstrut annotation is executed after the SessionBean is constructed.

The method that needs to execute as a Scheduled task should be annotated with @Schedule. In our example, this task is executed every 5 seconds. 

We defined persistence false for not saving the status of the scheduled task. With this configuration, we can execute all tasks that are not executed when the EJB container was off. 

```
@Singleton
@Startup
public class ScheduledTask {

  private SimpleDateFormat dateFormatter;

  @PostConstruct
  private void setup() {
    dateFormatter = new SimpleDateFormat("dd/MM/yy - HH:mm:ss");
  }

  @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
  private void execute() {
    System.out.println("[INFO] Executing scheduled task...");
    System.out.println("[INFO] Actual hour: " + dateFormatter.format(Calendar.getInstance().getTime()));
    System.out.println("[INFO] Schedule task has been executed.");
  }
}

```