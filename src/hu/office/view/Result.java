package hu.office.view;

import hu.office.controller.AppointmentFacade;
import hu.office.model.service.data.Console;

public class Result {
	
	private final AppointmentFacade facade;
	private final Console console;

	public Result(AppointmentFacade facade, Console console) {
		this.facade = facade;
		this.console = console;
	}


	public void printAll() {
		System.out.println("Exercise 2: Number of Appointments: " + facade.getAppointmentCount());
		String name = console.read("Exercise 3: Enter a name: ");
		System.out.println(facade.getTeachersAppointment(name));
		String time = console.read("Exercise 4: Enter a valid time (e.g. 17:10): ");
		System.out.println(facade.getTeachersNameByAppointmentTime(time));
		System.out.println("Exercise 5: " + facade.getEarliestAppointmentDetails());
		System.out.println("Exercise 6: \r\n" + facade.getTeacherAppointmentDetails("Barna Eszter"));
	}

}
