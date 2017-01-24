import java.util.Calendar;
import java.util.GregorianCalendar ;



public class Format {

	static Calendar c = new GregorianCalendar(1995, GregorianCalendar.MAY, 23);

	public static void main (String [] args ) {

		System.out.format(args[0] + " did not match! ; HINT it was issued on %1$terd of some month \n", c);
		System.out.format("%s did not match! ; HINT it was issued on %1$terd of some month \n", args[0],c);
	}
}
