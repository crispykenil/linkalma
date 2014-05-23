package com.linkalma.utils;


import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

/*import org.apache.commons.lang.StringUtils;
*/import org.springframework.beans.BeanUtils;


public class CommonDataUtil {
/*
	*//**
	 * This method is used to copy identical properties using Spring's utility.
	 * 
	 * @param targetVO -
	 *            BaseVO type to which values need to be copied.
	 * @param sourceVO -
	 *            BaseVO type from which values need to be copied.
	 *//*
	public static void copyVO(Object targetVO, Object sourceVO) {

		BeanUtils.copyProperties(sourceVO, targetVO);

	}

	*//**
	 * This method is used to copy identical properties using Spring's utility.
	 * 
	 * @param targetVO-
	 *            BaseVO type to which values need to be copied.
	 * @param sourceVO -
	 *            BaseVO type from which values need to be copied.
	 * @param ignorePropeties -
	 *            Array of property names which have to be ignored
	 *//*
	public static void copyVO(Object targetVO, Object sourceVO,
			String[] ignorePropeties) {
		BeanUtils.copyProperties(sourceVO, targetVO, ignorePropeties);
	}

	public static String getUTCoffset(Date date) {
		String strdate = null;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		DateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss yyyy");

		TimeZone obj = TimeZone.getTimeZone("UTC");

		formatter.setTimeZone(obj);
		strdate = formatter.format(calendar.getTime());

		return strdate;

	}

	*//**
	 * This method is used to set start index for pagination
	 * 
	 * @param startIndex -
	 *            Gives the start index if available from input.
	 * @return Integer - returns the start index after setting its value to
	 *         either default or from input as applicable.
	 *//*
	public static Integer setDefaultStartIndex(Integer startIndex) {

		if (startIndex == null || startIndex <= 0) {
			startIndex = 1;
		}
		return startIndex;
	}

	*//**
	 * This method will check if a list is empty or null
	 * 
	 * @param list
	 *            refers to the list of objects which needs to be checked.
	 * @return boolean refers to the result if list was empty. Returns true for
	 *         an empty list.
	 *//*

	public static boolean checkIfListIsEmpty(List<? extends Object> list) {
		boolean isEmpty = true;
		if (list != null && !list.isEmpty()) {
			isEmpty = false;
		}
		return isEmpty;
	}

	*//**
	 * This method will check if a object is null
	 * 
	 * @param object
	 * @return boolean refers to the result if object was null. Returns true for
	 *         a null object.
	 *//*
	public static boolean checkIfObjectIsNull(Object object) {
		boolean isNull = true;
		if (null != object) {
			isNull = false;
		}
		return isNull;
	}

	*//**
	 * Returns a comma separated value of string equivalents of the objects in
	 * the argument List.
	 * 
	 * @param objects
	 *            A List of Object references.
	 * @return A comma separated String whose components are obtained by
	 *         invoking toString() on the objects in the argument List.
	 *//*
	public static String getListAsCommaSeparatedString(
			List<? extends Object> objects) {
		String objectsAsCommaSeparatedString = null;
		if (!checkIfListIsEmpty(objects)) {
			StringBuffer temp = new StringBuffer();
			for (Object object : objects) {
				temp.append(object.toString()).append(",");
			}
			objectsAsCommaSeparatedString = temp
					.deleteCharAt(temp.length() - 1).toString();
		}
		return objectsAsCommaSeparatedString;
	}

	*//**
	 * This method is used to determine if the bean is correct for insertion in
	 * ODS. If the bean is to be inserted in ODS and has sentinel value for all
	 * the attributes to be updated, the method would return false. This would
	 * thus prevent the insertion of a "shell" record.
	 * 
	 * @param bean
	 *            The Object to be inserted in ODS.
	 * @return true, if bean has an attribute with a non-sentinel/non-null
	 *         value. Else, the method returns false.
	 *//*
	public static boolean isBeanValidForUpdate(Object bean) {
		boolean nonNullAttributeFound = false;
		Class<? extends Object> cls = bean.getClass();
		Object attributeValue = null;
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector
					.getBeanInfo(cls).getPropertyDescriptors();
			for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
				Method method = propertyDescriptor.getReadMethod();
				DatabaseTableMapper columnFinder = method
						.getAnnotation(DatabaseTableMapper.class);
				
				 * try { if (columnFinder != null && (attributeValue =
				 * method.invoke(bean, (Object[]) null)) != null &&
				 * !String.valueOf(attributeValue).equals(GeneralConstants.DEFAULT_NULL_VALUE)) {
				 * nonNullAttributeFound = true; break; } } catch
				 * (InvocationTargetException e1) { e1.printStackTrace(); }
				 * catch (IllegalAccessException e2) { e2.printStackTrace(); }
				 
			}
		} catch (IntrospectionException e) {
		}
		return nonNullAttributeFound;

	}

	*//**
	 * Converts a comma separated list to an array list.
	 * 
	 * @param inParameters
	 * @return
	 *//*
	public static List<Object> convertToList(String inParameters) {
		List inParametersList = null;
		if (!StringUtils.isEmpty(inParameters)) {
			String[] temp = inParameters.split(",");
			inParametersList = Arrays.asList(temp);
		}
		return inParametersList;
	}

	*//**
	 * Returns a list of objects for a single object
	 * 
	 * @param object
	 * @return
	 *//*
	public static List<Object> getListOfObjects(Object object) {
		List<Object> objectList = new ArrayList<Object>();
		objectList.add(object);
		return objectList;
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	*//**
	 * This method checks if the string is null or empty
	 * 
	 * @param element
	 *            refers to the String object
	 * @return boolean refers to whether the string is null or empty
	 *//*
	public static boolean checkIfNullOrEmpty(String element) {
		boolean isNull = true;
		if (element != null && !element.trim().equals("")) {
			isNull = false;
			if (element.equalsIgnoreCase("null")
					|| element
							.equals(CommonGeneralConstants.DEFAULT_NULL_VALUE)) {
				isNull = true;
			}
		}
		return isNull;
	}

	*//**
	 * @param prescriptionFillDTO
	 *//*
	public static String formatPhoneNumber(String phoneNumber) {
		
		String phoneNbr = phoneNumber.replace(GeneralConstants.OPEN_PARENTHESES,
				GeneralConstants.EMPTY_STRING).replace(
						GeneralConstants.CLOSE_PARENTHESES,
						GeneralConstants.EMPTY_STRING).replace(GeneralConstants.HYPHEN,
						GeneralConstants.EMPTY_STRING);
		return phoneNbr.trim();

	}

	*//**
	 * @param phone
	 * @param reqPhone
	 *//*
	public static void standardizePhoneNumber(StringBuffer phone,
			StringBuffer reqPhone) {
		if(!checkIfNullOrEmpty(String.valueOf(phone)) && phone.length()<=9)
		{
			phone = padZeroesToPhone(phone);
		}
		if (!checkIfNullOrEmpty(String.valueOf(phone)) && phone.length() > 9) {
			reqPhone.append("(").append(phone.substring(0, 3)).append(")")
					.append(phone.substring(3, 6)).append(
							GeneralConstants.HYPHEN).append(
							phone.substring(6, phone.length()));
		}	
	}

	private static StringBuffer padZeroesToPhone(StringBuffer phone) {
		int countOfLeadingZero = 10-phone.length();
		StringBuffer zeros = new StringBuffer("");
		for (int i = 0; i < countOfLeadingZero; i++) {
			zeros.append("0");
		}
		phone=zeros.append(phone);
		return phone;
	}

	public static String getUserInitials(UserInfoBean userInfoBean) {

		StringBuffer stringBuffer = new StringBuffer(
				GeneralConstants.EMPTY_STRING);
		if (userInfoBean.getNoOfUsersLoggedIn() == 1) {

			if (!StringUtils.isEmpty(userInfoBean.getPrimaryFirstName())) {
				stringBuffer.append(userInfoBean.getPrimaryFirstName()
						.toUpperCase().charAt(0));
			}

			if (!StringUtils.isEmpty(userInfoBean.getPrimaryMiddleName())) {
				stringBuffer.append(userInfoBean.getPrimaryMiddleName()
						.toUpperCase().charAt(0));
			}

			if (!StringUtils.isEmpty(userInfoBean.getPrimaryLastName())) {
				stringBuffer.append(userInfoBean.getPrimaryLastName()
						.toUpperCase().charAt(0));
			}

		} else {

			if (!StringUtils.isEmpty(userInfoBean.getSecondaryFirstName())) {
				stringBuffer.append(userInfoBean.getSecondaryFirstName()
						.toUpperCase().charAt(0));
			}

			if (!StringUtils.isEmpty(userInfoBean.getSecondaryMiddleName())) {
				stringBuffer.append(userInfoBean.getSecondaryMiddleName()
						.toUpperCase().charAt(0));
			}

			if (!StringUtils.isEmpty(userInfoBean.getSecondaryLastName())) {
				stringBuffer.append(userInfoBean.getSecondaryLastName()
						.toUpperCase().charAt(0));
			}

		}
		return stringBuffer.toString();
	}

	public static String getUserInitialsFromRecieveView(UserDTO userDTO) {

		StringBuffer stringBuffer = new StringBuffer(
				GeneralConstants.EMPTY_STRING);

		if (!StringUtils.isEmpty(userDTO.getPhrmStaffFirstName())) {
			stringBuffer.append(userDTO.getPhrmStaffFirstName().toUpperCase()
					.charAt(0));
		}

		if (!StringUtils.isEmpty(userDTO.getPhrmStaffMidInit())) {
			stringBuffer.append(userDTO.getPhrmStaffMidInit().toUpperCase()
					.charAt(0));
		}

		if (!StringUtils.isEmpty(userDTO.getPhrmStaffLastName())) {
			stringBuffer.append(userDTO.getPhrmStaffLastName().toUpperCase()
					.charAt(0));
		}

		return stringBuffer.toString();
	}

	public static String getUserInitialsFromSoldQueue(
			SoldQueueResultDTO soldQueueResultDTO) {

		StringBuffer stringBuffer = new StringBuffer(
				GeneralConstants.EMPTY_STRING);

		if (!StringUtils.isEmpty(soldQueueResultDTO
				.getSecondaryPharmFirstName())) {
			stringBuffer.append(soldQueueResultDTO.getSecondaryPharmFirstName()
					.toUpperCase().charAt(0));
		}

		if (!StringUtils.isEmpty(soldQueueResultDTO.getSecondaryPharmMidInit())) {
			stringBuffer.append(soldQueueResultDTO.getSecondaryPharmMidInit()
					.toUpperCase().charAt(0));
		}

		if (!StringUtils
				.isEmpty(soldQueueResultDTO.getSecondaryPharmLastName())) {
			stringBuffer.append(soldQueueResultDTO.getSecondaryPharmLastName()
					.toUpperCase().charAt(0));
		}

		return stringBuffer.toString();
	}

	public static Date validateDateFormat(String indate) throws ParseException {
		List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>();
		dateFormats.add(new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a"));
		Date date = null;
		for (SimpleDateFormat format : dateFormats) {
			format.setLenient(false);
			date = format.parse(indate);
		}

		return date;
	}

	*//**
	 * @return the consultationLogger
	 *//*
	public ConsultationLogger getConsultationLogger() {
		return consultationLogger;
	}

	*//**
	 * @param consultationLogger
	 *            the consultationLogger to set
	 *//*
	public void setConsultationLogger(ConsultationLogger consultationLogger) {
		this.consultationLogger = consultationLogger;
	}

	public static String concatenate(String s1, String s2, char delimiter){
		StringBuffer temp = new StringBuffer();
		if(!StringUtils.isEmpty(s1)){
			temp.append(s1).append(delimiter);
		}
		
		if(!StringUtils.isEmpty(s2)){
			temp.append(s2).append(delimiter);
		}
		
		String objectsAsCommaSeparatedString = temp
		.deleteCharAt(temp.length() - 1).toString();
		
		return objectsAsCommaSeparatedString;
	}
*/
	}
