package com.CoreJava.JavaFeatures;

public class EnumExample {

	enum Day {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	public static void main(String[] args) {

		for (Day day : Day.values()) {
			System.out.println(day);
		}

		Day today = Day.SUNDAY;
		switch (today) {
		case MONDAY:
			System.out.println("Start of work week");
			break;

		case FRIDAY:
			System.out.println("End of work week");
			break;

		case SUNDAY:
			System.out.println("It is weekend");
			break;

		default:
			System.out.println("It is middle of week");
			break;
		}
	}
}
