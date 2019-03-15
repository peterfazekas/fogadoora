package hu.office.model.service.data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeParser {

	public static final String TIME_PATTERN = "HH:mm";
	public static final String DATE_PATTERN = "yyyy.MM.dd-HH:mm";
	public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_PATTERN);
	public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	public static LocalTime parseTime(String time) {
		return LocalTime.parse(time, TIME_FORMATTER);
	}

	public static LocalDateTime parseDateTime(String dateTime) {
		return LocalDateTime.parse(dateTime, DATE_FORMATTER);
	}
}
