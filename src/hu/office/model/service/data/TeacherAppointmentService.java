package hu.office.model.service.data;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import hu.office.model.domain.Appointment;

public class TeacherAppointmentService {

	private static final String[] APPOINTMENTS = {"16:00", "16:10", "16:20", "16:30", "16:40", "16:50",
												  "17:00", "17:10", "17:20", "17:30", "17:40", "17:50"};
	
	public String getResult(List<Appointment> appointmentList) {
		String times = printFreeAppointmentTimes(appointmentList);
		String name = appointmentList.get(0).getTeacherName();
		return String.format("%s%n%s can leave at %s at the earliest.", times, name, getLastAppointmentTime(appointmentList).plusMinutes(10));
	}
	
	private LocalTime getLastAppointmentTime(List<Appointment> appointmentList) {
		return appointmentList.stream().map(Appointment::getAppontmentTime).max(Comparator.naturalOrder()).get();
	}
	
	private String printFreeAppointmentTimes(List<Appointment> appointmentList) {
		return filterFreeAppointmentTime(appointmentList).stream().map(Object::toString).collect(Collectors.joining("\r\n"));
	}
	
	private List<LocalTime> filterFreeAppointmentTime(List<Appointment> appointmentList) {
		List<LocalTime> appointmentTimes = getAppointmentTimes();
		appointmentList.stream().map(Appointment::getAppontmentTime).forEach(i -> appointmentTimes.remove(i));
		return appointmentTimes;
	}
	
	private List<LocalTime> getAppointmentTimes() {
		return Arrays.stream(APPOINTMENTS).map(TimeParser::parseTime).collect(Collectors.toList());
	}
	
	
	
}
