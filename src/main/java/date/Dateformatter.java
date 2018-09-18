package date;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Dateformatter {
	public static void main(String[] str) {
		String input = "Sat, 06-Oct-18 12:45:32 GMT";
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("eee, dd-MMM-yy HH:mm:ss zzz");
		ZonedDateTime ldt =  ZonedDateTime.parse(input, dateTimeFormatter);
		System.out.println(ldt);
		System.out.println(ldt.getDayOfWeek());
		System.out.println(ldt.getZone());
	}
}
