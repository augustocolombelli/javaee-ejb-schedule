package br.com.tasks;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

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
