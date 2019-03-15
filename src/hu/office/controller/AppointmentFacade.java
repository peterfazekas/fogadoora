package hu.office.controller;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import hu.office.model.domain.Appointment;
import hu.office.model.service.data.ResultWriter;
import hu.office.model.service.data.TeacherAppointmentService;
import hu.office.model.service.data.TimeParser;

public class AppointmentFacade {

	private final List<Appointment> appointments;
	private final ResultWriter resultWriter;
	private final TeacherAppointmentService teacherAppointmentService;

	public AppointmentFacade(List<Appointment> appointments, ResultWriter resultWriter,
			TeacherAppointmentService teacherAppointmentService) {
		this.appointments = appointments;
		this.resultWriter = resultWriter;
		this.teacherAppointmentService = teacherAppointmentService;
	}

	public int getAppointmentCount() {
		return appointments.size();
	}

	public String getTeachersAppointment(String name) {
		long count = getTeachersAppointmentCount(name);
		return count == 0 ? "No appointments for the given name"
				: String.format("%d appointment(s) for %s", count, name);
	}

	private long getTeachersAppointmentCount(String name) {
		return appointments.stream().filter(i -> i.getTeacherName().toLowerCase().equals(name.toLowerCase())).count();
	}

	public String getTeachersNameByAppointmentTime(String time) {
		LocalTime localTime = TimeParser.parseTime(time);
		String fileName = time.replace(":", "");
		return resultWriter.print(fileName, getTeachersNameByAppointmentTime(localTime));
	}

	private String getTeachersNameByAppointmentTime(LocalTime time) {
		return appointments.stream().filter(i -> i.getAppontmentTime().equals(time)).map(i -> i.getTeacherName())
				.sorted().collect(Collectors.joining("\r\n"));
	}

	public String getEarliestAppointmentDetails() {
		Appointment appointment = getEarliestReservationDateTime();
		return String.format("%nTeacher's name: %s%nAppointment: %s%nTime of reservation: %s",
				appointment.getTeacherName(), appointment.getAppontmentTime(),
				appointment.getReservationTime().format(TimeParser.DATE_FORMATTER));
	}

	private Appointment getEarliestReservationDateTime() {
		return appointments.stream().sorted((i, j) -> i.getReservationTime().compareTo(j.getReservationTime()))
				.findFirst().get();
	}

	public String getTeacherAppointmentDetails(String teacherName) {
		return teacherAppointmentService.getResult(getAppointmentsByName(teacherName));
	}

	private List<Appointment> getAppointmentsByName(String name) {
		return appointments.stream().filter(i -> i.getTeacherName().toLowerCase().equals(name.toLowerCase())).collect(Collectors.toList());
	}

}
