import java.util.Calendar;
import java.util.Date;

public class DateUtility {

	//returns (Mon)th / year or "invalid date"
	public static String displayCalendar(int month, int year){
		String monthString = null;
		switch(month){
			case 1 : monthString = "Jan"; break;
			case 2 : monthString = "Feb"; break;
			case 3 : monthString = "Mar"; break;
			case 4 : monthString = "Apr"; break;
			case 5 : monthString = "May"; break;
			case 6 : monthString = "Jun"; break;
			case 7 : monthString = "Jul"; break;
			case 8 : monthString = "Aug"; break;
			case 9 : monthString = "Sep"; break;
			case 10 : monthString = "Oct"; break;
			case 11 : monthString = "Nov"; break;
			case 12 : monthString = "Dec"; break;
		}
		if (monthString == null) return "invalid Month";
		return String.format("%s %d", monthString, year);
	}
	
	//takes day, month, year displays (mon)th day year or "invalid date"
	public static String displayCalendar(int day, int month, int year){
		String monthString = null;
		switch(month){
			case 1 : monthString = "Jan"; break;
			case 2 : monthString = "Feb"; break;
			case 3 : monthString = "Mar"; break;
			case 4 : monthString = "Apr"; break;
			case 5 : monthString = "May"; break;
			case 6 : monthString = "Jun"; break;
			case 7 : monthString = "Jul"; break;
			case 8 : monthString = "Aug"; break;
			case 9 : monthString = "Sep"; break;
			case 10 : monthString = "Oct"; break;
			case 11 : monthString = "Nov"; break;
			case 12 : monthString = "Dec"; break;
		}
		if (monthString == null || day < 1 || lastDayOfMonth(month, year) < day) return "invalid date";
		return String.format("%s %d %d", monthString, day, year);
	}
	
	//returns boolean if year enter is or isn't a leap year
	public static boolean isLeapYear(int year){
		boolean bLeapYear = false;
		bLeapYear = (year % 4 == 0);
		bLeapYear = bLeapYear && (year % 100 != 0);
		bLeapYear = bLeapYear || (year % 400 == 0);
		return bLeapYear;
	}
	
	//returns age in years, if invalid date is entered returns -1
	public static int age (int birthDay, int birthMonth, int birthYear) {
		Date today;
		Date fullBirthDay;
		boolean valid = true;
		if (birthDay < 1 || birthMonth < 1 || birthMonth > 12) valid = false;
		switch (birthMonth) {
			//if month has 31 days
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				if (birthDay > 31) valid = false;
			break;
			//if month has 30 days
			case 4: case 6: case 9: case 11:
				if (birthDay > 30) valid = false;
			break;
			//if month is feb
			case 2:
				//if year is a leap year
				if (isLeapYear(birthYear)) {
					if (birthDay > 29) valid = false;
				}
				else {
					if (birthDay > 28) valid = false;
				}
			break;
		}
		//make Date() object for birth day and today
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, birthYear);
		cal.set(Calendar.MONTH, birthMonth);
		cal.set(Calendar.DAY_OF_MONTH, birthDay);
		fullBirthDay = cal.getTime();
		today = new Date();
		//compare today and birthday
		if ((today.getTime() - fullBirthDay.getTime()) < 0) valid = false;
		long dif = (today.getTime() - fullBirthDay.getTime()) / 1000;
		long year = 31556952;
		dif = dif / year;
		if (valid) return (int)dif;
		else return (int)-1;
	}
	
	//takes first 3 letters of month, and a year and tells you the last day of the month. 
	//if invalid month is entered, -1 is returned.
	public static int lastDayOfMonth(String monthString, int year) {
		boolean valid = false;
		int monthNumber = 1000;
		monthString = monthString.toLowerCase();
		switch (monthString) {
			case "jan": case "feb": case "mar": case "apr": case "may": case "jun":
			case "jul": case "aug": case "sep": case "oct": case "nov": case "dec":
				valid = true;
			break;
		}
		switch (monthString) {
			case "jan": monthNumber = 31;break;
			case "feb": 
				if (isLeapYear(year)) monthNumber = 29;
				else monthNumber = 28;
				break;
			case "mar":monthNumber = 31; break;
			case "apr":monthNumber = 30; break;
			case "may":monthNumber = 31; break;
			case "jun":monthNumber = 30; break;
			case "jul":monthNumber = 31; break;
			case "aug":monthNumber = 31; break;
			case "sep":monthNumber = 30; break;
			case "oct":monthNumber = 31; break;
			case "nov":monthNumber = 30; break;
			case "dec":monthNumber = 31; break;
		}
		if (valid) return monthNumber;
		else return -1;
	}
	
	//overloaded to take int instead of string month value
	public static int lastDayOfMonth(int monthInt, int year) {
		String monthString = "";	
		switch (monthInt) {
			case 1:  monthString = "jan"; break;
			case 2:  monthString = "feb"; break;
			case 3:  monthString = "mar"; break;
			case 4:  monthString = "apr"; break;
			case 5:  monthString = "may"; break;
			case 6:  monthString = "jun"; break;
			case 7:  monthString = "jul"; break;
			case 8:  monthString = "aug"; break;
			case 9:  monthString = "sep"; break;
			case 10: monthString = "oct"; break;
			case 11: monthString = "nov"; break;
			case 12: monthString = "dec"; break;
		}
		return lastDayOfMonth(monthString, year);
	}

}