package harshakr.HyperTestCore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {
	
	public DateUtils() {
		
	}

    // Get current date in a specified format
    public static String getCurrentDate(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().format(formatter);
    }

    // Get current date and time in a specified format
    public static String getCurrentDateTime(String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.now().format(formatter);
    }

    // Add days to the current date
    public static String addDaysToCurrentDate(int days, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().plusDays(days).format(formatter);
    }

    // Subtract days from the current date
    public static String subtractDaysFromCurrentDate(int days, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.now().minusDays(days).format(formatter);
    }

    // Convert a date string from one format to another
    public static String convertDateFormat(String date, String currentFormat, String targetFormat) {
        try {
            SimpleDateFormat currentFormatter = new SimpleDateFormat(currentFormat);
            SimpleDateFormat targetFormatter = new SimpleDateFormat(targetFormat);
            Date parsedDate = currentFormatter.parse(date);
            return targetFormatter.format(parsedDate);
        } catch (ParseException e) {
            throw new RuntimeException("Failed to parse date: " + e.getMessage(), e);
        }
    }

    // Get difference in days between two dates
    public static long getDaysDifference(String startDate, String endDate, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate start = LocalDate.parse(startDate, formatter);
        LocalDate end = LocalDate.parse(endDate, formatter);
        return java.time.temporal.ChronoUnit.DAYS.between(start, end);
    }

    // Validate if a date is in the correct format
    public static boolean isValidDate(String date, String format) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
            LocalDate.parse(date, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Get current timestamp
    public static String getCurrentTimestamp() {
        return LocalDateTime.now().toString();
    }
}

