/*
 * Alexander Francis Hertadi
 * 9079930070
 * netID : hertadi
 */
import java.util.*;
public class CalendarPrinter {
	private final static String[] DAYS_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	private final static String[] MONTHS_OF_YEAR = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	
	/**
	 * Calculates the number of centuries (rounded down) that is represented by
	 * the specified year (ie. the integer part of year/100).
	 * @param year to compute the century of (based on the Gregorian Calendar AD)
	 *   String must contain the digits of a single non-negative int  for year.
	 * @return number of centuries in the specified year
	 */
	public static int getCentury(String year){
		int x = Integer.parseInt(year);
		return x / 100;
	}
	
	/**
	 * Calculates the number of years between the specified year, and the first
	 * year in the specified year's century. This number is always between 0-99.
	 * @param year to compute the year within century of (Gregorian Calendar AD)
	 * 		String must contain the digits of a single non negative int for year.
	 * @return number of years since first year in the current century
	 */
	public static int getYearWithinCentury(String year) {
		int x = Integer.parseInt(year);
		return x % 100;
	}
	
	/**
	 * This method computes whether the specified year is a leap year
	 * @param args yearString is the year that is being checked for leap-year-ness
	 * 		String must contain the digits of a single non-negative int  for year.
	 * @return true when the specified year is a leap year, and false otherwise
	 */
	public static boolean getIsLeapYear(String yearString) {
		int x = Integer.parseInt(yearString);
		if(x % 4 != 0) {
			return false;
		} else if(x % 100 != 0) {
			return true;
		} else if(x % 400 != 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 *  Converts the name or abbreviation for any month into the index of that
	 *  month's abbreviation within MONTHS_OF_YEAR.  Matches the specified month
	 *  based only on the first three characters, and is case in-sensitive.
	 *  @param month which may or may not be abbreviated to 3 or more characters
	 *  @return the index within MONTHS_OF_YEAR that a match is found at
	 *  		and return -1, when no match is found
	 */
	public static int getMonthIndex(String month) {
		String monthAbv = month.substring(0, 3);
		for(int i = 0; i <= 11; i++) {
			if (monthAbv.equalsIgnoreCase(MONTHS_OF_YEAR[i])) {
				return i+1 ;
			}
		} 
		return 0 ;
	}
	
	/**
	 * Calculates the number of days in the specified month, while taking into
	 * consideration whether or not the specified year is a leap year.
	 * @param month which may or may not be abbreviated to 3 or more characters
	 * @param year of month that days are being counted for (Gregorian Calendar AD) 
	 * 		String must contain the digits of a single non-negative int for year.
	 * @return the number of days in the specified month (between 28-31) 
	 */
	public static int getNumberOfDaysInMonth(String month, String year) {
		int monthIndex = getMonthIndex(month);
		boolean isLeapYear = getIsLeapYear(year);
		if (monthIndex == 1||monthIndex == 3||monthIndex == 5||monthIndex == 7||monthIndex == 8||monthIndex == 10||monthIndex == 12) {
			return 31;
		} else if(monthIndex == 4||monthIndex == 6||monthIndex == 9||monthIndex == 11) {
			return 30;
		} else if(monthIndex == 2) {
			if(isLeapYear == true) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return 0;
		}
	}
	
	/**
	 * Calculates the index of the first day of the week in a specified month.
	 * The index returned corresponds to position of this first day of the week
	 * within the DAYS_OF_WEEK class field.
	 * @param month which may or may not be abbreviated to 3 or more characters
	 * @param year of month to determine the first day from (Gregorian Calendar AD)
	 * 		String must contain the digits of a single non-negative int  for year.
	 * @return index within DAYS_OF_WEEK of specified month's first day 
	 */
	public static int getFirstDayOfWeekInMonth(String month, String year) {
		int monthNum = getMonthIndex(month);
		int yearNum  = Integer.parseInt(year);
		if (monthNum == 1) 
        { 
            monthNum = 13; 
            yearNum--; 
        } 
        if (monthNum == 2) 
        { 
            monthNum = 14; 
            yearNum--; 
        }  
        int m = monthNum; 
        int i = yearNum % 100; 
        int j = yearNum / 100; 
        int k = 1 + 13*(m + 1) / 5 + i + i / 4 + j / 4 + 5 * j; 
        k = k % 7; 
        switch (k) 
        { 
            case 0 : return 5 ;  
            case 1 : return 6 ;  
            case 2 : return 0 ; 
            case 3 : return 1 ; 
            case 4 : return 2 ; 
            case 5 : return 3 ; 
            case 6 : return 4 ;
        } return 999;
	}
	
	/**
	 * Creates and initializes a 2D String array to reflect the specified month.
	 * The first row of this array [0] should contain labels representing the days
	 * of the week, starting with Monday, as abbreviated in DAYS_OF_WEEK.  Every  
	 * later row should contain dates under the corresponding days of week.
	 * Entries with no corresponding date in the current month should be filled 
	 * with a single period.  There should not be any extra rows that are either 
	 * blank, unused, or completely filled with periods. 
	 * For example, the contents for September of 2019 should look as follows,
	 * where each horizontal row is stored in different array within the 2d result: 
	 * 
	 * MON TUE WED THU FRI SAT SUN  
	 *  .   .   .   .   .   .   1   
	 *  2   3   4   5   6   7   8   
	 *  9   10  11  12  13  14  15  
	 *  16  17  18  19  20  21  22  
	 *  23  24  25  26  27  28  29  
	 *  30  .   .   .   .   .   .  
	 *  
	 * @param month which may or may not be abbreviated to 3 or more characters
	 * @param year of month generate calendar for (Gregorian Calendar AD) 
	 *    String must contain the digits of a single non-negative int for year.
	 * @return 2d array of strings depicting the contents of a calendar
	 */
	public static String[][] generateCalendar(String month, String year){
		int firstDay = getFirstDayOfWeekInMonth(month, year);
		int numDays  = getNumberOfDaysInMonth(month, year);
		String[][] calendar = new String[7][7];
		for (int x=0; x<=6; x++) {
			calendar[0][x] = DAYS_OF_WEEK[x];
		}
		int dateOffset = firstDay;
		int date       = 1;
		for(int i = 1 ; i<=6; i++) {
			for(int j = 0; j<=6; j++) {
				if(dateOffset != 0) {
					dateOffset--;
					calendar[i][j] = ".";
					continue;
				}
				if(date>28) {
					if(date > numDays) {
						if(j == 0) {
							break;
						} else {
							calendar[i][j] = ".";
						}
					} else {
						calendar[i][j] = Integer.toString(date);
						date++;
					}
				} else {
					calendar[i][j] = Integer.toString(date);
					date++;
					
				}
			}
		} return calendar;
	}
	
	/**
	 * Prints out the beginning of application
	 */
	public static void start(){
		System.out.println("Welcome to the Calendar Printer.");
		System.out.println("=================================");
	}
	
	/**
	 * Prompts for the month and year input and then prints out 
	 * the calendar from the array in generateCalendar()
	 */
	public static void operation() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the month to print: ");
		String inputMonth = input.nextLine();
		System.out.print("Enter the year to print: ");
		String inputYear = input.nextLine();
		String[][] calendar = generateCalendar(inputMonth, inputYear);
		for(int k=0; k<=5; k++) {
			System.out.print(calendar[0][k] + " ");
		}
		System.out.println(calendar[0][6]);
		for(int i=1; i<=6; i++) {
			for(int j=0; j<=6; j++) {
				if (calendar[i][j] == null) {
					break;
				}
				if (calendar[i][j].length() == 1) {
					System.out.print(" " + calendar[i][j] + "  ");
				}else {
					System.out.print(" " + calendar[i][j] + " ");
				}
				if(j==6) {
					System.out.println();
				}
			}
		}
	}
	
	/**
	 * Prints out the ending sentences of the program
	 */
	public static void end() {
		System.out.println("=================================");
		System.out.println("Thanks, and have a nice day.");
	}
	
	public static void main(String[] args) {
		start();
		operation();
		end();
	}
}
