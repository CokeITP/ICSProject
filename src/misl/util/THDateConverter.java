package misl.util;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ThaiBuddhistChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DecimalStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Locale;

//THDateConverterUtil By Soft
public class THDateConverter {

	public THDateConverter() {
		// TODO Auto-generated constructor stub
	}

	//////////////////////////////////////////
	@SuppressWarnings("unused")
	private void Example() { // ตัวอย่าง
		String dt1 = "12/01/2563";
		String dt2 = "2020-04-18";
		String dt3 = "12/01/2020";
		String dt4 = "2563/03/15";
		String dt5 = "2563-08-30";

		System.out.println(toISODate(dt1)); // 2020-01-12
		System.out.println(toTHDate(dt2)); // 18/04/2563
		System.out.println(toTHDate(dt2, "dd-MM-yyyy")); // 18-04-2563
		System.out.println(toTHDate(dt3, "dd/MM/yyyy", "dd-MM-yyyy")); // 12-01-2563
		System.out.println(toISODate(dt4, "yyyy/MM/dd", "dd/MM/yyyy")); // 15/03/2020
		System.out.println(toISODate(dt5, "yyyy-MM-dd", "dd/MM/yyyy")); // 30/08/2020
	}
	/////////////////////////////////////////

	// เฉพาะ yyyy-MM-dd เท่านั้น
	public String toTHDate(String isoDate) { // Ex. ("2020-01-15") แปลงออกมาเป็น 15/01/2563
		if (!isoDate.isEmpty()) {
			LocalDate local = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			ChronoLocalDate cDate = ThaiBuddhistChronology.INSTANCE.date(local);
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return dateFormatter.format(cDate);
		} else {
			return "";
		}
	}

	public String toTHDate(String isoDate, String dfPattern) { // Ex. ("2020-01-15","yyyy/MM/dd") แปลงออกมาเป็น 2563/01/15
		if (!isoDate.isEmpty()) {
			LocalDate local = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			ChronoLocalDate cDate = ThaiBuddhistChronology.INSTANCE.date(local);
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dfPattern);
			return dateFormatter.format(cDate);
		} else {
			return "";
		}
	}

	public String toTHDate(String isoDate, String dfPattern1, String dfPattern2) { // Ex. ("2020/01/15","yyyy/MM/dd","dd-MM-yyyy") แปลงออกมาเป็น 15-01-2563
		if (!isoDate.isEmpty()) {
			LocalDate local = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern(dfPattern1));
			ChronoLocalDate cDate = ThaiBuddhistChronology.INSTANCE.date(local);
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dfPattern2);
			return dateFormatter.format(cDate);
		} else {
			return "";
		}
	}

	// เฉพาะ dd/MM/yyyy เท่านั้น
	public String toISODate(String text) { // Ex. ("15/01/2563") แปลงออกมาเป็น 2020-01-15
		DateTimeFormatter df = new DateTimeFormatterBuilder()
				.parseLenient()
				.appendPattern("dd/MM/yyyy")
				.toFormatter()
				.withChronology(ThaiBuddhistChronology.INSTANCE)
				.withDecimalStyle(DecimalStyle.of(Locale.getDefault(Locale.Category.FORMAT)));
		TemporalAccessor temporal = df.parse(text);
		ChronoLocalDate cDate = ThaiBuddhistChronology.INSTANCE.date(temporal);
		return LocalDate.from(cDate).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

	}

	public String toISODate(String text, String dfPattern) { // Ex. ("15/01/2563","dd/MM/yyyy") แปลงออกมาเป็น 15/01/2020
		DateTimeFormatter df = new DateTimeFormatterBuilder()
				.parseLenient()
				.appendPattern("dd/MM/yyyy").toFormatter()
				.withChronology(ThaiBuddhistChronology.INSTANCE)
				.withDecimalStyle(DecimalStyle.of(Locale.getDefault(Locale.Category.FORMAT)));
		TemporalAccessor temporal = df.parse(text);
		ChronoLocalDate cDate = ThaiBuddhistChronology.INSTANCE.date(temporal);

		return LocalDate.from(cDate).format(DateTimeFormatter.ofPattern(dfPattern));

	}

	public String toISODate(String text, String dfPattern1, String dfPattern2) { // Ex. ("15-01-2563","dd-MM-yyyy","yyy/MM/dd") แปลงออกมาเป็น 2020/01/15
		DateTimeFormatter df = new DateTimeFormatterBuilder()
				.parseLenient()
				.appendPattern(dfPattern1)
				.toFormatter()
				.withChronology(ThaiBuddhistChronology.INSTANCE)
				.withDecimalStyle(DecimalStyle.of(Locale.getDefault(Locale.Category.FORMAT)));
		TemporalAccessor temporal = df.parse(text);
		ChronoLocalDate cDate = ThaiBuddhistChronology.INSTANCE.date(temporal);

		return LocalDate.from(cDate).format(DateTimeFormatter.ofPattern(dfPattern2));

	}
	
	
	public String toTHShortMonthDate(String isoDate) { // Ex. ("2020-01-15") แปลงออกมาเป็น 15 มกราคม 2563
		if (!isoDate.isEmpty()) {
			LocalDate local = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			ChronoLocalDate cDate = ThaiBuddhistChronology.INSTANCE.date(local);
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("th", "TH"));
			return dateFormatter.format(cDate);
		} else {
			return "";
		}
	}
	
	public String toTHShortMonthDate(String isoDate,String pattern) { // Ex. ("2020-01-15") แปลงออกมาเป็น 15 มกราคม 2563
		if (!isoDate.isEmpty()) {
			LocalDate local = LocalDate.parse(isoDate, DateTimeFormatter.ofPattern(pattern));
			ChronoLocalDate cDate = ThaiBuddhistChronology.INSTANCE.date(local);
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("th", "TH"));
			return dateFormatter.format(cDate);
		} else {
			return "";
		}
	}
	
	
	//###########################################################
	
	public String swapPattern(String text){ // swapPattern("12/05/2020") --> 2020-05-12
		String[] temp = text.split("/");
		return Arrays.stream(temp).reduce((y, z) -> z + "-" + y).get();
	}
	
	public String swapPattern(String text, String d){ // swapPattern("12/05/2020") --> 2020-05-12
		String[] temp = text.split(d);
		return Arrays.stream(temp).reduce((y, z) -> z + "-" + y).get();
	}
	
	
	public String swapTHPattern(String text){ // swapTHPattern("01/02/2563") --> 2020-02-01
			String[] temp = text.split("/");
			return Arrays.stream(temp).map(x -> x.length() == 4 ? String.valueOf(Integer.parseInt(x)-543) : x).reduce((y, z) -> z + "-" + y).get();
		}
	

}
