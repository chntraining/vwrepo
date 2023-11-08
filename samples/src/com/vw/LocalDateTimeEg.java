package com.vw;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeEg {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		System.out.println(today);

		LocalDate diwali = LocalDate.of(2023, 11, 12);
		System.out.println("Diwali " + diwali);

		LocalDate tomoDate = today.plusDays(1);
		LocalDate nextweek = today.plusWeeks(1);
		LocalDate nextMonth = today.plusMonths(1);
		LocalDate nextYear = today.plusYears(1);

		System.out.println(tomoDate);
		System.out.println(nextweek);
		System.out.println(nextMonth);
		System.out.println(nextYear);

		boolean isBefore = diwali.isBefore(today);
		boolean isAfter = diwali.isAfter(today);
		boolean isEqual = diwali.isEqual(today);

		System.out.println(isBefore);
		System.out.println(isAfter);
		System.out.println(isEqual);

		LocalTime timenow = LocalTime.now();
		System.out.println(timenow);

		LocalTime lunchTime = LocalTime.of(12, 45);
		System.out.println(lunchTime);

		LocalTime nextHour = timenow.plusHours(1);
		LocalTime next40Min = timenow.plusMinutes(40);

		System.out.println(nextHour);
		System.out.println(next40Min);

		System.out.println(lunchTime.isBefore(timenow));
		System.out.println(lunchTime.isAfter(timenow));

		LocalDate parsedDate = LocalDate.parse("2023-11-06");
		System.out.println(parsedDate);

		String mydate = parsedDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(mydate);
		
		System.out.println(today.getDayOfMonth());
		System.out.println(today.getMonthValue());
		System.out.println(today.getEra());
		System.out.println(today.getYear());
		
		LocalDate date1 = LocalDate.of(2023, 11, 07);
		LocalDate date2 = LocalDate.of(2023, 11, 14);
		Period period = Period.between(date1, date2);
		System.out.println(period);
		
		Duration dur = Duration.between(timenow, lunchTime);
		System.out.println(dur);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		System.out.println(ldt.toLocalDate());
		System.out.println(ldt.toLocalTime());
		
	}

}
