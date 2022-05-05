package misl.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateFromString {
	String strtime;
	public Date date;

	public DateFromString() {
		date = Calendar.getInstance().getTime();
	}

	public DateFromString(String dbtime) {
		if (checkformat(dbtime, "yyyy-MM-dd HH:mm:ss.S")) {
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(dbtime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (checkformat(dbtime, "yyyy-MM-dd HH:mm:ss")) {
			try {
				date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dbtime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (checkformat(dbtime, "yyyy-MM-dd")) {
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(dbtime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(dbtime + " is valid date format");
		}
	}

	public Boolean checkformat(String strDate, String format) {
		SimpleDateFormat sdfrmt = new SimpleDateFormat(format);
		sdfrmt.setLenient(false);
		try {
			@SuppressWarnings("unused")
			Date javaDate = sdfrmt.parse(strDate);
			return true;
		} catch (ParseException e) {
//	        System.out.println(strDate+" is Invalid Date format");
			return false;
		}
	}

	public String getMonth(int month) {
		String strmonth;
		switch (month) {
		case 1:
			strmonth = "มกราคม";
			break;
		case 2:
			strmonth = "กุมภาพันธ์";
			break;
		case 3:
			strmonth = "มีนาคม";
			break;
		case 4:
			strmonth = "เมษายน";
			break;
		case 5:
			strmonth = "พฤษภาคม";
			break;
		case 6:
			strmonth = "มิถุนายน";
			break;
		case 7:
			strmonth = "กรกฎาคม";
			break;
		case 8:
			strmonth = "สิงหาคม";
			break;
		case 9:
			strmonth = "กันยายน";
			break;
		case 10:
			strmonth = "ตุลาคม";
			break;
		case 11:
			strmonth = "พฤศจิกายน";
			break;
		case 12:
			strmonth = "ธันวาคม";
			break;
		default:
			strmonth = "มกราคม";
			break;
		}
		return strmonth;
	}
	
	public String getMonthShort(int month) {
		String strmonth;
		switch (month) {
		case 1:
			strmonth = "ม.ค.";
			break;
		case 2:
			strmonth = "ก.พ.";
			break;
		case 3:
			strmonth = "มี.ค.";
			break;
		case 4:
			strmonth = "เม.ย.";
			break;
		case 5:
			strmonth = "พ.ค.";
			break;
		case 6:
			strmonth = "มิ.ย.";
			break;
		case 7:
			strmonth = "ก.ค.";
			break;
		case 8:
			strmonth = "ส.ค.";
			break;
		case 9:
			strmonth = "ก.ย.";
			break;
		case 10:
			strmonth = "ต.ค.";
			break;
		case 11:
			strmonth = "พ.ย.";
			break;
		case 12:
			strmonth = "ธ.ค.";
			break;
		default:
			strmonth = "ม.ค.";
			break;
		}
		return strmonth;
	}

	public String toDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime());
	}

	public String toDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(cal.getTime());
	}

	public String toDateTimeMilli() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S").format(cal.getTime());
	}

	public String toMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd " + getMonth(cal.get(Calendar.MONTH) + 1) + " yyyy").format(cal.getTime());
	}

	public String toMonthDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd " + getMonth(cal.get(Calendar.MONTH) + 1) + " พ.ศ. yyyy").format(cal.getTime());
	}
	
	public String toMonthShortDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd " + getMonthShort(cal.get(Calendar.MONTH) + 1) + " yyyy").format(cal.getTime());
	}

	public String toMonthDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd " + getMonth(cal.get(Calendar.MONTH) + 1) + " พ.ศ. yyyy HH:mm:ss")
				.format(cal.getTime());
	}
	
	public String toMonthShortDateYearThai() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd " + getMonthShort(cal.get(Calendar.MONTH) + 1) + " yyyy").format(cal.getTime());
	}
	public String toMonthShortDateTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd " + getMonthShort(cal.get(Calendar.MONTH) + 1) + " yyyy HH:mm:ss")
				.format(cal.getTime());
	}

	public String toMonthDateTimeMilli() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat("dd " + getMonth(cal.get(Calendar.MONTH) + 1) + " พ.ศ. yyyy HH:mm:ss.S")
				.format(cal.getTime());
	}

	public String toOnlyMonth() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return new SimpleDateFormat("MM").format(cal.getTime());
	}

	public String toOnlyThaiMonthYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat(getMonth(cal.get(Calendar.MONTH) + 1) + " yyyy").format(cal.getTime());
	}
	
	public String toOnlyThaiMonthShortYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 543);
		return new SimpleDateFormat(cal.get(Calendar.MONTH) + 1 + " - yyyy").format(cal.getTime());
//		return new SimpleDateFormat(getMonthShort(cal.get(Calendar.MONTH) + 1) + " yyyy").format(cal.getTime());

	}


	public String toMinDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return new SimpleDateFormat("yyyy-MM-01").format(cal.getTime());
	}

	public String toMaxDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	}

	public void addDay(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, day);
		date = cal.getTime();
	}

	public void addMonth(int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		date = cal.getTime();
	}

	public void addYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, year);
		date = cal.getTime();
	}

	public void delDay(int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, -day);
		date = cal.getTime();
	}

	public void delMonth(int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -month);
		date = cal.getTime();
	}

	public void delYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -year);
		date = cal.getTime();
	}

	public long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public Date getTypeDate() {
		return date;
	}

	public Calendar getTypeCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public String addDayDew(String day, int total) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = df.parse(day);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, total); // Add Day
			day = df.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return day;
	}

	public String ConvertDateStringFormat(String date) {
		String reformattedStr = null;
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			reformattedStr = Format.format(fromUser.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return reformattedStr;
	}
}
