package com.java8Features.DateTime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIExample {

	public static void main(String[] args) {

		LocalDate currentDate = LocalDate.now();
		System.out.println("Current Date " + currentDate);

		LocalTime currentTime = LocalTime.now();
		System.out.println("Current time " + currentTime);

		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("current date and time " + currentDateTime);

		// format current date and time
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String dateFormat = currentDateTime.format(datePattern);
		System.out.println("dateFormat ==>" + dateFormat);

		// String to date
		String dateString = "29-03-1991";
		DateTimeFormatter stringDatePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(dateString, stringDatePattern);
		System.out.println(localDate);
		
		//ZonedDateTime
		ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("Americas time "+now);
		
		//difference between two dates
		LocalDate birthDate=LocalDate.of(1991, Month.MARCH, 29);
		LocalDate curentdate=LocalDate.now();
		Period between = Period.between(birthDate, curentdate);
		System.out.println(between.getYears() +" ==> "+ between.getMonths()+" ==> "+ between.getDays());
		
		//difference in time duration
		
		LocalTime time1= LocalTime.of(17, 58);
		LocalTime time2= LocalTime.of(7, 47);
		Duration duration = Duration.between(time2, time1);
		System.out.println(duration.toHours()+ " "+ duration.toMinutesPart());
		
		Instant timeInUtc=Instant.now();
		System.out.println(timeInUtc);
	}

}
