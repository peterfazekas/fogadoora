package hu.office;

import java.util.Scanner;

import hu.office.controller.AppointmentFacade;
import hu.office.model.domain.Appointment;
import hu.office.model.service.data.AppointmentParser;
import hu.office.model.service.data.Console;
import hu.office.model.service.data.DataApi;
import hu.office.model.service.data.DataParser;
import hu.office.model.service.data.DataReader;
import hu.office.model.service.data.FileDataReader;
import hu.office.model.service.data.ResultWriter;
import hu.office.model.service.data.TeacherAppointmentService;
import hu.office.view.Result;

public class App {

	private final Result result; 
	
	public App() {
		ResultWriter resultWriter = new ResultWriter();
		DataReader reader = new FileDataReader();
		DataParser<Appointment> parser = new AppointmentParser();
		DataApi<Appointment> data = new DataApi<>(reader, parser);
		AppointmentFacade facade = new AppointmentFacade(data.getData("appointments.txt"), resultWriter, new TeacherAppointmentService());
		Console console = new Console(new Scanner(System.in));
		result = new Result(facade, console);
	}

	public static void main(String[] args) {
		new App().run();
	}
	
	private void run() {
		result.printAll();
	}

}
