package hu.office.model.service.data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import hu.office.model.domain.Appointment;

public class AppointmentParser implements DataParser<Appointment> {

	@Override
	public List<Appointment> parse(List<String> lines) {
		return lines.stream().map(this::createAppointment).collect(Collectors.toList());
	}
	
	private Appointment createAppointment(String line) {
		String[] items = line.split(" ");
		String teacherName = items[0] + " " + items[1];
		LocalTime appointmentTime = TimeParser.parseTime(items[2]);
		LocalDateTime reservationTime = TimeParser.parseDateTime(items[3]);
		return new Appointment(teacherName, appointmentTime, reservationTime);
	}
}
