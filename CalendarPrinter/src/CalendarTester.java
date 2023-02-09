/*
 * Alexander Francis Hertadi
 * 9079930070
 * netID : hertadi
 */
public class CalendarTester {
	public static boolean testGetCentury() {
		if(CalendarPrinter.getCentury("2") != 0) return false;
		if(CalendarPrinter.getCentury("2019") != 20) return false;
		if(CalendarPrinter.getCentury("44444") != 444) return false;
		return true;
	}
	
	public static boolean testGetYearWithinCentury() {
		if(CalendarPrinter.getYearWithinCentury("2") != 2) return false;
		if(CalendarPrinter.getYearWithinCentury("2019") != 19) return false;
		if(CalendarPrinter.getYearWithinCentury("44444") != 44) return false;
		if(CalendarPrinter.getYearWithinCentury("2013") != 13) return false;
		return true;
	}
	
	public static boolean testGetIsLeapYear() {
		if(CalendarPrinter.getIsLeapYear("2") != false) return false;
		if(CalendarPrinter.getIsLeapYear("2016") != true) return false;
		if(CalendarPrinter.getIsLeapYear("2000") != true) return false;
		if(CalendarPrinter.getIsLeapYear("2009") != false) return false;
		return true;
	}
	
	public static boolean testGetMonthIndex() {
		if(CalendarPrinter.getMonthIndex("febrururururururu") != 2) return false;
		if(CalendarPrinter.getMonthIndex("JANUARY") != 1) return false;
		if(CalendarPrinter.getMonthIndex("Dec") != 12) return false;
		if(CalendarPrinter.getMonthIndex("November") != 11) return false;
		return true;
	}
	
	public static boolean testGetNumberOfDaysInMonth() {
		if(CalendarPrinter.getNumberOfDaysInMonth("jan", "2019") != 31) return false;
		if(CalendarPrinter.getNumberOfDaysInMonth("june", "2017") != 30) return false;
		if(CalendarPrinter.getNumberOfDaysInMonth("feb", "2016") != 29) return false;
		if(CalendarPrinter.getNumberOfDaysInMonth("feb", "2015") != 28) return false;
		return true;
	}
	
	public static boolean testGetFirstDayOfWeekInMonth() {
		if(CalendarPrinter.getFirstDayOfWeekInMonth("jan", "2019") != 1) return false;
		if(CalendarPrinter.getFirstDayOfWeekInMonth("june", "2017") != 3) return false;
		if(CalendarPrinter.getFirstDayOfWeekInMonth("feb", "2016") != 0) return false;
		if(CalendarPrinter.getFirstDayOfWeekInMonth("feb", "2015") != 6) return false;
		return true;
	}
	
	public static boolean testGenerateCalendar() {
		String[][] tester = CalendarPrinter.generateCalendar("sep", "2019");
		if(!tester[0][1].equals("TUE")) return false;
		if(!tester[4][2].equals("18")) return false;
		if(!tester[3][3].equals("12")) return false;
		if(!tester[2][4].equals("6")) return false;
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(testGetCentury());
		System.out.println(testGetYearWithinCentury());
		System.out.println(testGetIsLeapYear());
		System.out.println(testGetMonthIndex());
		System.out.println(testGetNumberOfDaysInMonth());
		System.out.println(testGetFirstDayOfWeekInMonth());
		System.out.println(testGenerateCalendar());
	}
}
