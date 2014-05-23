package com.linkalma.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.time.DateUtils;

public final class DateUtil {
/*
	static final long ONE_HOUR = 60 * 60 * 1000L;

	*//**
	 * DateType formats.
	 *//*
	private static final String[] DATE_TYPES = {
			CommonGeneralConstants.TIME_EA_READ_DTTM_FORMAT,
			CommonGeneralConstants.TIME_EA_UPDATE_DTTM_FORMAT,
			CommonGeneralConstants.DATE_TIME_FORMAT,
			CommonGeneralConstants.DATE_FORMAT };

	*//**
	 * This methods takes in a java.util.Date object and in turn returns a
	 * String.
	 * 
	 * @param date -
	 *            java.util.Date Object
	 * @return dateString - the String value of the date passed.
	 *//*
	public static String dateToString(Date date) {
		String dateString = "";
		if (date != null) {
			dateString = date.toString();
		}
		return dateString;
	}

	*//**
	 * Converts a String to date
	 * 
	 * @param stringDate
	 *            in the format specified in input
	 * @return date
	 *//*
	public static Date convertToDate(String stringDate, String dateFormat)
			throws ParseException {
		Date date = null;

		if (stringDate != null) {
			SimpleDateFormat sdf2 = new SimpleDateFormat(dateFormat);

			date = sdf2.parse(stringDate);

		}
		return date;

	}

	*//**
	 * This method computes the difference between two dates.
	 * 
	 * @param date -
	 *            input date.
	 * @return age - returns difference in years.
	 *//*
	public static String dateDiff(String date) {

		SimpleDateFormat format = new SimpleDateFormat(
				CommonServiceConstants.DATE_FORMAT);
		Date birthDate = null;
		try {
			birthDate = format.parse(date);
		} catch (ParseException e) {
			return "";
		}
		String age = "";
		Date currentDate = new Date();
		long days = (((currentDate.getTime() - birthDate.getTime()) + ONE_HOUR) / (ONE_HOUR * 24));
		long year = days / 365;

		if (year >= 1) {
			age = String.valueOf(year);
		} else if (year >= 0 && year < 1 && days >= 0) {
			age = "<1";
		}
		return age;

	}

	*//**
	 * This method computes the difference between two dates. Calulates the
	 * difference of first from the second date.
	 * 
	 * @param date -
	 *            firstDate.
	 * @param date -
	 *            secondDate.
	 * @return age - returns difference in years.
	 *//*
	public static String dateDiff(String firstDate, String secondDate) {
		SimpleDateFormat format = new SimpleDateFormat(
				CommonServiceConstants.DATE_FORMAT);
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = format.parse(firstDate);
			date2 = format.parse(secondDate);
		} catch (ParseException e) {
			return "";
		}
		long days = ((date2.getTime() - date1.getTime()) / (ONE_HOUR * 24));
		return String.valueOf(days);
	}

	*//**
	 * This method deducts no of days from the passed date and returns it.
	 * 
	 * @param firstDate
	 *            Date
	 * @param noOfDays
	 *            int
	 * @return Date
	 *//*
	public static Date deductNoOfDaysFromDate(Date firstDate, int noOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(firstDate);
		cal.add(Calendar.DAY_OF_YEAR, -noOfDays);
		Date chngdDate = cal.getTime();
		return chngdDate;
	}

	*//**
	 * This method converts date to string in a given format.
	 * 
	 * @param d -
	 *            Date
	 * @param timeFormat -
	 *            String
	 * @return String
	 *//*
	public static String convertDateToString(Date date, String timeFormat) {
		String newDate = null;
		if (date != null) {
			SimpleDateFormat sdfDate = new SimpleDateFormat(timeFormat);
			newDate = sdfDate.format(date);
		}
		return newDate;

	}

	*//**
	 * This method adds no of days to the date passed as input
	 * 
	 * @param firstDate
	 *            Date
	 * @param noOfDays
	 *            int
	 * @return Date
	 *//*
	public static Date addNoOfDaysFromDate(Date firstDate, int noOfDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(firstDate);
		cal.add(Calendar.DAY_OF_YEAR, noOfDays);
		Date chngdDate = cal.getTime();
		return chngdDate;
	}

	*//**
	 * This method adds no of days to the date passed as input
	 * 
	 * @param firstDate
	 *            Date
	 * @param noOfDays
	 *            int
	 * @return Date
	 *//*
	public static Date addNoOfYearFromDate(Date firstDate, int noOfYear) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(firstDate);
		cal.add(Calendar.YEAR, noOfYear);
		Date chngdDate = cal.getTime();
		return chngdDate;
	}

	*//**
	 * Truncates the time part from the Date in the input argument
	 * 
	 * @param date
	 *            The Date object from which the time is to be truncated.
	 * @return The Date object with time reset to all zeroes.
	 *//*
	public static Date truncateTime(Date date) {

		Date dateWithTimeTruncated = null;
		if (date != null) {
			dateWithTimeTruncated = DateUtils.truncate(date, Calendar.DATE);
		}
		return dateWithTimeTruncated;
	}

	*//**
	 * Converts java.util.Date to XMLGregorianCalendar date object
	 * 
	 * @param inpDate
	 *            date Object
	 * @return XMLGregorianCalendar XML Gregorian Calendar Object
	 * @throws DatatypeConfigurationException
	 *//*
	public static XMLGregorianCalendar convertDateTimeToXMLGregorian(
			Date inpDate) throws DatatypeConfigurationException {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inpDate.getTime());
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
	}

	*//**
	 * Converts java.util.Date to XMLGregorianCalendar date object
	 * 
	 * @param inpDate
	 *            date Object
	 * @return XMLGregorianCalendar XML Gregorian Calendar Object
	 * @throws DatatypeConfigurationException
	 *//*
	public static Date convertXMLGregorianToDate(
			XMLGregorianCalendar xmlDateTime) {

		if (null != xmlDateTime) {
			return xmlDateTime.toGregorianCalendar().getTime();
		}
		return null;
	}

	*//**
	 * Converts java.util.Date to XMLGregorianCalendar date object without time
	 * zone in it
	 * 
	 * @param inpDate
	 *            date Object
	 * @return XMLGregorianCalendar XML Gregorian Calendar Object
	 * @throws DatatypeConfigurationException
	 *//*
	public static XMLGregorianCalendar convertDateTimeToXMLGregorianWithoutTimeZone(
			Date inpDate) throws DatatypeConfigurationException {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTimeInMillis(inpDate.getTime());
		XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance()
				.newXMLGregorianCalendar(gc);
		xmlDate.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
		return xmlDate;
	}

	*//**
	 * This method tries to convert the input date as a string to date using
	 * valrious available formats.
	 * 
	 * @param dateAsString
	 * @return
	 *//*
	public static Date convertStringToDateForVariousFormats(String dateAsString) {
		Date date = null;

		if (!StringUtils.isEmpty(dateAsString)) {

			for (String dateFormat : DATE_TYPES) {
				try {
					date = DateUtil.convertToDate(dateAsString, dateFormat);
					break;
				} catch (ParseException e) {

				}
			}

		}
		return date;
	}

	public static String calculateTimeDifference(Date dateStart, Date dateStop) {

		long diff = dateStop.getTime() - dateStart.getTime();
		long diffMinutes = diff / (60 * 1000);

		return String.valueOf(diffMinutes);
	}

	public static Date getUTCoffset(Date date) {
		String strdate = null;
		// Custom date format
		SimpleDateFormat format = new SimpleDateFormat(
				GeneralConstants.UPDATE_DTTM_FORMAT);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		DateFormat formatter = new SimpleDateFormat(
				GeneralConstants.UPDATE_DTTM_FORMAT);
		Date d1 = null;

		TimeZone obj = TimeZone.getTimeZone("UTC");

		formatter.setTimeZone(obj);
		strdate = formatter.format(calendar.getTime());

		try {
			d1 = format.parse(strdate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return d1;

	}

	public static Date getUTCoffsetTime(Date date) {
		String strdate = null;
		Date returnDate = null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		DateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy");

		TimeZone obj = TimeZone.getTimeZone("UTC");

		formatter.setTimeZone(obj);
		strdate = formatter.format(calendar.getTime());
		try {
			returnDate = formatter.parse(strdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnDate;

	}

	public static Date addMinutesToDate(Date date, int minutesToAdd) {
		Date computedDate = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		 * calendar.set( calendar.get(Calendar.YEAR), 0,
		 * calendar.get(Calendar.DAY_OF_YEAR));
		 
		calendar.add(Calendar.MINUTE, minutesToAdd);
		
		computedDate = calendar.getTime();
		return computedDate;
	}

	*//**
	 * Accepts formatted database date which is in CST format. First converts
	 * this date to UTC time zone. Accepts localOffset which is sent from client
	 * side and add this offset to UTC date. Formats the result date according
	 * to original date format. Return formatted date string.
	 * 
	 * @param cstTime
	 * @param localOffset
	 * @return formatted date
	 * @throws ParseException 
	 *//*
	public static String convertCSTDateToLocalTime(String cstTime,
			int localOffset) throws ParseException {
		String localDateString = "";
		DateFormat dbFormat = new SimpleDateFormat(GeneralConstants.DB_FORMAT);
		
			
			Date cstDateFromDB = dbFormat.parse(cstTime);
			Date utcDate = DateUtil.getUTCoffsetTime(cstDateFromDB);
			Date localDate = DateUtil.addMinutesToDate(utcDate, localOffset);
			localDateString = dbFormat.format(localDate);

		
		return localDateString;
	}
	
	// MCA-CR-122 Start
	
	*//**
	 * This method returns the current system date or you can add and subtract months 
	 * @param int monthsToAddSub
	 * @return String
	 *//*
	public static String addSubtractMonthsToSystemDate(int monthsToAddSub){
		Date computedDate = null;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, monthsToAddSub);
		computedDate = calendar.getTime();
		String modifiedDate = new SimpleDateFormat("MM/dd/yyyy").format(computedDate);
		return modifiedDate;
	}
	//	MCA-CR-122 End
	
	
	*//**
	 * Accepts formatted date which is in local format. Accepts cstOffset which is sent from DB
	 * side and add negative of this offset to local date. Formats the result date according
	 * to original date format. Return formatted date string.
	 * 
	 * @param localTime
	 * @param localOffset
	 * @return formatted date
	 * @throws ParseException 
	 *//*
	public static String convertLocalDateToCSTTime(String localTime,
			int localOffset) throws ParseException {
		String cstDateString = "";
		DateFormat dbFormat = new SimpleDateFormat(GeneralConstants.DB_FORMAT_HH_MM);
		
			
			Date cstDateFromDB = dbFormat.parse(localTime);
			
			Date localDate = DateUtil.addMinutesToDate(cstDateFromDB, -localOffset);
			cstDateString = dbFormat.format(localDate);

		
		return cstDateString;
	}

	public static int convertOffsetHoursToMinutes(String offSet){
		String[] arrTZ = offSet.split(GeneralConstants.COLON);
		String tzH = arrTZ[0];
		String tzM = arrTZ[1];
		String tzHTemp = tzH.replace("+", "");

		int tz_H = Integer.parseInt(tzHTemp);
		int tz_M = Integer.parseInt(tzM);
		if (tzHTemp.substring(0, 1).equals("-")) {
			tz_M = tz_M * -1;
		}
		tz_M = (tz_H * 60) + tz_M;
		return tz_M;
	}
	 
	** Method to Calculate Local datetime correspondent to CST datetime.
	** Param : Date fromat "MM/dd/yyyy hh:mm a"
	** param : -/+ Minutes
		
	public static String convertIntoLocal(String strDbCstDate,
				int localOffsetwrtGMTInMinutes) 
		{
		SimpleDateFormat sdf = new SimpleDateFormat(GeneralConstants.DB_FORMAT);
		Date dbDateCSTObj = null;
		Date localDate = null;
		String finalLocalFormat = null;
		TimeZone tzCST = TimeZone.getTimeZone("GMT-6");
		long cstInMiliSeconds = 0;
		try {
			dbDateCSTObj = sdf.parse(strDbCstDate);
			cstInMiliSeconds = dbDateCSTObj.getTime();

			// Getting Daylight offset or Non Daylight offset from the date
			int cstOffsetwrtGMT = tzCST.getOffset(cstInMiliSeconds);

			// Converting offset from milisecond to minutes
			int cstOffsetwrtGMTInMinutes = cstOffsetwrtGMT / (60 * 1000);

			//Process to convert CST to Local datetime.

			long cstInMinutes = (cstInMiliSeconds / (60 * 1000));

			long localInMinutes = cstInMinutes
					- ((localOffsetwrtGMTInMinutes) + (cstOffsetwrtGMTInMinutes));

			localDate = new Date(localInMinutes * (60 * 1000));

			SimpleDateFormat dbFormat = new SimpleDateFormat(
					GeneralConstants.DB_FORMAT);

			finalLocalFormat = dbFormat.format(localDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//returning local date and time	
		return finalLocalFormat;
	}

	public static Date getCurrentDttm()
    {
        Calendar calendar = new GregorianCalendar();
        int cstoffset = -21600;
        int gmtoffset = calendar.get(15) / 1000;
        int totaloffset = cstoffset - gmtoffset;
        calendar.add(13, totaloffset);
        if(isDayLightOn())
            calendar.add(14, -calendar.get(16));
        Date currentTime = calendar.getTime();
        return currentTime;
    }

    public static boolean isDayLightOn()
    {
        boolean dayLight = false;
        Calendar calendar = new GregorianCalendar();
        Date dcurrentTime = calendar.getTime();
        SimpleDateFormat formater = new SimpleDateFormat("zzzzz");
        String zone = formater.format(dcurrentTime);
        if(zone != null && zone.indexOf("Daylight") != -1)
            dayLight = true;
        return dayLight;
    }

    public static String formatDateTime(Date date, String datetimeformat)
    {
        SimpleDateFormat sdfDate = new SimpleDateFormat(datetimeformat);
        String formattedDateTime = sdfDate.format(date);
        return formattedDateTime;
    }

*/
}

