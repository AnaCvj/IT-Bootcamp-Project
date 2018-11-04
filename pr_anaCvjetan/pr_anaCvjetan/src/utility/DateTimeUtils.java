package utility;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class DateTimeUtils {
	public static LocalDate StringToDate(String dateStr)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		return date;
	}
	
	public static int MonthsBetweenTwoDates(LocalDate first, LocalDate second)
	{
		Period period = Period.between(first, second);
	    int diff = period.getMonths();
	    return diff;
	}

}
