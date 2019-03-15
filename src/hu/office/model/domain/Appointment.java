package hu.office.model.domain;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Appointment {
	
	private final String teacherName;
	private final LocalTime appointmentTime;
	private final LocalDateTime reservationTime;
	
	public Appointment(String teacherName, LocalTime appointmentTime, LocalDateTime reservationTime) {
		this.teacherName = teacherName;
		this.appointmentTime = appointmentTime;
		this.reservationTime = reservationTime;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public LocalTime getAppontmentTime() {
		return appointmentTime;
	}

	public LocalDateTime getReservationTime() {
		return reservationTime;
	}
	
}
